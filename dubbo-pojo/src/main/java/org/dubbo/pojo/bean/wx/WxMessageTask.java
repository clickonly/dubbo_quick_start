package org.dubbo.pojo.bean.wx;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jiangbin on 2018/1/17.
 */
public class WxMessageTask implements Serializable {

    private Integer  rentid	;//租户id
    private String weid;//		微信id
    private Long id;//		序号
    private String  openid;//openid
    private Long templateid;//	模板id
    private String messagebody;//		消息体
    private Date insertdate;//	插入时间
    private Integer  sendtimes;//	发送次数
    private Date sendtime;//	最后一次发送时间
    private String success;//		是否成功发送
    private String errcode	;//		错误代码
    private String errmsg;//	错误信息
    private String messagetype	;//'0'		'0' 通用不显示 ‘1’ 商品资讯 ‘2’ 货品状态  3 会员消息
    private String messagetitle;//		消息标题
    private String messagedetial;//		消息明细
    private String messageurl	;//		消息明细链接
    private String messageicon;//		消息图标
    private String  messageread;//	y 已读 n 未读

    public Integer getRentid() {
        return rentid;
    }

    public void setRentid(Integer rentid) {
        this.rentid = rentid;
    }

    public String getWeid() {
        return weid;
    }

    public void setWeid(String weid) {
        this.weid = weid;
    }

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

    public Long getTemplateid() {
        return templateid;
    }

    public void setTemplateid(Long templateid) {
        this.templateid = templateid;
    }

    public String getMessagebody() {
        return messagebody;
    }

    public void setMessagebody(String messagebody) {
        this.messagebody = messagebody;
    }

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }

    public Integer getSendtimes() {
        return sendtimes;
    }

    public void setSendtimes(Integer sendtimes) {
        this.sendtimes = sendtimes;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getMessagetype() {
        return messagetype;
    }

    public void setMessagetype(String messagetype) {
        this.messagetype = messagetype;
    }

    public String getMessagetitle() {
        return messagetitle;
    }

    public void setMessagetitle(String messagetitle) {
        this.messagetitle = messagetitle;
    }

    public String getMessagedetial() {
        return messagedetial;
    }

    public void setMessagedetial(String messagedetial) {
        this.messagedetial = messagedetial;
    }

    public String getMessageurl() {
        return messageurl;
    }

    public void setMessageurl(String messageurl) {
        this.messageurl = messageurl;
    }

    public String getMessageicon() {
        return messageicon;
    }

    public void setMessageicon(String messageicon) {
        this.messageicon = messageicon;
    }

    public String getMessageread() {
        return messageread;
    }

    public void setMessageread(String messageread) {
        this.messageread = messageread;
    }
}
