package org.dubbo.api.dao;

import org.dubbo.pojo.bean.activity.ActivityParticipation;

public interface ActivityParticipationDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ActivityParticipation record);

    int insertSelective(ActivityParticipation record);

    ActivityParticipation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ActivityParticipation record);

    int updateByPrimaryKey(ActivityParticipation record);
}