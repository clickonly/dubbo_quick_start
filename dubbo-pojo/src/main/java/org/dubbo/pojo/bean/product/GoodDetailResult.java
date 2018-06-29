package org.dubbo.pojo.bean.product;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jinpan12430 on 2017/11/20.
 */
public class GoodDetailResult implements Serializable{
    private String isCollect;
    private GoodsImage modelImage;
    private List<GoodsInfo> productInfo;
    private Integer cartSumGoods;
    private List<GoodsSizeTableItem> goodSizeTable ;
    private List<GoodsElement> goodsElement ;
    private List<String> topCarouselImgs;
    private List<GoodsSize> goodsSize;

    private List<GoodsStock> goodsStockList;

    private List<GoodsStockInfo> goodsStockInfos;

    public List<GoodsStockInfo> getGoodsStockInfos() {
        return goodsStockInfos;
    }

    public void setGoodsStockInfos(List<GoodsStockInfo> goodsStockInfos) {
        this.goodsStockInfos = goodsStockInfos;
    }

    public List<GoodsStock> getGoodsStockList() {
        return goodsStockList;
    }

    public void setGoodsStockList(List<GoodsStock> goodsStockList) {
        this.goodsStockList = goodsStockList;
    }

    public String getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(String isCollect) {
        this.isCollect = isCollect;
    }

    public GoodsImage getModelImage() {
        return modelImage;
    }

    public void setModelImage(GoodsImage modelImage) {
        this.modelImage = modelImage;
    }

    public List<GoodsInfo> getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(List<GoodsInfo> productInfo) {
        this.productInfo = productInfo;
    }

    public Integer getCartSumGoods() {
        return cartSumGoods;
    }

    public void setCartSumGoods(Integer cartSumGoods) {
        this.cartSumGoods = cartSumGoods;
    }

    public List<GoodsSizeTableItem> getGoodSizeTable() {
        return goodSizeTable;
    }

    public void setGoodSizeTable(List<GoodsSizeTableItem> goodSizeTable) {
        this.goodSizeTable = goodSizeTable;
    }

    public List<GoodsElement> getGoodsElement() {
        return goodsElement;
    }

    public void setGoodsElement(List<GoodsElement> goodsElement) {
        this.goodsElement = goodsElement;
    }

    public List<String> getTopCarouselImgs() {
        return topCarouselImgs;
    }

    public void setTopCarouselImgs(List<String> topCarouselImgs) {
        this.topCarouselImgs = topCarouselImgs;
    }

    public List<GoodsSize> getGoodsSize() {
        return goodsSize;
    }

    public void setGoodsSize(List<GoodsSize> goodsSize) {
        this.goodsSize = goodsSize;
    }
}
