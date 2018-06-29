package org.dubbo.pojo.bean.wx;

import java.io.Serializable;

/**
 * Created by jiangbin on 2018/1/16.
 * 微信模板消息
 */
public class WxMessageTemplate implements Serializable {

    private Integer rentid;

    private String weid;
    private Long id;
    private String name;
    private String  type;
    private String  messageType;
    private String templateformat;
    private Integer valueCount;
    private String status;
    private String messageInfoId;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getTemplateformat() {
        return templateformat;
    }

    public void setTemplateformat(String templateformat) {
        this.templateformat = templateformat;
    }

    public Integer getValueCount() {
        return valueCount;
    }

    public void setValueCount(Integer valueCount) {
        this.valueCount = valueCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessageInfoId() {
        return messageInfoId;
    }

    public void setMessageInfoId(String messageInfoId) {
        this.messageInfoId = messageInfoId;
    }
}
