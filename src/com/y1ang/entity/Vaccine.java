package com.y1ang.entity;

/**
 * 
 * @author y1ang
 * @Data 2018年10月13日-上午10:39:05
 * @Description 疫苗记录POJO类
 */
public class Vaccine {
    /**
     * 记录ID
     */
    private int vaccineID;
    /**
     * 疫苗种类名字
     */
    private String vaccineName;
    /**
     * 疫苗接种日期
     */
    private String vaccineDate;
    /**
     * 疫苗接种数量
     */
    private String vaccineQuantity;
    /**
     * 疫苗开销花费数量
     */
    private double vaccineMoney;
    /**
     * 批次号
     */
    private int batchNumber;

    public int getVaccineID() {
        return vaccineID;
    }

    public void setVaccineID(int vaccineID) {
        this.vaccineID = vaccineID;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getVaccineDate() {
        return vaccineDate;
    }

    public void setVaccineDate(String vaccineDate) {
        this.vaccineDate = vaccineDate;
    }

    public String getVaccineQuantity() {
        return vaccineQuantity;
    }

    public void setVaccineQuantity(String vaccineQuantity) {
        this.vaccineQuantity = vaccineQuantity;
    }

    public double getVaccineMoney() {
        return vaccineMoney;
    }

    public void setVaccineMoney(double vaccineMoney) {
        this.vaccineMoney = vaccineMoney;
    }

    public int getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
    }

}
