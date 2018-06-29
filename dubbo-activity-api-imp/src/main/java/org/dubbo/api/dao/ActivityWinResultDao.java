package org.dubbo.api.dao;

import org.dubbo.pojo.bean.activity.ActivityWinResult;
import org.dubbo.pojo.dto.activity.ActivityCashPrizeDto;
import org.dubbo.pojo.dto.activity.ActivityDto;
import org.dubbo.pojo.dto.activity.PrizeRecordDto;

import java.util.List;
import java.util.Map;

public interface ActivityWinResultDao {

    int insert(ActivityWinResult record);

    /**
     * 更改发送记录结果
     * @param activityWinResult
     */
    void updateActivityWinResultStatus(ActivityWinResult activityWinResult);

    Long getSeqId();

    List<Map<String,String>> getUserPrizeList(ActivityDto activityDto);

    List<Map<String,String>> getLotteryRecord(ActivityDto activityDto);


    List<ActivityWinResult> getErrorActivityWinResultList();

    /**
     * 通过参数查询获奖列表
     * @param
     * @return
     */
    List<ActivityWinResult> getActivityWinResultListByActivityId(ActivityDto activityDto);


    Map<String,String> getOnetLotteryRecord(ActivityDto activityDto);



    /**
     * 更改发奖的兑换码
     * @param activityWinResult
     */
    void updateActivationCode(ActivityWinResult activityWinResult);

    ActivityWinResult getActivityWinResultById(Long id);

    List<ActivityWinResult> getPrizeRecordByActivityType(ActivityDto activityDto);

    List<ActivityWinResult> getActivityWinResultListByActivityIdList(PrizeRecordDto prizeRecordDto);


    void updateSize(ActivityWinResult activityWinResult);

    List<ActivityWinResult> sendAddressIsNullActivityWinResult();

}