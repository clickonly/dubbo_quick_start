package org.dubbo.pojo.enums;

/**
 * Created by fanglei on 2018/1/4.
 */
public enum ActivitySendStatus {

    IS_SEND("1","已发送"),NOT_SEND("0","未发送"),OTHER("-1","发奖异常");

    private String code;
    private String desc;

    private ActivitySendStatus(String code, String desc) {
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
