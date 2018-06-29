package org.dubbo.pojo.enums;

/**
 * Created by fanglei on 2017/12/27.
 */
public enum SubscribeFlag {

    IS_SUBSCRIBE("1","已关注");

    private String code;
    private String desc;

    private SubscribeFlag(String code, String desc) {
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
