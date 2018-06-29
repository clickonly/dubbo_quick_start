package org.dubbo.pojo.bean.user;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable{

    private Integer cid;
    //集团卡号
    private String cno;
    //UNIID
    private String unionid;
    //会员类别
    private Integer ccurjfye;
    //消费日期
    private Date lcastxfdate;
    //状态
    private String cstatus;

    private String ctype;

    private String cinitweid;
    //江南豆
    private Integer ccurzhje1;
    //账户金额2
    private Integer ccurzhje2;
    //账户金额3
    private Integer ccurzhje3;
    //账户金额4
    private Integer ccurzhje4;
    //账户金额5
    private Integer ccurzhje5;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public Integer getCcurjfye() {
        return ccurjfye;
    }

    public void setCcurjfye(Integer ccurjfye) {
        this.ccurjfye = ccurjfye;
    }

    public Date getLcastxfdate() {
        return lcastxfdate;
    }

    public void setLcastxfdate(Date lcastxfdate) {
        this.lcastxfdate = lcastxfdate;
    }

    public String getCstatus() {
        return cstatus;
    }

    public void setCstatus(String cstatus) {
        this.cstatus = cstatus;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public String getCinitweid() {
        return cinitweid;
    }

    public void setCinitweid(String cinitweid) {
        this.cinitweid = cinitweid;
    }

    public Integer getCcurzhje1() {
        return ccurzhje1;
    }

    public void setCcurzhje1(Integer ccurzhje1) {
        this.ccurzhje1 = ccurzhje1;
    }

    public Integer getCcurzhje2() {
        return ccurzhje2;
    }

    public void setCcurzhje2(Integer ccurzhje2) {
        this.ccurzhje2 = ccurzhje2;
    }

    public Integer getCcurzhje3() {
        return ccurzhje3;
    }

    public void setCcurzhje3(Integer ccurzhje3) {
        this.ccurzhje3 = ccurzhje3;
    }

    public Integer getCcurzhje4() {
        return ccurzhje4;
    }

    public void setCcurzhje4(Integer ccurzhje4) {
        this.ccurzhje4 = ccurzhje4;
    }

    public Integer getCcurzhje5() {
        return ccurzhje5;
    }

    public void setCcurzhje5(Integer ccurzhje5) {
        this.ccurzhje5 = ccurzhje5;
    }
}