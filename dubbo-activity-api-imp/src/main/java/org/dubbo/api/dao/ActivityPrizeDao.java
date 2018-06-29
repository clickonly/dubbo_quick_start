package org.dubbo.api.dao;

import org.dubbo.pojo.bean.activity.ActivityPrize;

import java.util.List;

public interface ActivityPrizeDao {

    int insert(ActivityPrize record);

    ActivityPrize selectByPrimaryKey(Long id);


    List<ActivityPrize> selectByActivityId(Long activityId);

    ActivityPrize getActivityPrize(ActivityPrize activityPrize);

}