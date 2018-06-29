package org.dubbo.pojo.bean.user;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by fanglei on 2017/12/27.
 */
public class CardType implements Serializable {

    private Integer id;

    private String name;

    private String weid;

    private String linkSource;//来源

    private String isMin; //是否最低级别

    private String linkId;
    private Integer levelId; //级次，用于微购物

    private BigDecimal zk;//折扣

    private String image;
    private String memo;
    private Integer nextLevel;//升级到下一级别所需积分

    private String pp;//品牌

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeid() {
        return weid;
    }

    public void setWeid(String weid) {
        this.weid = weid;
    }

    public String getLinkSource() {
        return linkSource;
    }

    public void setLinkSource(String linkSource) {
        this.linkSource = linkSource;
    }

    public String getIsMin() {
        return isMin;
    }

    public void setIsMin(String isMin) {
        this.isMin = isMin;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public BigDecimal getZk() {
        return zk;
    }

    public void setZk(BigDecimal zk) {
        this.zk = zk;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getNextLevel() {
        return nextLevel;
    }

    public void setNextLevel(Integer nextLevel) {
        this.nextLevel = nextLevel;
    }

    public String getPp() {
        return pp;
    }

    public void setPp(String pp) {
        this.pp = pp;
    }
}
