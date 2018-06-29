package org.dubbo.pojo.bean.user;

import java.io.Serializable;

public class EmployeeBase implements Serializable {

    private Integer id;

    private String linkstore;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLinkstore() {
        return linkstore;
    }

    public void setLinkstore(String linkstore) {
        this.linkstore = linkstore;
    }
}