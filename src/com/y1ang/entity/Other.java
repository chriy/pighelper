package com.y1ang.entity;

/**
 * 
 * @author y1ang
 * @Data 2018年10月13日-上午10:34:49
 * @Description 其他账单POJO类
 */
public class Other {
    /**
     * 记录ID
     */
    private int recordID;
    /**
     * 记录日期
     */
    private String recordDate;
    /**
     * 记录详情
     */
    private String recordDetails;
    /**
     * 其他支出总额
     */
    private double recordMoney;
    /**
     * 批次号
     */
    private int batchNumber;

    public int getRecordID() {
        return recordID;
    }

    public void setRecordID(int recordID) {
        this.recordID = recordID;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public String getRecordDetails() {
        return recordDetails;
    }

    public void setRecordDetails(String recordDetails) {
        this.recordDetails = recordDetails;
    }

    public double getRecordMoney() {
        return recordMoney;
    }

    public void setRecordMoney(double recordMoney) {
        this.recordMoney = recordMoney;
    }

    public int getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Other(int recordID, String recordDate, String recordDetails, double recordMoney, int batchNumber) {
        super();
        this.recordID = recordID;
        this.recordDate = recordDate;
        this.recordDetails = recordDetails;
        this.recordMoney = recordMoney;
        this.batchNumber = batchNumber;
    }

    public Other(String recordDate, String recordDetails, double recordMoney, int batchNumber) {
        super();
        this.recordDate = recordDate;
        this.recordDetails = recordDetails;
        this.recordMoney = recordMoney;
        this.batchNumber = batchNumber;
    }

    public Other() {
        super();
    }

}
