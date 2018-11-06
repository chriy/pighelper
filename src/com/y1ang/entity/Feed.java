package com.y1ang.entity;

/**
 * 
 * @author y1ang
 * @Data 2018年10月4日-下午8:47:57
 * @Description 饲料账单POJO类
 */

public class Feed {
    /**
     * 唯一ID
     */
    private int feedID;
    /**
     * 配送日期
     */
    private String sendDate;
    /**
     * 配送数量
     */
    private int feedQuantity;
    /**
     * 单价
     */
    private double feedPrice;
    /**
     * 支付状态
     */
    private String feedPayState;
    /**
     * 价格总数
     */
    private double feedTotal;
    /**
     * 批次号
     */

    public int batchNumber;

    public int getFeedID() {
        return feedID;
    }

    public void setFeedID(int feedID) {
        this.feedID = feedID;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public int getFeedQuantity() {
        return feedQuantity;
    }

    public void setFeedQuantity(int feedQuantity) {
        this.feedQuantity = feedQuantity;
    }

    public double getFeedPrice() {
        return feedPrice;
    }

    public void setFeedPrice(double feedPrice) {
        this.feedPrice = feedPrice;
    }

    public String getFeedPayState() {
        return feedPayState;
    }

    public void setFeedPayState(String feedPayState) {
        this.feedPayState = feedPayState;
    }

    public double getFeedTotal() {
        return feedTotal;
    }

    public void setFeedTotal(double feedTotal) {
        this.feedTotal = feedTotal;
    }

    public int getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
    }

}
