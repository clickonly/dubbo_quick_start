package org.dubbo.api.service;

import org.dubbo.pojo.bean.activity.ActivityMain;
import org.dubbo.pojo.bean.activity.ActivityWinResult;
import org.dubbo.pojo.dto.activity.ActivityDto;
import org.dubbo.pojo.dto.activity.PrizeRecordDto;

import java.util.List;

/**
 * Created by fanglei on 2018/5/23.
 */
public interface SendActivityResultService {

    /**
     * 插入抽奖结果
     * @param activityWinResult
     * @return
     */
    boolean insertActivityWinResult(ActivityWinResult activityWinResult);


    /**
     * 发送奖品
     * @param activityWinResult
     * @return
     */
    boolean sendRedisActivityWinResult(ActivityWinResult activityWinResult);


    /**
     * 保存中奖结果
     *
     */
    boolean sendWinResultToRedis(ActivityWinResult activityWinResult);


    List<ActivityWinResult> getActivityWinResultList(ActivityDto activityDto);

    List<ActivityWinResult> getPrizeRecordByActivityType(ActivityDto activityDto);


    List<ActivityWinResult> getActivityWinResultListByActivityIdList(PrizeRecordDto prizeRecordDto);


    /**
     * 处理竞价中奖结果
     * @param activityMain
     */
    void handAuctionResult(ActivityMain activityMain);

    void handAuctionResultByAction(ActivityDto activityDto);


    boolean updateSize(ActivityWinResult activityWinResult);

    /**
     * 发送没有填写地址人的消息
     */
    void sendAddressIsNullMessage();

}
