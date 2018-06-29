package org.dubbo.pojo.dto.wx;

import java.io.Serializable;

/**
 * Created by jiangbin on 2018/1/16.
 * 发送券模板消息dto
 *
 */
public class SendVouCouponMessageDto implements Serializable {

    private Long activityId;

    private String unionid;

    private String openid;

    private String weid;

    private Long prizeId;

    private String linkNo;

    private Long wxMessageTemplateId;

    private Long couponId ;

    private String type; //发送模板类型

    private String message;

    private String url;

    private String activityName;

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getWeid() {
        return weid;
    }

    public void setWeid(String weid) {
        this.weid = weid;
    }

    public Long getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Long prizeId) {
        this.prizeId = prizeId;
    }

    public String getLinkNo() {
        return linkNo;
    }

    public void setLinkNo(String linkNo) {
        this.linkNo = linkNo;
    }

    public Long getWxMessageTemplateId() {
        return wxMessageTemplateId;
    }

    public void setWxMessageTemplateId(Long wxMessageTemplateId) {
        this.wxMessageTemplateId = wxMessageTemplateId;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }
}
