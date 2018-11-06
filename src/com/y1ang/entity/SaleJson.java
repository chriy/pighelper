package com.y1ang.entity;

import java.util.List;

/**
 * 
 * @author y1ang
 * @Data 2018年10月15日-下午3:46:01
 * @Description 卖猪账单JSON数据POJO类
 */
public class SaleJson {

    private int code;

    private String msg;

    private int count;

    private List<Sale> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Sale> getData() {
        return data;
    }

    public void setData(List<Sale> data) {
        this.data = data;
    }

}
