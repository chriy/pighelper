package com.y1ang.service;

import java.util.List;

import com.y1ang.entity.Page;
import com.y1ang.entity.Sale;

/**
 * 
 * @author y1ang
 * @Data 2018年10月15日-下午2:45:44
 * @Description 卖猪账单服务接口类
 */
public interface ISaleService {
    /**
     * 查询所有卖猪账单
     * 
     * @param page
     * @return
     */
    public List<Sale> findSaleRecord(Page page);

    /**
     * 查询改批次下卖猪账单的总记录数
     * 
     * @param batchNumber
     * @return
     */
    public int getSaleCount(int batchNumber);

    /**
     * 通过ID查询卖猪账单信息
     * 
     * @param saleID
     * @return
     */
    public Sale finSaleRecordByID(int saleID);

    /**
     * 插入卖猪账单
     * 
     * @param sale
     * @return
     */
    public int insertSaleRecord(Sale sale);

    /**
     * 更新卖猪账单
     * 
     * @param sale
     * @return
     */
    public int updateSaleRecord(Sale sale);

    /**
     * 删除饲料账单
     * 
     * @param saleID
     * @return
     */
    public int deleteSaleRecord(int saleID);
}
