package org.dubbo.pojo.enums;

/**
 * Created by fanglei on 2018/5/22.
 */
public enum ContainSubactivityStatus {

    IS_Contain("1","包含");

    private String code;
    private String desc;

    private ContainSubactivityStatus(String code, String desc) {
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
