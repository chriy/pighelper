package com.y1ang.controller;

import com.y1ang.entity.Page;
import com.y1ang.entity.Vaccine;
import com.y1ang.entity.VaccineJson;
import com.y1ang.service.IBatchService;
import com.y1ang.service.IVaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author y1ang
 * @Data 2018年10月13日-下午5:44:24
 * @Description 疫苗账单控制类
 */

@Controller
public class VaccineController {

    @Autowired
    private IVaccineService service;
    @Autowired
    private IBatchService batch;

    /**
     * 跳转到疫苗账单界面
     * 
     * @return
     */
    @RequestMapping("/vaccine.html")
    public String toVaccinePage() {
        return "vaccine.jsp";
    }

    /**
     * 查询所有疫苗账单
     * 
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/vaccinerecord")
    @ResponseBody
    public VaccineJson getAllVaccineRecord(int page, int limit) {
        Page p = new Page((page - 1) * limit, limit);
        List<Vaccine> list = service.findAllVaccine(p);
        int activeBatch = batch.getStatusActiveBatchNumber();
        VaccineJson vj = new VaccineJson(0, "200", service.getVaccineCount(activeBatch), list);
        return vj;
    }

    /**
     * 跳转到添加疫苗界面
     * 
     * @return
     */
    @RequestMapping("/addvaccine.html")
    public String toAddVaccinePage() {
        return "addvaccine.jsp";
    }

    /**
     * 添加疫苗记录
     * 
     * @param vaccine
     * @return
     */
    @RequestMapping("/addvaccine")
    @ResponseBody
    public String addVaccine(Vaccine vaccine) {
        vaccine.setBatchNumber(batch.getStatusActiveBatchNumber());
        int n = service.insertVaccineRecord(vaccine);
        if (n > 0) {
            return "OK";
        }
        return "FAIL";
    }

    /**
     * 跳转到修改疫苗记录界面
     * 
     * @param vaccineID
     * @return
     */
    @RequestMapping("/updatevaccine.html")
    public String toUpdateVaccinePage(int vaccineID, Model model) {
        Vaccine vaccine = service.findVaccineByID(vaccineID);
        model.addAttribute("vaccine", vaccine);
        return "updatevaccine.jsp";
    }

    /**
     * 更新疫苗账单数据
     * 
     * @param vaccine
     * @return
     */
    @RequestMapping("/updatevaccine")
    @ResponseBody
    public String updateVaccine(Vaccine vaccine) {
        int n = service.updateVaccineRecord(vaccine);
        if (n > 0) {
            return "OK";
        }
        return "FAIL";
    }

    @RequestMapping("/deletevaccine")
    @ResponseBody
    public String deleteVaccineRecord(int vaccineID) {
        int n = service.deleteVaccineRecord(vaccineID);
        if (n > 0) {
            return "OK";
        }
        return "FAIL";
    }
}
