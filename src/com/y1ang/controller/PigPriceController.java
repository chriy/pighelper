package com.y1ang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.y1ang.entity.PriceJson;
import com.y1ang.util.GetPricesUtil;

/**
 * 
 * @author y1ang
 * @Data 2018年9月25日-下午11:49:26
 * @Description 获取猪价信息控制类
 */
@Controller
public class PigPriceController {

    @RequestMapping("/prices.html")
    public String toPricePage() {
        return "prices.jsp";
    }

    /**
     * 获取全国猪价
     * 
     * @return
     */
    @RequestMapping("/getQGPrice")
    @ResponseBody
    public PriceJson getQGPrice() {
        PriceJson price = GetPricesUtil.getPrices("https://zhujia.zhuwang.cc/");
        return price;
    }

    /**
     * 获取省内猪价
     * 
     * @return
     */
    @RequestMapping("/getSNPrice")
    @ResponseBody
    public PriceJson getSNPrice() {
        PriceJson price = GetPricesUtil.getPrices("https://zhujia.zhuwang.cc/areapriceinfo-430000.shtml");
        return price;
    }
}
