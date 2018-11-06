package com.y1ang.controller;

import com.y1ang.entity.Feed;
import com.y1ang.entity.FeedJson;
import com.y1ang.entity.Page;
import com.y1ang.service.IBatchService;
import com.y1ang.service.IFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 饲料账单控制类
 *
 * @author y1ang
 * @Data 2018年8月27日-上午1:04:21
 * @Description 饲料账单控制类
 */
@Controller
public class FeedController {

    @Autowired
    private IFeedService service;

    @Autowired
    private IBatchService ibs;

    /**
     * 跳转到饲料账单界面
     * 
     * @return
     */
    @RequestMapping("/feed.html")
    public String toFeedPage() {
        return "feed.jsp";
    }

    /**
     * 显示饲料账单数据
     * 
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/feedrecord")
    @ResponseBody
    public FeedJson getFeedRecord(int page, int limit) {
        FeedJson fj = new FeedJson();
        Page p = new Page((page - 1) * limit, limit);
        List<Feed> feedRecord = service.findFeedRecord(p);
        int activeBatch = ibs.getStatusActiveBatchNumber();
        fj.setCode(0);
        fj.setCount(service.getFeedCount(activeBatch));
        fj.setMsg("200");
        fj.setData(feedRecord);
        return fj;
    }
    /**
     * 跳转到添加饲料账单界面
     *
     * @return
     */
    @RequestMapping("/addfeed.html")
    public String toAddPage() {
        return "addfeed.jsp";
    }

    /**
     * 添加饲料账单记录
     *
     * @param feed
     * @return
     */
    @RequestMapping("/addfeed")
    @ResponseBody
    public String addFeedRecord(Feed feed) {
        try {
            int batchNumber = ibs.getStatusActiveBatchNumber();
            feed.setBatchNumber(batchNumber);
            feed.setFeedTotal(feed.getFeedQuantity() * feed.getFeedPrice());
            int n = service.addFeedRecord(feed);
            if (n > 0) {
                return "OK";
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return "FAIl";
    }

    /**
     * 删除饲料账单记录
     * 
     * @param feedID
     * @return
     */
    @RequestMapping("/deletefeed")
    @ResponseBody
    public String deleteFeedRecord(int feedID) {
        int n = service.deleteFeedRecord(feedID);
        if (n > 0) {
            return "OK";
        }
        return "FAIL";
    }

    /**
     * 跳转到饲料账单修改界面
     * 
     * @param feedID
     * @param model
     * @return
     */
    @RequestMapping("/updatefeed.html")
    public String toUpdatePage(int feedID, Model model) {
        Feed feed = service.findFeedRecordByID(feedID);
        model.addAttribute("feed", feed);
        return "updatefeed.jsp";
    }

    /**
     * 更新饲料账单
     * 
     * @param feed
     * @return
     */
    @RequestMapping("/updatefeed")
    @ResponseBody
    public String updateFeed(Feed feed) {
        feed.setFeedTotal(feed.getFeedQuantity() * feed.getFeedPrice());
        int n = service.updateFeedRecord(feed);
        if (n > 0) {
            return "OK";
        }
        return "FAIL";
    }
}
