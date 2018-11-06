package com.y1ang.service;

import com.y1ang.entity.Buy;
import com.y1ang.entity.Page;

import java.util.List;

/**
 * @author y1ang
 * @date 2018年10月18日-下午4:47:05
 * @descr 购买幼猪账单操作服务类
 */
public interface IBuyService {

    /**
     * 查询所有购买账单
     *
     * @param page
     * @return
     */
    public List<Buy> findAllBuyRecord(Page page);

    /**
     * 通过id查询购买账单信息
     *
     * @param buyID
     * @return
     */
    public Buy findBuyRecordByID(int buyID);

    /**
     * 添加购买幼猪账单信息
     *
     * @param buy
     * @return
     */
    public int addBuyRecord(Buy buy);

    /**
     * 更新购买幼猪账单信息
     * @param buy
     * @return
     */
    public int updateBuyRecord(Buy buy);

    /**
     * 删除购买幼猪账单信息
     * @param buyID
     * @return
     */
    public int deleteBuyRecord(int buyID);

    /**
     * 获取当前批次账单总数
     * @return
     */
    public int getBuyCount();
}
