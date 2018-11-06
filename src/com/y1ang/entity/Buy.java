package com.y1ang.entity;

/**
 * @author y1ang
 * @Data 2018年10月17日-下午4:28:42
 * @Description 购买幼猪实体类
 */
public class Buy {
    /**
     * 购买ID
     */
    private int buyID;
    /**
     * 购买日期
     */
    private String buyDate;
    /**
     * 购买数量
     */
    private int buyQuantity;
    /**
     * 购买品种
     */
    private String buyVariety;
    /**
     * 购买价格
     */
    private double buyPrice;
    /**
     * 购买地址
     */
    private String buyAddress;
    /**
     * 平均重量
     */
    private double averageWeight;
    /**
     * 超出标准重量价格
     */
    private double beyondPrice;
    /**
     * 购买总金额
     */
    private double totalMoney;
    /**
     * 批次号
     */
    private int batchNumber;

    public int getBuyID() {
        return buyID;
    }

    public void setBuyID(int buyID) {
        this.buyID = buyID;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public int getBuyQuantity() {
        return buyQuantity;
    }

    public void setBuyQuantity(int buyQuantity) {
        this.buyQuantity = buyQuantity;
    }

    public String getBuyVariety() {
        return buyVariety;
    }

    public void setBuyVariety(String buyVariety) {
        this.buyVariety = buyVariety;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getBuyAddress() {
        return buyAddress;
    }

    public void setBuyAddress(String buyAddress) {
        this.buyAddress = buyAddress;
    }

    public double getAverageWeight() {
        return averageWeight;
    }

    public void setAverageWeight(double averageWeight) {
        this.averageWeight = averageWeight;
    }

    public double getBeyondPrice() {
        return beyondPrice;
    }

    public void setBeyondPrice(double beyondPrice) {
        this.beyondPrice = beyondPrice;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Buy(int buyID, String buyDate, int buyQuantity, String buyVariety, double buyPrice, String buyAddress,
               double averageWeight, double beyondPrice, double totalMoney, int batchNumber) {
        super();
        this.buyID = buyID;
        this.buyDate = buyDate;
        this.buyQuantity = buyQuantity;
        this.buyVariety = buyVariety;
        this.buyPrice = buyPrice;
        this.buyAddress = buyAddress;
        this.averageWeight = averageWeight;
        this.beyondPrice = beyondPrice;
        this.totalMoney = totalMoney;
        this.batchNumber = batchNumber;
    }

    public Buy(String buyDate, int buyQuantity, String buyVariety, double buyPrice, String buyAddress,
               double averageWeight, double beyondPrice, double totalMoney, int batchNumber) {
        super();
        this.buyDate = buyDate;
        this.buyQuantity = buyQuantity;
        this.buyVariety = buyVariety;
        this.buyPrice = buyPrice;
        this.buyAddress = buyAddress;
        this.averageWeight = averageWeight;
        this.beyondPrice = beyondPrice;
        this.totalMoney = totalMoney;
        this.batchNumber = batchNumber;
    }

    public Buy() {
        super();
    }

}
