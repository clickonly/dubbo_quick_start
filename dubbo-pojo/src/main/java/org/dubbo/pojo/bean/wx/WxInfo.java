package org.dubbo.pojo.bean.wx;

import java.io.Serializable;

/**
 * Created by fanglei on 2018/4/13.
 */
public class WxInfo  implements Serializable {

    private String weid;

    private String appid;
    private String accesstoken;
    private String expire_time;
    private String jsapi_ticket;
    private String ticket_expire_times;

    public String getWeid() {
        return weid;
    }

    public void setWeid(String weid) {
        this.weid = weid;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAccesstoken() {
        return accesstoken;
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken;
    }

    public String getExpire_time() {
        return expire_time;
    }

    public void setExpire_time(String expire_time) {
        this.expire_time = expire_time;
    }

    public String getJsapi_ticket() {
        return jsapi_ticket;
    }

    public void setJsapi_ticket(String jsapi_ticket) {
        this.jsapi_ticket = jsapi_ticket;
    }

    public String getTicket_expire_times() {
        return ticket_expire_times;
    }

    public void setTicket_expire_times(String ticket_expire_times) {
        this.ticket_expire_times = ticket_expire_times;
    }
}
