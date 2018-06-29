package org.dubbo.pojo.bean.user;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jiangbin on 2017/12/26.
 */
public class WxFans implements Serializable {

    private Long rentid;//租户ID

    private Long weid;//微信ID
    private String openid;//OpenId
    private String nickname;//昵称
    private String sex;//性别
    private String language;
    private String province;
    private String city;
    private String country;
    private String headimgurl;
    private String      subscribe;
    private Date subscribe_time;
    private Integer       groupid;//分组编号
    private String groupidissync;//分组是否同步
    private   Date   syncdate;//最后一次同步时间
    private Date insertdate;
    private String   havecard;//是否有卡
    private Integer cardid;
    private Date        lastlinkdate;//最后一次联系时间
    private Date lastorderdate;//最后一次下单时间
    private Integer  sourceqrid;//二维码来源ID
    private String unionid;
    private Date      unsubscribe_time;//取消关注时间
    private String issend;//生日当天是否发送了生日提醒
    private Integer   sendtime;//发送次数
    private Integer messagenum;//消息数
    private Integer   collectnum;//收藏夹数
    private Integer  cartnum;//购物车数
    private String      fssourcetype;
    private String fssourceval;
    private Long id;


    public Long getRentid() {
        return rentid;
    }

    public void setRentid(Long rentid) {
        this.rentid = rentid;
    }

    public Long getWeid() {
        return weid;
    }

    public void setWeid(Long weid) {
        this.weid = weid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(String subscribe) {
        this.subscribe = subscribe;
    }

    public Date getSubscribe_time() {
        return subscribe_time;
    }

    public void setSubscribe_time(Date subscribe_time) {
        this.subscribe_time = subscribe_time;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public String getGroupidissync() {
        return groupidissync;
    }

    public void setGroupidissync(String groupidissync) {
        this.groupidissync = groupidissync;
    }

    public Date getSyncdate() {
        return syncdate;
    }

    public void setSyncdate(Date syncdate) {
        this.syncdate = syncdate;
    }

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }

    public String getHavecard() {
        return havecard;
    }

    public void setHavecard(String havecard) {
        this.havecard = havecard;
    }

    public Integer getCardid() {
        return cardid;
    }

    public void setCardid(Integer cardid) {
        this.cardid = cardid;
    }

    public Date getLastlinkdate() {
        return lastlinkdate;
    }

    public void setLastlinkdate(Date lastlinkdate) {
        this.lastlinkdate = lastlinkdate;
    }

    public Date getLastorderdate() {
        return lastorderdate;
    }

    public void setLastorderdate(Date lastorderdate) {
        this.lastorderdate = lastorderdate;
    }

    public Integer getSourceqrid() {
        return sourceqrid;
    }

    public void setSourceqrid(Integer sourceqrid) {
        this.sourceqrid = sourceqrid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public Date getUnsubscribe_time() {
        return unsubscribe_time;
    }

    public void setUnsubscribe_time(Date unsubscribe_time) {
        this.unsubscribe_time = unsubscribe_time;
    }

    public String getIssend() {
        return issend;
    }

    public void setIssend(String issend) {
        this.issend = issend;
    }

    public Integer getSendtime() {
        return sendtime;
    }

    public void setSendtime(Integer sendtime) {
        this.sendtime = sendtime;
    }

    public Integer getMessagenum() {
        return messagenum;
    }

    public void setMessagenum(Integer messagenum) {
        this.messagenum = messagenum;
    }

    public Integer getCollectnum() {
        return collectnum;
    }

    public void setCollectnum(Integer collectnum) {
        this.collectnum = collectnum;
    }

    public Integer getCartnum() {
        return cartnum;
    }

    public void setCartnum(Integer cartnum) {
        this.cartnum = cartnum;
    }

    public String getFssourcetype() {
        return fssourcetype;
    }

    public void setFssourcetype(String fssourcetype) {
        this.fssourcetype = fssourcetype;
    }

    public String getFssourceval() {
        return fssourceval;
    }

    public void setFssourceval(String fssourceval) {
        this.fssourceval = fssourceval;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
