package org.dubbo.pojo.dto.logistics;

import java.io.Serializable;

/**
 * Created by fanglei on 2018/4/24.
 */
public class TracesDto implements Serializable {

    private String AcceptTime;
    private String AcceptStation;

    private String Remark;
    private String LogisticCode;
    private String OrderCode;

    public String getOrderCode() {
        return OrderCode;
    }

    public void setOrderCode(String orderCode) {
        OrderCode = orderCode;
    }

    public String getAcceptTime() {
        return AcceptTime;
    }

    public void setAcceptTime(String acceptTime) {
        AcceptTime = acceptTime;
    }

    public String getAcceptStation() {
        return AcceptStation;
    }

    public void setAcceptStation(String acceptStation) {
        AcceptStation = acceptStation;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getLogisticCode() {
        return LogisticCode;
    }

    public void setLogisticCode(String logisticCode) {
        LogisticCode = logisticCode;
    }
}
