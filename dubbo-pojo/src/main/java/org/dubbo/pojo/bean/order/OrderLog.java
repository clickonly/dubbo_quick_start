package org.dubbo.pojo.bean.order;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fanglei on 2017/12/19.
 */
public class OrderLog implements Serializable {

        private String p_in_json;
        private Date INSERTDATE;

    public String getP_in_json() {
        return p_in_json;
    }

    public void setP_in_json(String p_in_json) {
        this.p_in_json = p_in_json;
    }

    public Date getINSERTDATE() {
        return INSERTDATE;
    }

    public void setINSERTDATE(Date INSERTDATE) {
        this.INSERTDATE = INSERTDATE;
    }
}
