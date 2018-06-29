package org.dubbo.api.dao;

import org.dubbo.pojo.bean.user.WxFans;
import org.dubbo.pojo.dto.activity.ActivityDto;

public interface CheckActivityRuleDao {

    public Integer getWxFansResult(ActivityDto activityDto);

    public Integer getWxIntegral(ActivityDto activityDto);

    public WxFans getWxFan(ActivityDto activityDto);

//    public Integer getUserLotteryTimes(ActivityDto activityDto);

}
