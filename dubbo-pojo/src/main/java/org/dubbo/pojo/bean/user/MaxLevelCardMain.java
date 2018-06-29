package org.dubbo.pojo.bean.user;

import java.io.Serializable;
import java.util.Date;

public class MaxLevelCardMain implements Serializable{

    private Integer lLinkId;

    private String cardno;

    private Integer lCardTypeId;

    private String lLinkSource;

    private Integer levelid;

    private Integer integral;

    private Date validdate;

    private Date birthday;

    private String email;

    private String mobil;

    private String vipname;

    private String sex;

    private String rowid;

    private Integer c_store_id;

    private Integer memberno;

    public String getlLinkSource() {
        return lLinkSource;
    }

    public void setlLinkSource(String lLinkSource) {
        this.lLinkSource = lLinkSource;
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public Integer getMemberno() {
        return memberno;
    }

    public void setMemberno(Integer memberno) {
        this.memberno = memberno;
    }

    public Integer getlLinkId() {
        return lLinkId;
    }

    public void setlLinkId(Integer lLinkId) {
        this.lLinkId = lLinkId;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public Integer getlCardTypeId() {
        return lCardTypeId;
    }

    public void setlCardTypeId(Integer lCardTypeId) {
        this.lCardTypeId = lCardTypeId;
    }

    public Integer getLevelid() {
        return levelid;
    }

    public void setLevelid(Integer levelid) {
        this.levelid = levelid;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Date getValiddate() {
        return validdate;
    }

    public void setValiddate(Date validdate) {
        this.validdate = validdate;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVipname() {
        return vipname;
    }

    public void setVipname(String vipname) {
        this.vipname = vipname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRowid() {
        return rowid;
    }

    public void setRowid(String rowid) {
        this.rowid = rowid;
    }

    public Integer getC_store_id() {
        return c_store_id;
    }

    public void setC_store_id(Integer c_store_id) {
        this.c_store_id = c_store_id;
    }
}