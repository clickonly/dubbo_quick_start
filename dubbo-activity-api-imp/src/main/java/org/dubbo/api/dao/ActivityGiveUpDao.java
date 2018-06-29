package org.dubbo.api.dao;

import org.dubbo.pojo.bean.activity.ActivityGiveUp;
import org.dubbo.pojo.bean.user.CardMain;
import org.dubbo.pojo.dto.activity.ActivityDto;

import java.util.List;

/**
 * Created by fanglei on 2018/4/12.
 */
public interface ActivityGiveUpDao {

    void insert(ActivityGiveUp activityGiveUp);

    /**
     * 获取一个点赞数量
     * @param activityDto
     * @return
     */
    Integer getActivityGiveUpCount(ActivityDto activityDto);

    /**
     * 获取点赞人列表
     * @param activityGiveUp
     * @return
     */
    List<CardMain> getActivityGiveUpUserList(ActivityGiveUp activityGiveUp);

    Long getSeq();
}
