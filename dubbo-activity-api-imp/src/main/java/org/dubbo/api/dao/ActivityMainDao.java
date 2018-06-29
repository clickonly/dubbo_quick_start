package org.dubbo.api.dao;

import org.dubbo.pojo.bean.activity.ActivityMain;
import org.dubbo.pojo.dto.activity.ActivityDto;

import java.util.List;

public interface ActivityMainDao {

    ActivityMain getActivityInfo(Long id);

    /**
     * 通过父ID获取子活列表
     */
    List<ActivityMain> getSubactivityList(Long parentId);


    /**
     * 获取要启动定时任务的活动
     * @return
     */
    List<ActivityMain>  getTaskActivityMain();
}