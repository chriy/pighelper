package com.y1ang.service.impl;

import com.y1ang.dao.BatchMapper;
import com.y1ang.entity.Batch;
import com.y1ang.entity.Page;
import com.y1ang.service.IBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @Author y1ang
 * @Date 2018.10.14 18:10
 * @Description 设置界面服务层实现类
 */
@Service
public class IBatchServiceImpl implements IBatchService {

	@Autowired
	private BatchMapper dao;

	/**
	 * 把所有批次状态变为休眠状态
	 *
	 * @return
	 */
	@Override
	public int updateAll() {
		return dao.updateAll();
	}

	/**
	 * 更新最后一条批次的状态，变为激活状态
	 *
	 * @return
	 */
	@Override
	public int updateLastStatus() {
		return dao.updateLastStatus();
	}

	/**
	 * 切换批次 将所有批次状态设为休眠状态，再将传入的批次设为激活状态
	 *
	 * @param batchNumber 批次号
	 * @return
	 */
	@Override
	public int updateStatus(int batchNumber) {
		return dao.updateStatus(batchNumber);
	}

	/**
	 * 获取批次的数量，添加批次时加1
	 *
	 * @return
	 */
	@Override
	public int getBatchCount() {
		return dao.getBatchCount();
	}

	/**
	 * 添加批次
	 *
	 * @param batch
	 * @return
	 */
	@Override
	public int addBatch(Batch batch) {
		return dao.addBatch(batch);
	}

	/**
	 * 查询所有批次
	 *
	 * @return
	 */
	@Override
	public List<Batch> findAllBatch() {
		return dao.findAllBatch();
	}

	/**
	 * 查询那个批次是激活状态
	 *
	 * @return
	 */
	@Override
	public int getStatusActiveBatchNumber() {
		return dao.findStatusActiveBatchNumber();
	}

	/**
	 * 分页查询所有批次
	 *
	 * @param page
	 * @return
	 */
	@Override
	public List<Batch> findAllBatchByPage(Page page) {
		return dao.findAllBatchByPage(page);
	}

	/**
	 * 删除批次
	 *
	 * @param batchId
	 * @return
	 */
	@Override
	public int deleteBatch(int batchId) {
		return dao.deleteBatch(batchId);
	}
}
