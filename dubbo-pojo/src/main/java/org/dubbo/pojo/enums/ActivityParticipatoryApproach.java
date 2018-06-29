package org.dubbo.pojo.enums;

/**
 * Created by jiangbin on 2018/1/4.
 * 活动参与方式
 */
public enum ActivityParticipatoryApproach {

    NOT_INTEGRAL("0","无积分参与"),IS_INTEGRAL("1","需要积分参与"),IS_APPOINT("2","指定人员");


    private String code;
    private String desc;

    private ActivityParticipatoryApproach(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
