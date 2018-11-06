package com.y1ang.entity;
/**
 * 
 * @author y1ang
 * @Data 2018年10月13日-上午10:31:26
 * @Description 批次POJO类
 */
public class Batch {
	private int batchId;
	private int batchNumber;
	private int batchStatus;

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public int getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(int batchNumber) {
		this.batchNumber = batchNumber;
	}

	public int getBatchStatus() {
		return batchStatus;
	}

	public void setBatchStatus(int batchStatus) {
		this.batchStatus = batchStatus;
	}

	public Batch(int batchNumber, int batchStatus) {
		super();
		this.batchNumber = batchNumber;
		this.batchStatus = batchStatus;
	}

	public Batch(int batchId, int batchNumber, int batchStatus) {
		super();
		this.batchId = batchId;
		this.batchNumber = batchNumber;
		this.batchStatus = batchStatus;
	}

	public Batch() {
		super();
	}

}
