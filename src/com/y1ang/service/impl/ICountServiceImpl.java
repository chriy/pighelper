package com.y1ang.service.impl;

import com.y1ang.dao.CountMapper;
import com.y1ang.entity.ProfitAndLoss;
import com.y1ang.service.ICountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author y1ang
 * @Data 2018.10.24 19:19
 * @Description
 */

@Service
public class ICountServiceImpl implements ICountService {

    @Autowired
    private CountMapper mapper;

    /**
     * 获取盈亏账单
     *
     * @param batchNumber
     * @return
     */
    @Override
    public ProfitAndLoss getProfitAndLoss(int batchNumber) {
        return mapper.getProfitAndLoss(batchNumber);
    }

    /**
     * 获取已支付的饲料包数
     *
     * @param batchNumber
     * @return
     */
    @Override
    public int getPaidFeedAmount(int batchNumber) {
        return mapper.getPaidFeedAmount(batchNumber);
    }

    /**
     * 获取未支付的饲料包数
     *
     * @param batchNumber
     * @return
     */
    @Override
    public int getUnPaidFeedAmount(int batchNumber) {
        return mapper.getUnPaidFeedAmount(batchNumber);
    }

    /**
     * 获取合计饲料数目
     *
     * @param batchNumber
     * @return
     */
    @Override
    public int getAllFeedAmount(int batchNumber) {
        return mapper.getAllFeedAmount(batchNumber);
    }

    /**
     * 获取已支付饲料金额
     *
     * @param batchNumber
     * @return
     */
    @Override
    public double getPaidMoney(int batchNumber) {
        return mapper.getPaidMoney(batchNumber);
    }

    /**
     * 获取未支付饲料金额
     *
     * @param batchNumber
     * @return
     */
    @Override
    public double getUnPaidMoney(int batchNumber) {
        return mapper.getUnPaidMoney(batchNumber);
    }

    /**
     * 查询饲料总开支
     *
     * @param batchNumber
     * @return
     */
    @Override
    public double getFeedMoney(int batchNumber) {
        return mapper.getFeedMoney(batchNumber);
    }

    /**
     * 查询购买小猪账单
     *
     * @param batchNumber
     * @return
     */
    @Override
    public double getPigletMoney(int batchNumber) {
        return mapper.getPigletMoney(batchNumber);
    }

    /**
     * 查询卖猪账单统计
     *
     * @param batchNumber
     * @return
     */
    @Override
    public double getSaleMoney(int batchNumber) {
        return mapper.getSaleMoney(batchNumber);
    }

    /**
     * 查询疫苗统计账单合计
     *
     * @param batchNumber
     * @return
     */
    @Override
    public double getVaccineMoney(int batchNumber) {
        return mapper.getVaccineMoney(batchNumber);
    }

    /**
     * 查询其他账单合计
     *
     * @param batchNumber
     * @return
     */
    @Override
    public double getOtherMoney(int batchNumber) {
        return mapper.getOtherMoney(batchNumber);
    }
}
