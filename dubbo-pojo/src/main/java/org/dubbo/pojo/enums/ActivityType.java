package org.dubbo.pojo.enums;

/**
 * Created by jiangbin on 2018/1/4.
 */
public enum ActivityType {

    LOTTERY("1","抽奖"),
    GONGGE("2","九宫格"),
    SHAKE("3","摇一摇"),
    EXCHANGE("4","兑奖"),
    INTEGRAL("5","积分加油"),
    TICKET_POOL("6","资格池"),
    BID_PRICE("7","竞价")
    ;

    private String code;
    private String desc;

    private ActivityType(String code, String desc) {
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
