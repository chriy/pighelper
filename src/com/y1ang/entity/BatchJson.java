package com.y1ang.entity;

import java.util.List;
/**
 * 
 * @author y1ang
 * @Data 2018年10月13日-上午10:31:46
 * @Description 批次返回JSON数据POJO类
 */
public class BatchJson {
	private int code;

	private String msg;

	private int count;

	private List<Batch> data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Batch> getData() {
		return data;
	}

	public void setData(List<Batch> data) {
		this.data = data;
	}

	public BatchJson(int code, String msg, int count, List<Batch> data) {
		super();
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}

	public BatchJson() {
		super();
	}

}
