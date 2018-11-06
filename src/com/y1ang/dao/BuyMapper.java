package com.y1ang.dao;

import java.util.List;

import com.y1ang.entity.Buy;
import com.y1ang.entity.Page;

/**
 * @Author y1ang
 * @Data 2018年10月17日-下午4:47:05
 * @Description 购买账单接口类
 */
public interface BuyMapper {

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
