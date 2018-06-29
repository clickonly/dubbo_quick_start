package org.dubbo.api.imp;

import org.dubbo.api.activity.check.CheckProxy;
import org.dubbo.api.service.ActivityCheckService;
import org.dubbo.api.service.ActivityService;
import org.dubbo.api.service.UserService;
import org.dubbo.pojo.bean.activity.ActivityMain;
import org.dubbo.pojo.bean.user.UserInfo;
import org.dubbo.pojo.bean.user.WxFans;
import org.dubbo.pojo.dto.activity.ActivityCheckJson;
import org.dubbo.pojo.dto.activity.ActivityCheckUserData;
import org.dubbo.pojo.dto.activity.ActivityDto;
import org.dubbo.pojo.enums.ActivityCheckResult;
import org.dubbo.pojo.redis.RedisUtil;
import org.dubbo.pojo.utils.CommonRedisKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("activityCheckService")
public class ActivityCheckServiceImpl implements ActivityCheckService{

    @Autowired
    private ActivityService activityService;

    @Autowired
    private CheckProxy checkProxy;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 活动整体校验
     *
     * @param activityDto
     * @return
     */
    @Override
    public ActivityCheckResult activityOverCheck(ActivityDto activityDto) {
        ActivityMain indexData = activityService.getIndexData(activityDto);
        ActivityCheckJson activityCheckJson = indexData.getActivityCheckJson();
        ActivityCheckUserData activityCheckUserData = new ActivityCheckUserData();
        //根据配置是否取用户积分
        if("1".equals(activityCheckJson.getIsIntegralOpen())){
            activityCheckUserData.setUserIntegral(userService.getUserIntergralByRedis(activityDto.getUnionId()));
        }
        //根据配置是否取用户活动总次数
        if("1".equals(activityCheckJson.getIsAllCountOpen())){
            Object allCount = redisUtil.hget(CommonRedisKey.acticity.ACTIVITY_ALL_COUNT + activityDto.getActivityId(), activityDto.getUnionId());
            allCount = allCount !=null?allCount:0;
            activityCheckUserData.setUserAllCount((Integer) allCount);
        }
        //根据配置是否取用户每日活动次数
        if("1".equals(activityCheckJson.getEveryDayCount())){
            Object allCount = redisUtil.hget(CommonRedisKey.acticity.ACTIVITY_EVERY_DAY_ALL_COUNT + activityDto.getActivityId(), activityDto.getUnionId());
            allCount = allCount !=null?allCount:0;
            activityCheckUserData.setUserTodayCount((Integer) allCount);
        }
        //add 封装查询伯俊用户
        UserInfo userInfo=new UserInfo();
        userInfo.setOpenId(activityDto.getOpenId());
        userInfo.setUnionId(activityDto.getUnionId());
        WxFans wxFans = userService.getWxFans(activityDto.getOpenId());
        activityCheckUserData.setUserIsSubscribe(wxFans==null?"0":wxFans.getSubscribe());
        activityCheckUserData.setUserInfo(userService.getClientVipInfo(userInfo));
        activityCheckUserData.setUserWeid(activityDto.getWeid());
        activityCheckUserData.setUserUnionId(activityDto.getUnionId());
        activityCheckJson.setActivityCheckUserData(activityCheckUserData);
        ActivityCheckResult check = checkProxy.check(activityCheckJson);
        return check;
    }
}
