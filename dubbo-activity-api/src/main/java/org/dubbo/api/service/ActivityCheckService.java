package org.dubbo.api.service;

import org.dubbo.pojo.dto.activity.ActivityDto;
import org.dubbo.pojo.enums.ActivityCheckResult;

/**
 *  活动配置校验服务
 */
public interface ActivityCheckService {

    /**
     * 活动整体校验
     * @param activityDto
     * @return ActivityCheckResult
     */
    public ActivityCheckResult activityOverCheck(ActivityDto activityDto);



}
