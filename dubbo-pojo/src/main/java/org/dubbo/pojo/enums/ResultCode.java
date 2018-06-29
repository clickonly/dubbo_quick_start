package org.dubbo.pojo.enums;

/**
 * Created by fanglei on 2017/11/20.
 */
public enum ResultCode {

    SUCCESS("0000","成功"),
    ACTIVITY_ID_CHIIP_NOT_MATCH("9989","活动ID与兑奖参数不匹配"),
    ACTIVITY_BRAND_NOT_ALLOW("9990","当前品牌不参与此次活动"),
    ACTIVITY_NOT_START("9991","活动未开始"),
    ACTIVITY_END("9992","活动已结束"),
    ACTIVITY_CLOSE("9993","活动未开启"),
    ACTIVITY_ID_NOT_FOUND("9994","活动Id不存在"),
    USER_PRIZE_NOT_EQUAL("9995","操作记录条数与期望不符"),
    USER_PRIZE_NOT_ENOUGHT("9996","用户兑奖图标不足"),
    PARAMS_EXCEPTION("9997","参数异常"),
    NOT_ENOUGH_PARAMS("9998","参数不足"),
    FAIL("9999","系统错误"),
    TICKET_NOT_ENOUGH("9988","名额已兑换完毕"),
    OVER_TIMES("9987","兑换次数超出限制"),
    NOT_ENOUGH_INTEGRAL("9986","用户积分不足");

    private String code;
    private String desc;

    private ResultCode(String code, String desc) {
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
