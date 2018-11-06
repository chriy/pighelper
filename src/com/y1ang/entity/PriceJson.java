package com.y1ang.entity;

import java.util.List;

/**
 * 
 * @author y1ang
 * @Data 2018年10月13日-上午10:36:50
 * @Description 猪价JSON数据POJO类
 */
public class PriceJson {

    private int code;

    private String msg;

    private int count;

    private List<Prices> data;

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

    public List<Prices> getData() {
        return data;
    }

    public void setData(List<Prices> data) {
        this.data = data;
    }

}
