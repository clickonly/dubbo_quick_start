package org.dubbo.pojo.bean.user;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fanglei on 2017/12/19.
 */
public class SmsMessageCheck implements Serializable {

    private Integer id;

    private String tel;
    private String code;
    private Date insertDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }
}
