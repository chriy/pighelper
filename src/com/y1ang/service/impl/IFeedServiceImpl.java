package com.y1ang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.y1ang.dao.FeedMapper;
import com.y1ang.entity.Feed;
import com.y1ang.entity.Page;
import com.y1ang.service.IFeedService;

@Service
public class IFeedServiceImpl implements IFeedService {

	@Autowired
	private FeedMapper dao;

	@Override
	public List<Feed> findFeedRecord(Page page) {
		return dao.findFeedRecord(page);
	}

	@Override
	public Feed findFeedRecordByID(int feedID) {
		return dao.findFeedRecordByID(feedID);
	}

	@Override
	public int updateFeedRecord(Feed feed) {
		return dao.updateFeedRecord(feed);
	}

	@Override
	public int deleteFeedRecord(int feedID) {
		return dao.deleteFeedRecord(feedID);
	}

	@Override
	public int addFeedRecord(Feed feed) {
		return dao.addFeedRecord(feed);
	}

    @Override
    public int getFeedCount(int batchNumber) {
        return dao.getFeedCount(batchNumber);
    }

}
