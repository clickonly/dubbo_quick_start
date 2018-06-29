package org.dubbo.pojo.dto.logistics;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fanglei on 2018/4/24.
 */
public class LogisticResponseDto implements Serializable {

    private String EBusinessID;//用户ID
    private String OrderCode;//订单编号
    private String ShipperCode;//快递公司编码
    private String LogisticCode;//物流运单号
    private String Success;//成功与否
    private String Reason;//失败原因
    private String State;//物流状态：2-在途中,3-签收,4-问题件

    private List<TracesDto> Traces;

    public String getEBusinessID() {
        return EBusinessID;
    }

    public void setEBusinessID(String EBusinessID) {
        this.EBusinessID = EBusinessID;
    }

    public String getOrderCode() {
        return OrderCode;
    }

    public void setOrderCode(String orderCode) {
        OrderCode = orderCode;
    }

    public String getShipperCode() {
        return ShipperCode;
    }

    public void setShipperCode(String shipperCode) {
        ShipperCode = shipperCode;
    }

    public String getLogisticCode() {
        return LogisticCode;
    }

    public void setLogisticCode(String logisticCode) {
        LogisticCode = logisticCode;
    }

    public String getSuccess() {
        return Success;
    }

    public void setSuccess(String success) {
        Success = success;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public List<TracesDto> getTraces() {
        return Traces;
    }

    public void setTraces(List<TracesDto> traces) {
        Traces = traces;
    }
}
