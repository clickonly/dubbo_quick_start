package org.dubbo.pojo.bean.product;

import java.io.Serializable;

/**
 * Created by jinpan12430 on 2017/11/20.
 */
public class GoodsElement implements Serializable {
    private Integer id;
    private String styleid;
    private String stylogo_name;
    private String stylogo_remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStyleid() {
        return styleid;
    }

    public void setStyleid(String styleid) {
        this.styleid = styleid;
    }

    public String getStylogo_name() {
        return stylogo_name;
    }

    public void setStylogo_name(String stylogo_name) {
        this.stylogo_name = stylogo_name;
    }

    public String getStylogo_remark() {
        return stylogo_remark;
    }

    public void setStylogo_remark(String stylogo_remark) {
        this.stylogo_remark = stylogo_remark;
    }
}
