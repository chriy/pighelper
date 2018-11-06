package com.y1ang.service.impl;

import com.y1ang.dao.BuyMapper;
import com.y1ang.entity.Buy;
import com.y1ang.entity.Page;
import com.y1ang.service.IBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author y1ang
 * @Date 2018.10.18 18:10
 * @Description 购买账单服务层实现类
 */
@Service
public class IBuyServiceImpl implements IBuyService {

    @Autowired
    private BuyMapper dao;

    /**
     * 查询所有购买账单
     *
     * @param page
     * @return
     */
    @Override
    public List<Buy> findAllBuyRecord(Page page) {
        return dao.findAllBuyRecord(page);
    }

    /**
     * 通过id查询购买账单信息
     *
     * @param buyID
     * @return
     */
    @Override
    public Buy findBuyRecordByID(int buyID) {
        return dao.findBuyRecordByID(buyID);
    }

    /**
     * 添加购买幼猪账单信息
     *
     * @param buy
     * @return
     */
    @Override
    public int addBuyRecord(Buy buy) {
        return dao.addBuyRecord(buy);
    }

    /**
     * 更新购买幼猪账单信息
     *
     * @param buy
     * @return
     */
    @Override
    public int updateBuyRecord(Buy buy) {
        return dao.updateBuyRecord(buy);
    }

    /**
     * 删除购买幼猪账单信息
     *
     * @param buyID
     * @return
     */
    @Override
    public int deleteBuyRecord(int buyID) {
        return dao.deleteBuyRecord(buyID);
    }

    /**
     * 获取当前批次账单总数
     *
     * @return
     */
    @Override
    public int getBuyCount() {
        return dao.getBuyCount();
    }
}
