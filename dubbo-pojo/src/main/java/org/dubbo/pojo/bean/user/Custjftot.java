package org.dubbo.pojo.bean.user;

import java.io.Serializable;

/**
 * Created by fanglei on 2018/5/28.
 */
public class Custjftot implements Serializable {

    private Long clentVipId;

    private Integer batch;

    private Long integral;

    private String unionid;

    private String openid;

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

    public Long getClentVipId() {
        return clentVipId;
    }

    public void setClentVipId(Long clentVipId) {
        this.clentVipId = clentVipId;
    }

    public Integer getBatch() {
        return batch;
    }

    public void setBatch(Integer batch) {
        this.batch = batch;
    }

    public Long getIntegral() {
        return integral;
    }

    public void setIntegral(Long integral) {
        this.integral = integral;
    }
}
