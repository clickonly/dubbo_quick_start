package org.dubbo.api.service;

import org.dubbo.pojo.base.PageResponse;
import org.dubbo.pojo.bean.activity.ActivityBidRecord;
import org.dubbo.pojo.dto.activity.ActivityAuctionDto;
import org.dubbo.pojo.dto.activity.ActivityDto;

import java.util.List;

/**
 * Created by fanglei on 2018/5/29.
 */
public interface ActivityBidRecordService {

    /**
     * 将出价记录写进redis
     * @param activityBidRecord
     * @return
     */
    boolean sendActivityBidRecordToRedis(ActivityBidRecord activityBidRecord);


    boolean insertActivityBidRecord(ActivityAuctionDto activityAuctionDto);

    /**
     * 获取出价记录
     * @param
     * @return
     */
    PageResponse<List<ActivityAuctionDto>> getActivityBidRecordList(ActivityAuctionDto activityAuctionDto);

}
