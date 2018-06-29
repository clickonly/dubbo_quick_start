package org.dubbo.pojo.bean.product;

import com.alibaba.dubbo.common.utils.DubboAppender;

import java.io.Serializable;

/**
 * Created by fanglei on 2017/12/21.
 */
public class GoodsClass implements Serializable {

    private Integer codevalue;
    private String codetype;
    private String is_activity;
    private String id;
    private String str_3;
    private String str_4;
    private String str_5;
    private String imgurl;
    private String weid;
    private String commodity;
    private String codename;

    public Integer getCodevalue() {
        return codevalue;
    }

    public void setCodevalue(Integer codevalue) {
        this.codevalue = codevalue;
    }

    public String getCodetype() {
        return codetype;
    }

    public void setCodetype(String codetype) {
        this.codetype = codetype;
    }

    public String getIs_activity() {
        return is_activity;
    }

    public void setIs_activity(String is_activity) {
        this.is_activity = is_activity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStr_3() {
        return str_3;
    }

    public void setStr_3(String str_3) {
        this.str_3 = str_3;
    }

    public String getStr_4() {
        return str_4;
    }

    public void setStr_4(String str_4) {
        this.str_4 = str_4;
    }

    public String getStr_5() {
        return str_5;
    }

    public void setStr_5(String str_5) {
        this.str_5 = str_5;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getWeid() {
        return weid;
    }

    public void setWeid(String weid) {
        this.weid = weid;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }
}
