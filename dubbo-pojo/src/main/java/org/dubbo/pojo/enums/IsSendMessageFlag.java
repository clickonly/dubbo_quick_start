package org.dubbo.pojo.enums;

/**
 * Created by jiangbin on 2018/1/11.
 */
public enum IsSendMessageFlag {

    SEND("1","发送模板消息"),NO_SEND("0","不发送模板消息");

    private String code;
    private String desc;

    private IsSendMessageFlag(String code, String desc) {
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
