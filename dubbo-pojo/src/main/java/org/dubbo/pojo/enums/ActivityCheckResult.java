package org.dubbo.pojo.enums;

public enum ActivityCheckResult {

    SUCCESS("0","校验成功"),
    NOT_FOLLOW("-1","用户未关注"),
    NOT_ENOUGH_INTEGRAL("-2","用户积分不足"),
    TODAY_OVER_LIMIT("-3","用户今日参与次数超出限制"),
    BAN("-4","当前用户被禁止参与本次活动"),
    NOT_ALLOW("-5","用户无参加活动权限"),
    USER_EXCEPTION("-6","用户粉丝信息异常"),
    TODAT_NOT_START("-7","今日活动还未开始"),
    USER_LEVEL_NOT_ENOUGH("-8","用户会员等级不足"),
    ALL_OVER_LIMIT("-9","活动总次数超出限制"),
    TODAT_END("-10","今日活动已结束"),
    TICKET_COUNT_OVER_LIMIT("-11","剩余名额不足"),
    USER_JOINED("-12","用户已参与成功"),
    NOT_BIND_CARD("-13","用户未绑卡"),
    NOT_START("-14","活动未开始"),
    WEID_NOT_ALLOW("-15","当前品牌不参与活动"),
    MISS_OPENID("-16","OPENID缺失"),
    MISS_UNIONID("-17","UNIONID缺失"),
    MISS_WEID("-18","WEID缺失"),
    MISS_ACTIVITY_ID("-19","ACTIVITY_ID缺失"),
    NOT_OPEN_CARD("-20","用户未开卡"),
    END("-21","活动结束"),
    ERROR("-22","系统繁忙"),
    OFFER_LESS_MAX("-23","用户出价低于最高价")
    ;

    private String code;
    private String desc;

    private ActivityCheckResult(String code, String desc) {
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
