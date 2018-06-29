package org.dubbo.pojo.dto.voucher;

import java.io.Serializable;

/**
 * Created by fanglei on 2018/4/17.
 */
public class EchangeVoucherDto implements Serializable {

    private String unionId;
    private String openId;
    private Integer num;
    private Long vouid;
    private Long integeral;

    public Long getIntegeral() {
        return integeral;
    }

    public void setIntegeral(Long integeral) {
        this.integeral = integeral;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getVouid() {
        return vouid;
    }

    public void setVouid(Long vouid) {
        this.vouid = vouid;
    }
}
