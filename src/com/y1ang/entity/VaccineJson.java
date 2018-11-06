package com.y1ang.entity;

import java.util.List;
/**
 * 
 * @author y1ang
 * @Data 2018年10月13日-下午5:39:50
 * @Description 疫苗账单记录JSON数据POJO类
 */
public class VaccineJson {

    private int code;

    private String msg;

    private int count;

    private List<Vaccine> data;

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

    public List<Vaccine> getData() {
        return data;
    }

    public void setData(List<Vaccine> data) {
        this.data = data;
    }

    public VaccineJson(int code, String msg, int count, List<Vaccine> data) {
        super();
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public VaccineJson() {
        super();
    }

}
