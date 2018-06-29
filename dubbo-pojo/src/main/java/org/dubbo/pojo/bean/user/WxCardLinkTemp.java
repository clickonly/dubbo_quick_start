package org.dubbo.pojo.bean.user;

import java.io.Serializable;

public class WxCardLinkTemp implements Serializable {

    private Integer lcardtypeid;//关注卡类型id

    private Integer Ltypelinkid;//关联卡id

    private Integer lstoreid;//关联店商id

    public Integer getLcardtypeid() {
        return lcardtypeid;
    }

    public void setLcardtypeid(Integer lcardtypeid) {
        this.lcardtypeid = lcardtypeid;
    }

    public Integer getLtypelinkid() {
        return Ltypelinkid;
    }

    public void setLtypelinkid(Integer ltypelinkid) {
        Ltypelinkid = ltypelinkid;
    }

    public Integer getLstoreid() {
        return lstoreid;
    }

    public void setLstoreid(Integer lstoreid) {
        this.lstoreid = lstoreid;
    }
}