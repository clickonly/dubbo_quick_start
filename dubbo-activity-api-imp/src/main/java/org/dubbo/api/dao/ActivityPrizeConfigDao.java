package org.dubbo.api.dao;

import org.dubbo.pojo.bean.activity.ActivityPrizeConfig;

import java.util.List;

public interface ActivityPrizeConfigDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ActivityPrizeConfig record);

    int insertSelective(ActivityPrizeConfig record);

    ActivityPrizeConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ActivityPrizeConfig record);

    int updateByPrimaryKey(ActivityPrizeConfig record);

    List<ActivityPrizeConfig> selectByActivityId (Integer ActivityId);
}