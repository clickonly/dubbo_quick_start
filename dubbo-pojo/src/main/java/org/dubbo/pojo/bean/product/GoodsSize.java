package org.dubbo.pojo.bean.product;

import java.io.Serializable;

/**
 * Created by jinpan12430 on 2017/11/20.
 */
public class GoodsSize implements Serializable {
    private String sizecode;
    private String sizedetail;
    private String sizename;



    public String getSizecode() {
        return sizecode;
    }

    public void setSizecode(String sizecode) {
        this.sizecode = sizecode;
    }

    public String getSizedetail() {
        return sizedetail;
    }

    public void setSizedetail(String sizedetail) {
        this.sizedetail = sizedetail;
    }

    public String getSizename() {
        return sizename;
    }

    public void setSizename(String sizename) {
        this.sizename = sizename;
    }
}
