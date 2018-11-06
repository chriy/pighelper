package com.y1ang.service;

import com.y1ang.entity.Batch;
import com.y1ang.entity.Page;

import java.util.List;
/**
 * 
 * @author y1ang
 * @Data 2018年10月13日-上午10:47:36
 * @Description 批次服务层接口类
 */
public interface IBatchService {
    /**
     * 把所有批次状态变为休眠状态
     * 
     * @return
     */
    public int updateAll();

    /**
     * 更新最后一条批次的状态，变为激活状态
     * 
     * @return
     */
    public int updateLastStatus();

    /**
     * 切换批次 将所有批次状态设为休眠状态，再将传入的批次设为激活状态
     * 
     * @param batchNumber 批次号
     * @return
     */
    public int updateStatus(int batchNumber);

    /**
     * 获取批次的数量，添加批次时加1
     * 
     * @return
     */
    public int getBatchCount();

    /**
     * 添加批次
     * 
     * @param batch
     * @return
     */
    public int addBatch(Batch batch);

    /**
     * 查询所有批次
     * 
     * @return
     */
    public List<Batch> findAllBatch();

    /**
     * 查询那个批次是激活状态
     * 
     * @return
     */
    public int getStatusActiveBatchNumber();

    /**
     * 分页查询所有批次
     * 
     * @param page
     * @return
     */
    public List<Batch> findAllBatchByPage(Page page);

    /**
     * 删除批次
     * 
     * @param batchId
     * @return
     */
    public int deleteBatch(int batchId);
}
