package com.y1ang.entity;

/**
 * 
 * @author y1ang
 * @Data 2018年10月14日-下午2:30:30
 * @Description 销售生猪实体类
 */
public class Sale {
    /**
     * 销售id
     */
    private int saleID;
    /**
     * 销售日期
     */
    private String saleDate;
    /**
     * 销售价格
     */
    private double salePrice;
    /**
     * 销售数量
     */
    private int saleQuantity;
    /**
     * 销售品种
     */
    private String saleVariety;
    /**
     * 销售总重量
     */
    private double totalWeight;
    /**
     * 平均重量
     */
    private double averageWeight;
    /**
     * 销售总金额
     */
    private double saleAmount;
    /**
     * 平均每头金额
     */
    private double averageMoney;
    /**
     * 批次号
     */
    private int batchNumber;

    public int getSaleID() {
        return saleID;
    }

    public void setSaleID(int saleID) {
        this.saleID = saleID;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public int getSaleQuantity() {
        return saleQuantity;
    }

    public void setSaleQuantity(int saleQuantity) {
        this.saleQuantity = saleQuantity;
    }

    public String getSaleVariety() {
        return saleVariety;
    }

    public void setSaleVariety(String saleVariety) {
        this.saleVariety = saleVariety;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public double getAverageWeight() {
        return averageWeight;
    }

    public void setAverageWeight(double averageWeight) {
        this.averageWeight = averageWeight;
    }

    public double getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(double saleAmount) {
        this.saleAmount = saleAmount;
    }

    public double getAverageMoney() {
        return averageMoney;
    }

    public void setAverageMoney(double averageMoney) {
        this.averageMoney = averageMoney;
    }

    public int getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Sale(int saleID, String saleDate, double salePrice, int saleQuantity, String saleVariety, double totalWeight,
            double averageWeight, double saleAmount, double averageMoney, int batchNumber) {
        super();
        this.saleID = saleID;
        this.saleDate = saleDate;
        this.salePrice = salePrice;
        this.saleQuantity = saleQuantity;
        this.saleVariety = saleVariety;
        this.totalWeight = totalWeight;
        this.averageWeight = averageWeight;
        this.saleAmount = saleAmount;
        this.averageMoney = averageMoney;
        this.batchNumber = batchNumber;
    }

    public Sale(String saleDate, double salePrice, int saleQuantity, String saleVariety, double totalWeight,
            double averageWeight, double saleAmount, double averageMoney, int batchNumber) {
        super();
        this.saleDate = saleDate;
        this.salePrice = salePrice;
        this.saleQuantity = saleQuantity;
        this.saleVariety = saleVariety;
        this.totalWeight = totalWeight;
        this.averageWeight = averageWeight;
        this.saleAmount = saleAmount;
        this.averageMoney = averageMoney;
        this.batchNumber = batchNumber;
    }

    public Sale() {
        super();
    }

}
