package org.dubbo.pojo.bean.product;

import java.io.Serializable;

/**
 * Created by jiangbin on 2018/2/9.
 */
public class GoodsBanner implements Serializable {

    private String weid;
    private String typeval;
    private String status;
    private String imgurl;

    public String getWeid() {
        return weid;
    }

    public void setWeid(String weid) {
        this.weid = weid;
    }

    public String getTypeval() {
        return typeval;
    }

    public void setTypeval(String typeval) {
        this.typeval = typeval;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
