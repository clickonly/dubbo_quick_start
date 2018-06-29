package org.dubbo.pojo.bean.user;

import java.io.Serializable;

public class CardTypeApply implements Serializable {

    private Integer oaid;

    private String weid;

    private String username;

    private String userphone;

    private String cardtype;

    private String status;

    public Integer getOaid() {
        return oaid;
    }

    public void setOaid(Integer oaid) {
        this.oaid = oaid;
    }

    public String getWeid() {
        return weid;
    }

    public void setWeid(String weid) {
        this.weid = weid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}