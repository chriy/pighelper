package com.y1ang.service;

import java.util.List;

import com.y1ang.entity.Other;
import com.y1ang.entity.Page;

/**
 * 
 * @author y1ang
 * @Data 2018年10月13日-上午10:49:05
 * @Description 其他账单服务层接口类
 */
public interface IOtherService {

	/**
	 * 查询所有其他记录信息
	 * @param page
	 * @return
	 */
	public List<Other> findAllOtherRecord(Page page);
	/**
	 * 添加其他记录
	 * @param other
	 * @return
	 */
	public int addOtherRecord(Other other);
	
	/**
	 * 更新其他记录
	 * @param other
	 * @return
	 */
	public int updateOtherRecord(Other other);
	
	/**
	 * 删除其他记录
	 * @param recordID
	 * @return
	 */
	public int deleteOtherRecord(int recordID);
	/**
	 * 通过ID查询其他记录
	 * @param recordID
	 * @return
	 */
	public Other findOtherRecordByID(int recordID);
	   
    /**
     * 查询其他记录总数
    * @param batchNumber
     * @return
     */
    public int getOtherCount(int batchNumber);
}
