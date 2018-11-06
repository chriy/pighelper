package com.y1ang.service;

import java.util.List;

import com.y1ang.entity.Page;
import com.y1ang.entity.Vaccine;
/**
 * 
 * @author y1ang
 * @Data 2018年10月13日-下午5:41:39
 * @Description 疫苗账单服务接口类
 */
public interface IVaccineService {
    /**
     * 查询所有疫苗账单数据
     * @param page
     * @return
     */
    public List<Vaccine> findAllVaccine(Page page);
    
    /**
     * 添加疫苗账单记录
     * @param vaccine
     * @return
     */
    public int insertVaccineRecord(Vaccine vaccine);
    /**
     * 更新疫苗账单记录
     * @param vaccine
     * @return
     */
    public int updateVaccineRecord(Vaccine vaccine);
    
    /**
     * 删除疫苗账单数据
     * @param vaccineID
     * @return
     */
    public int deleteVaccineRecord(int vaccineID);
    /**
     * 通过ID查询疫苗记录
     * @param vaccineID
     * @return
     */
    public Vaccine findVaccineByID(int vaccineID);
    /**
     * 查询疫苗账单记录总数
     * @param batchNumber
     * @return
     */
    public int getVaccineCount(int batchNumber);
}
