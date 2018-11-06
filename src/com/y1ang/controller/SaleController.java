package com.y1ang.controller;

import com.y1ang.entity.Page;
import com.y1ang.entity.Sale;
import com.y1ang.entity.SaleJson;
import com.y1ang.service.IBatchService;
import com.y1ang.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 
 * @author y1ang
 * @Data 2018年10月15日-下午3:37:30
 * @Description 卖猪账单信息控制类
 */
@Controller
public class SaleController {

    @Autowired
    private ISaleService service;
    @Autowired
    private IBatchService ibs;

    /**
     * 跳转到账单界面
     * 
     * @return
     */
    @RequestMapping("/sale.html")
    public String toSalePage() {
        return "sale.jsp";
    }

    /**
     * 查询所有账单，展示
     * 
     * @param page
     * @param limit
     * @return
     */

    @RequestMapping("/salerecord")
    @ResponseBody
    public SaleJson getFeedRecord(int page, int limit) {
        SaleJson saleJson = new SaleJson();
        Page p = new Page((page - 1) * limit, limit);
        List<Sale> list = service.findSaleRecord(p);
        int activeBatch = ibs.getStatusActiveBatchNumber();
        saleJson.setCode(0);
        saleJson.setCount(service.getSaleCount(activeBatch));
        saleJson.setData(list);
        saleJson.setMsg("200");
        return saleJson;
    }

    @RequestMapping("/addsale.html")
    public String toAddSale() {
        return "addsale.jsp";
    }

    /**
     * 添加记录
     * 
     * @param sale
     * @return
     */
    @RequestMapping("/addsale")
    @ResponseBody
    public String insertSale(Sale sale) {
        // 总金额
        double saleAmount = sale.getSalePrice() * sale.getTotalWeight();
        sale.setSaleAmount(saleAmount);
        // 平均金额
        double averageMoney = sale.getSaleAmount() / sale.getSaleQuantity();
        sale.setAverageMoney(averageMoney);
        // 平均重量
        double averageWeight = sale.getTotalWeight() / sale.getSaleQuantity();
        sale.setAverageWeight(averageWeight);
        // 激活批次
        int activeBatch = ibs.getStatusActiveBatchNumber();

        sale.setBatchNumber(activeBatch);

        System.out.println("总金额：" + saleAmount);
        System.out.println("平均重量：" + averageWeight);
        System.out.println("平均价格：" + averageMoney);

        int n = service.insertSaleRecord(sale);
        if (n > 0) {
            return "OK";
        }
        return "FAIL";
    }

    /**
     * 通过id查询账单，跳转修改界面
     * 
     * @param saleID
     * @param model
     * @return
     */
    @RequestMapping("/updatesale.html")
    public String updateSale(int saleID, Model model) {
        Sale sale = service.finSaleRecordByID(saleID);
        model.addAttribute("sale", sale);
        return "updatesale.jsp";
    }

    /**
     * 修改卖猪账单
     * 
     * @param sale
     * @return
     */
    @RequestMapping("/updatesale")
    @ResponseBody
    public String updateSale(Sale sale) {
        // 总金额
        double saleAmount = sale.getSalePrice() * sale.getTotalWeight();
        sale.setSaleAmount(saleAmount);
        // 平均金额
        double averageMoney = sale.getSaleAmount() / sale.getSaleQuantity();
        sale.setAverageMoney(averageMoney);
        // 平均重量
        double averageWeight = sale.getTotalWeight() / sale.getSaleQuantity();
        sale.setAverageWeight(averageWeight);

        int n = service.updateSaleRecord(sale);
        if (n > 0) {
            return "OK";
        }
        return "FAIL";
    }

    /**
     * 删除卖猪记录
     * 
     * @param saleID
     * @return
     */
    @RequestMapping("/deletesale")
    @ResponseBody
    public String deleteSale(int saleID) {
        int n = service.deleteSaleRecord(saleID);
        if (n > 0) {
            return "OK";
        }
        return "FAIL";
    }
}
