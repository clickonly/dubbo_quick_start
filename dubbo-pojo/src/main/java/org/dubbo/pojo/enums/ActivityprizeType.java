package org.dubbo.pojo.enums;

/**
 * Created by fanglei on 2018/5/24.
 */
public enum ActivityprizeType {
    //1:积分 2：优惠券 3：现金4:图片5 实物物品 6竞价物品7虚拟物品8商品

    INTEGRAL("1","积分"),COUPON("2","优惠券"),CASH("3","现金"),
    PIKU("5","实物奖品"),BIDPRICE("6","竞价物品"),INVENTED("7","虚拟物品"),PRODUCT("8","商品");
    private String code;
    private String desc;

    private ActivityprizeType(String code, String desc) {
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
    public static ActivityprizeType getByValue(String value) {
        for (ActivityprizeType code : values()) {
            if (code.getCode().equals(value)) {
                return code;
            }
        }
        return null;
    }

}
