package org.dubbo.pojo.dto.voucher;

import java.io.Serializable;

/**
 * Created by jiangbin on 2018/1/19.
 */
public class VoucherDto implements Serializable {

    private String weid;

    private String tel;
    private String openid;
    private String unionid;
    private String status;
    private String isVaild;

    public String getWeid() {
        return weid;
    }

    public void setWeid(String weid) {
        this.weid = weid;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsVaild() {
        return isVaild;
    }

    public void setIsVaild(String isVaild) {
        this.isVaild = isVaild;
    }
}
