package com.y1ang.entity;

import java.util.List;

/**
 * 
 * @author y1ang
 * @Data 2018年10月17日-下午4:29:33
 * @Description 购买幼猪JSON数据POJO类
 */
public class BuyJson {
    private int code;

    private String msg;

    private int count;

    private List<Buy> data;

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

    public List<Buy> getData() {
        return data;
    }

    public void setData(List<Buy> data) {
        this.data = data;
    }

    public BuyJson(int code, String msg, int count, List<Buy> data) {
        super();
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public BuyJson() {
        super();
    }

}
