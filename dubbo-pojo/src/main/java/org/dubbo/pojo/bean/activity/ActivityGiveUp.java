package org.dubbo.pojo.bean.activity;

import org.dubbo.pojo.base.PageBase;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fanglei on 2018/4/12.
 */
public class ActivityGiveUp extends PageBase implements Serializable {

    private Long id;
    private String openid;
    private String unionid;
    private Date add_time;
    private Long activityId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public Date getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Date add_time) {
        this.add_time = add_time;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }
}
