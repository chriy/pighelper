package com.y1ang.controller;

import com.y1ang.entity.Buy;
import com.y1ang.entity.BuyJson;
import com.y1ang.entity.Page;
import com.y1ang.service.IBatchService;
import com.y1ang.service.IBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author y1ang
 * @Data 2018年10月13日-上午10:26:43
 * @Description 购买幼猪账单控制类
 */
@Controller
public class PigletController {

    @Autowired
    private IBuyService service;
    @Autowired
    private IBatchService ibs;

    @RequestMapping("/piglet.html")
    public String toPigletPage() {
        return "piglet.jsp";
    }

    /**
     * 显示所有幼猪账单数据
     *
     * @param limit
     * @param page
     * @return
     */
    @RequestMapping("/pigletrecord")
    @ResponseBody
    public BuyJson findAllBuyRecord(int limit, int page) {
        Page p = new Page((page - 1) * limit, limit);
        List<Buy> allBuyRecord = service.findAllBuyRecord(p);
        int count = service.getBuyCount();
        BuyJson json = new BuyJson(0, "200", count, allBuyRecord);
        return json;
    }

    /**
     * 跳转到添加小猪信息界面
     *
     * @return
     */
    @RequestMapping("/addpiglet.html")
    public String addPigletRecordPage() {
        return "addpiglet.jsp";
    }

    /**
     * 添加账单
     *
     * @param buy
     * @return
     */
    @RequestMapping("/addpiglet")
    @ResponseBody
    public String addPigletRecord(Buy buy) {
        int batchActive = ibs.getStatusActiveBatchNumber();
        buy.setBatchNumber(batchActive);
        System.out.println(buy.getBuyDate());
        int n = service.addBuyRecord(buy);
        if (n > 0) {
            return "OK";
        }
        return "FAIL";
    }

    /**
     * 通过id查询幼猪账单信息
     * 跳转到更新界面
     *
     * @param buyID
     * @param model
     * @return
     */
    @RequestMapping("/updatepiglet.html")
    public String findBuyRecordByID(int buyID, Model model) {
        Buy buyRecordByID = service.findBuyRecordByID(buyID);
        model.addAttribute("buy", buyRecordByID);
        return "updatepiglet.jsp";
    }

    /**
     * 更新账单
     * @param buy
     * @return
     */
    @RequestMapping("/updatepiglet")
    @ResponseBody
    public String updatePiglet(Buy buy){
        int n = service.updateBuyRecord(buy);
        if(n>0){
            return "OK";
        }
        return "FAIL";
    }

    /**
     * 删除账单
     * @param buyID
     * @return
     */
    @RequestMapping("/deletepiglet")
    @ResponseBody
    public String deletePigletRecord(int buyID){
        int n = service.deleteBuyRecord(buyID);
        if(n>0){
            return "OK";
        }
        return "FAIL";
    }

}
