package org.dubbo.pojo.dto.logistics;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * 物流查询DTO
 * Created by jiangbin on 2018/4/24.
 */
public class LogisticsSearchDto implements Serializable {

    private String OrderCode;//订单编号
    private String ShipperCode; //快递公司编码
    private String LogisticCode;//快递单号

    @JSONField(name = "OrderCode")
    public String getOrderCode() {
        return OrderCode;
    }

    public void setOrderCode(String orderCode) {
        OrderCode = orderCode;
    }

    @JSONField(name = "ShipperCode")
    public String getShipperCode() {
        return ShipperCode;
    }

    public void setShipperCode(String shipperCode) {
        ShipperCode = shipperCode;
    }
    @JSONField(name = "LogisticCode")
    public String getLogisticCode() {
        return LogisticCode;
    }

    public void setLogisticCode(String logisticCode) {
        LogisticCode = logisticCode;
    }
}
