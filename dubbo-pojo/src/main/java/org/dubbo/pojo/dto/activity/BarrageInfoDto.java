package org.dubbo.pojo.dto.activity;

import org.dubbo.pojo.base.PageActivityBase;

import java.io.Serializable;

/**
 * Created by jiangbin on 2018/3/28.
 */
public class BarrageInfoDto extends PageActivityBase implements Serializable {

    private Long activityId;

    private String weid;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getWeid() {
        return weid;
    }

    public void setWeid(String weid) {
        this.weid = weid;
    }
}
