package org.dubbo.api.dao;

import org.dubbo.pojo.bean.activity.ActivityWebLog;
import org.dubbo.pojo.dto.activity.ActivityLogDto;

import java.util.List;

/**
 * Created by jinpan12430 on 2018/1/30.
 */
public interface ActivityLogDao {

    void logInsert(ActivityLogDto activityLogDto);

    /**
     * 获取用户openId集合
     * @param activityLogDto
     * @return
     */
    List<String> getUserList(ActivityLogDto activityLogDto);

    /**
     * 获取用户点击日志列表
     * @param activityLogDto
     * @return
     */
    List<ActivityWebLog> getUserUrlClickList(ActivityLogDto activityLogDto);

    /**
     * 获取用户点击日志总长度
     * @param activityLogDto
     * @return
     */
    Integer getUserUrlClickListSize(ActivityLogDto activityLogDto);
}
