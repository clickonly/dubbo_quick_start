package org.dubbo.api.service;


import org.dubbo.pojo.dto.activity.ActivityDto;
import org.dubbo.pojo.enums.ActivityCheckResult;
import org.dubbo.pojo.redis.RedisUtil;

public interface CheckActivityRuleService {
    /**
     * 校验用户是否满足活动规则
     * @return
     * code 返回不满足活动规则的枚举code
     */
    public ActivityCheckResult checkActivityRule(ActivityDto activityDto, RedisUtil redisUtil);

}
