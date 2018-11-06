package com.y1ang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.y1ang.dao.OtherMapper;
import com.y1ang.entity.Other;
import com.y1ang.entity.Page;
import com.y1ang.service.IOtherService;

@Service
public class IOtherServiceImpl implements IOtherService {

	@Autowired
	private OtherMapper dao;

	/**
	 * 查询所有其他记录信息
	 */
	@Override
	public List<Other> findAllOtherRecord(Page page) {
		return dao.findAllOtherRecord(page);
	}

	@Override
	public int addOtherRecord(Other other) {
		return dao.addOtherRecord(other);
	}

	@Override
	public int updateOtherRecord(Other other) {
		return dao.updateOtherRecord(other);
	}

	@Override
	public int deleteOtherRecord(int recordID) {
		return dao.deleteOtherRecord(recordID);
	}
	
	@Override
	public Other findOtherRecordByID(int recordID) {
		return dao.findOtherRecordByID(recordID);
	}

    @Override
    public int getOtherCount(int batchNumber) {
        return dao.getOtherCount(batchNumber);
    }

}
