package com.y1ang.entity;

/**
 * 
 * @author y1ang
 * @Data 2018年10月13日-上午10:37:20
 * @Description 猪价POJO类
 */
public class Prices {
    /**
     * 猪价城市
     */
    private String city;
    /**
     * 猪价
     */
    private String price;
    /**
     * 猪价趋势(上涨、下跌、平)
     */
    private String range;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public Prices(String city, String price, String range) {
        super();
        this.city = city;
        this.price = price;
        this.range = range;
    }

    public Prices() {
        super();
    }
}
