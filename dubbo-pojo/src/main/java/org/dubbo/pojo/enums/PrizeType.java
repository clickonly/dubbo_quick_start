package org.dubbo.pojo.enums;

/**
 * Created by jiangbin on 2018/1/4.
 */
public enum PrizeType {

    INTEGRAL("1","积分"), COUPON("2","优惠券"),CASH("3","现金"),IMAGE("4","图片"),PIKU("5","直接发奖"),BIDPRICE("6","竞价物品"),INVENTED("7","虚拟物品"),PRODUCT("8","商品");

    private String code;
    private String desc;

    private PrizeType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }



    // 根据value返回枚举类型,主要在switch中使用
    public static PrizeType getByValue(String value) {
        for (PrizeType code : values()) {
            if (code.getCode().equals(value)) {
                return code;
            }
        }
        return null;
    }
}
