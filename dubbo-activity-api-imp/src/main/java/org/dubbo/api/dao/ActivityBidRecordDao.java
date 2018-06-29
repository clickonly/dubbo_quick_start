package org.dubbo.api.dao;

import org.dubbo.pojo.bean.activity.ActivityBidRecord;
import org.dubbo.pojo.dto.activity.ActivityAuctionDto;
import org.dubbo.pojo.dto.activity.ActivityDto;

import java.util.List;

/**
 * Created by fanglei on 2018/5/29.
 */
public interface ActivityBidRecordDao {

    void  insert(ActivityAuctionDto activityAuctionDto);

    List<ActivityAuctionDto> getActivityBidRecordList(ActivityAuctionDto activityAuctionDto);

    Integer getActivityBidRecordCount(ActivityAuctionDto activityAuctionDto);

    Long getSeq();
}
