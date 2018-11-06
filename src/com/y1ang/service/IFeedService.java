package com.y1ang.service;

import java.util.List;

import com.y1ang.entity.Feed;
import com.y1ang.entity.Page;

/**
 * 
 * @author y1ang
 * @Data 2018年10月13日-上午10:48:29
 * @Description 饲料账单服务层接口类
 */
public interface IFeedService {

    /**
     * 查询当前批次下所有饲料记录
     * 
     * @param page
     * @return
     */
    public List<Feed> findFeedRecord(Page page);

    /**
     * 通过id查询饲料账单
     * 
     * @param feedID
     * @return
     */
    public Feed findFeedRecordByID(int feedID);

    /**
     * 添加饲料账单记录
     * 
     * @param feed
     * @return
     */
    public int addFeedRecord(Feed feed);

    /**
     * 更新饲料账单
     * 
     * @param feedID
     * @return
     */
    public int updateFeedRecord(Feed feed);

    /**
     * 删除饲料账单
     * 
     * @param feedID
     * @return
     */
    public int deleteFeedRecord(int feedID);
    /**
     * 查询饲料账单的记录总数
     * @param batchNumber
     * @return
     */
    public int getFeedCount(int batchNumber);
}
