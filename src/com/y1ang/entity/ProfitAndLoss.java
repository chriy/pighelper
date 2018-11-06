package com.y1ang.entity;

/**
 * @author y1ang
 * @Data 2018.10.24 21:40
 * @Description 盈亏
 */
public class ProfitAndLoss {

    /**
     * 收入
     */
    private double income;
    /**
     * 支出
     */
    private double expend;
    /**
     * 利润
     */
    private double profit;

    public double getIncome() {
        return income;
    }

    public double getExpend() {
        return expend;
    }

    public double getProfit() {
        return profit;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public void setExpend(double expend) {
        this.expend = expend;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public ProfitAndLoss(double income, double expend, double profit) {
        this.income = income;
        this.expend = expend;
        this.profit = profit;
    }

    public ProfitAndLoss() {
    }
}

