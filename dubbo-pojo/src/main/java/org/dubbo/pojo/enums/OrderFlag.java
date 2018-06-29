package org.dubbo.pojo.enums;

/**
 * 订单flag枚举
 * Created by jiangbin on 2017/12/19.
 */
public enum OrderFlag {
//R:未确认 N:未付款 P:已付款待发货 S:已发货
// T退货 A 退款申请  F 退款完成  C 取消
//  I已发货整单退(新增T) H已付款整单退(新增A)  D待评价 K已评价 E取消订单
    UNCONFIRMED("R","未确认"),
    UNPAID("N","未付款"),
    PENDING_DELIVERY("P","已付款待发货"),
    DELIVERY("S","已发货"),REFUNDS("T","退货"),
    REFUND_APPLICATION("A","退款申请"),
    REFUND_FINISH("F","退款完成"),
    CANCEL("C","取消"),
    DELIVERY_REFUND("I","已发货整单退(新增T)"),
    REFUND_All("H","已付款整单退(新增A)"),
    WAIT_EVALUATE("D","待评价"),
    END_EVALUATE("K","已评价"),
    CANCEL_ORDER("E","取消订单");


    private String code;
    private String desc;

    private OrderFlag(String code, String desc) {
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
