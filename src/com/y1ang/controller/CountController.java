package com.y1ang.controller;

import com.y1ang.entity.ProfitAndLoss;
import com.y1ang.service.IBatchService;
import com.y1ang.service.ICountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author y1ang
 * @Data 2018年10月13日-上午10:22:20
 * @Description
 */
@Controller
public class CountController {

    @Autowired
    private ICountService service;
    @Autowired
    private IBatchService ibs;

    private static int active;



    /**
     * 跳转到统计界面
     * @return
     */
    @RequestMapping("/count.html")
    public String toCountPage(Model model) {
        active = ibs.getStatusActiveBatchNumber();
        model.addAttribute("active",active);
        return "count.jsp";
    }

    /**
     * 盈亏账单
     * @return
     */
    @RequestMapping("/profitChart")
    @ResponseBody
    public ProfitAndLoss profitAndLossChart(){
        ProfitAndLoss profitAndLoss = service.getProfitAndLoss(active);
        return profitAndLoss;
    }

    /**
     * 饲料账单统计
     * @return
     */
    @RequestMapping("/feedChart")
    @ResponseBody
    public Map feedChart() {
        Map<String, Object> map = new HashMap(6);
        map.put("feedPaid", service.getPaidFeedAmount(active));
        map.put("feedUnPaid", service.getUnPaidFeedAmount(active));
        map.put("feedTotal", service.getAllFeedAmount(active));
        map.put("moneyPaid", service.getPaidMoney(active));
        map.put("moneyUnPaid", service.getUnPaidMoney(active));
        map.put("moneyTotal", service.getFeedMoney(active));
        return map;
    }

    /**
     * 小猪明细统计
     * @return
     */
    @RequestMapping("/pigletChart")
    @ResponseBody
    public Map<String, Object> pigletChart() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("pigletChart", service.getPigletMoney(active));
        return map;
    }

    /**
     * 卖猪详情统计
     * @return
     */
    @RequestMapping("/saleChart")
    @ResponseBody
    public Map<String, Object> saleChart() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("saleChart", service.getSaleMoney(active));
        return map;
    }

    /**
     * 疫苗账单统计
     * @return
     */
    @RequestMapping("/vaccineChart")
    @ResponseBody
    public Map<String,Object> vaccineChart(){
        Map<String,Object> map = new HashMap<>(2);
        map.put("vaccineTotal",service.getVaccineMoney(active));
        return map;
    }

    /**
     * 其他收支统计
     * @return
     */
    @RequestMapping("/otherChart")
    @ResponseBody
    public Map<String,Object> otherChart(){
        Map<String,Object> map = new HashMap<>(2);
        map.put("otherChart",service.getOtherMoney(active));
        return map;
    }
}
