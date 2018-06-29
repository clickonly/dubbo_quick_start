package org.dubbo.pojo.enums;

/**
 * Created by jiangbin on 2018/1/4.
 * 活动奖项类型
 */
public enum ActivityPrizeClass {

    JACKPOT("1","奖池"),WINNING_RATE("2","中奖率"),EXCHANGE("3","兑奖");

    private String code;
    private String desc;

    private ActivityPrizeClass(String code, String desc) {
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
