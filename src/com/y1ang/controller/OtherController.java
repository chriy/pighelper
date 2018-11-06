package com.y1ang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.y1ang.entity.Other;
import com.y1ang.entity.OtherJson;
import com.y1ang.entity.Page;
import com.y1ang.service.IBatchService;
import com.y1ang.service.IOtherService;
/**
 * 
 * @author y1ang
 * @Data 2018年10月13日-上午10:26:06
 * @Description 其他账单控制类
 */
@Controller
public class OtherController {

    @Autowired
    private IOtherService service;
    @Autowired
    private IBatchService ibs;

    /**
     * 跳转到其他界面
     * 
     * @return
     */
    @RequestMapping("/other.html")
    public String toOtherPage() {
        return "other.jsp";
    }

    /**
     * 显示所有其他记录
     * 
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/allother")
    @ResponseBody
    public OtherJson findAllRecord(int page, int limit) {
        Page p = new Page((page - 1) * limit, limit);
        List<Other> list = service.findAllOtherRecord(p);
        int activeBatch = ibs.getStatusActiveBatchNumber();
        OtherJson oj = new OtherJson(0, "200", service.getOtherCount(activeBatch), list);
        return oj;
    }

    /**
     * 跳转到添加其他记录界面
     * 
     * @return
     */
    @RequestMapping("/addother.html")
    public String addOtherPage() {
        return "addother.jsp";
    }

    /**
     * 添加其他记录
     * 
     * @param other
     * @return
     */
    @RequestMapping("/addother")
    @ResponseBody
    public String addOther(Other other) {
        int batchNumber = ibs.getStatusActiveBatchNumber();
        other.setBatchNumber(batchNumber);
        int n = service.addOtherRecord(other);
        if (n > 0) {
            return "OK";
        }
        return "FAIL";
    }

    @RequestMapping("/updateother.html")
    public String toUpdatePage(int recordID, Model model) {
        Other other = service.findOtherRecordByID(recordID);
        model.addAttribute("other", other);
        return "updateother.jsp";
    }

    /**
     * 更新其他记录
     * 
     * @param other
     * @return
     */
    @RequestMapping("updateother")
    @ResponseBody
    public String updateOtherRecord(Other other) {
        int n = service.updateOtherRecord(other);
        if (n > 0) {
            return "OK";
        }
        return "FAIL";
    }

    /**
     * 删除其他记录
     * 
     * @param recordID
     * @return
     */
    @RequestMapping("/deleteother")
    @ResponseBody
    public String deleteOtherRecord(int recordID) {
        int n = service.deleteOtherRecord(recordID);
        if (n > 0) {
            return "OK";
        }
        return "FAIL";
    }

}
