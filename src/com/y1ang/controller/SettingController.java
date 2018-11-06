package com.y1ang.controller;

import com.y1ang.entity.Batch;
import com.y1ang.entity.BatchJson;
import com.y1ang.entity.Page;
import com.y1ang.entity.User;
import com.y1ang.service.IBatchService;
import com.y1ang.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author y1ang
 * @Data 2018年10月13日-上午10:27:39
 * @Description 设置界面控制类
 */
@Controller
public class SettingController {

    @Autowired
    private IBatchService service;
    @Autowired
    private IUserService uService;

    /**
     * 跳转至设置页面
     *
     * @return
     */
    @RequestMapping("/setting.html")
    public String toSetPage(HttpServletRequest request, Model model) {
        List<Batch> batch = service.findAllBatch();
        int activeBatch;
        try {
            activeBatch = service.getStatusActiveBatchNumber();
            if (activeBatch != 0) {
                request.getSession().setAttribute("activeBatch", activeBatch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("batch", batch);
        return "setting.jsp";
    }

    /**
     * 添加批次
     *
     * @return
     */
    @RequestMapping("/addbatch")
    @ResponseBody
    public String addBatch() {
        int batchCount = service.getBatchCount();
        // 所有批次状态设为休眠
        int updateAll = service.updateAll();
        Batch batch = new Batch(batchCount + 1, 1);
        int addBatch = service.addBatch(batch);
        if (addBatch > 0) {
            return "OK";
        }
        return "FAIL";
    }

    /**
     * 切换批次
     *
     * @param batchNumber
     * @return
     */
    @RequestMapping("/switchBatch")
    @ResponseBody
    public String switchBatch(int batchNumber) {
        int updateAll = service.updateAll();
        try {
            int updateStatus = service.updateStatus(batchNumber);
            if (updateAll > 0 && updateStatus > 0) {
                return "OK";
            }
        } catch (Exception e) {
        }
        return "FAIL";
    }

    /**
     * 跳转到管理批次界面
     *
     * @return
     */
    @RequestMapping("/batchmanager")
    public String toBatchManager() {
        return "batchmanager.jsp";
    }

    /**
     * 获取批次json数据
     *
     * @return
     */
    @RequestMapping("/getbatch")
    @ResponseBody
    public BatchJson findBatchToManager(int page, int limit) {
        Page p = new Page((page - 1) * limit, limit);
        List<Batch> list = service.findAllBatchByPage(p);
        int batchCount = service.getBatchCount();
        BatchJson bt = new BatchJson(0, "200", batchCount, list);
        return bt;
    }

    /**
     * 删除批次
     *
     * @param batchId 批次Id
     * @return
     */
    @RequestMapping("/deletebatch")
    @ResponseBody
    public String deleteBatch(int batchId) {
        int deleteBatch = 0;
        try {
            deleteBatch = service.deleteBatch(batchId);
            service.updateAll();
            service.updateLastStatus();
        } catch (Exception e) {
            return "FAIL";
        }
        if (deleteBatch > 0) {
            return "OK";
        }
        return "FAIL";
    }

    @RequestMapping("/updatepassword.html")
    public String updatePasswordPage(){
        return "updatepassword.jsp";
    }

    @RequestMapping("/updatepassword")
    @ResponseBody
    public String updatePassword(int userId,String oldPwd,String newPwd,String confirmPwd) {
        User check = new User();
        check.setUserId(userId);
        check.setUserPwd(oldPwd);
        User user = uService.checkOldPwd(check);
        if(user == null){
            return "ERROR";
        }else{
            User update = new User();
            if(newPwd.equals(confirmPwd)){
                update.setUserId(userId);
                update.setUserPwd(newPwd);
                int i = uService.updatePwd(update);
                if (i>0){
                    return "OK";
                }
            }else{
                return "CHECK";
            }
        }
        return "FAIL";
    }

    @RequestMapping("/about.html")
    public String about(){
        return "about.jsp";
    }

    /**
     * 退出登录
     *
     * @param request
     * @return
     */
    @RequestMapping("/signout")
    public String signOut(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        Cookie cookie = new Cookie("user", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "login.jsp";
    }


}
