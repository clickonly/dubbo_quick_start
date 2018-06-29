package org.dubbo.pojo.dto.product;

import java.io.Serializable;

/**
 * Created by jiangbin on 2018/1/17.
 */
public class GoodsCountDto implements Serializable {

    private String start_time;
    private String end_time;
    private String status;

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
