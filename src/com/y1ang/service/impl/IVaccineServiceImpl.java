package com.y1ang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.y1ang.dao.VaccineMapper;
import com.y1ang.entity.Page;
import com.y1ang.entity.Vaccine;
import com.y1ang.service.IVaccineService;

/**
 * 
 * @author y1ang
 * @Data 2018年10月13日-下午5:42:20
 * @Description 疫苗账单服务层实现类
 */
@Service
public class IVaccineServiceImpl implements IVaccineService {

    @Autowired
    private VaccineMapper dao;

    @Override
    public List<Vaccine> findAllVaccine(Page page) {
        return dao.findAllVaccine(page);
    }

    @Override
    public int insertVaccineRecord(Vaccine vaccine) {
        return dao.insertVaccineRecord(vaccine);
    }

    @Override
    public int updateVaccineRecord(Vaccine vaccine) {
        return dao.updateVaccineRecord(vaccine);
    }

    @Override
    public int deleteVaccineRecord(int vaccineID) {
        return dao.deleteVaccineRecord(vaccineID);
    }

    @Override
    public Vaccine findVaccineByID(int vaccineID) {
        return dao.findVaccineByID(vaccineID);
    }

    @Override
    public int getVaccineCount(int batchNumber) {
        return dao.getVaccineCount(batchNumber);
    }

}
