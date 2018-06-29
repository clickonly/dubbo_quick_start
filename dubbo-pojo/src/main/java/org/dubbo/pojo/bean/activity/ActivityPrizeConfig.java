package org.dubbo.pojo.bean.activity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

public class ActivityPrizeConfig implements Serializable {

    //抽奖活动配置json
    private Integer probability; //奖池
    private Double odds ; //中奖几率 如果是按照中奖率 此项添加0.90相当于90%

    //奖项基本配置
    private String isSend; //是否发送模板消息
    private Integer num ;//奖项数量
    private String image; //奖项显示图片
    private Long deductionIntegral;//兑换商品扣除积分
    Map<String,String> urlMap; //模板消息跳转的连接


    //奖项结果
    private Integer couponId; //优惠券ID
    private Long integral;//积分
    private BigDecimal cash;//现金奖项
    private String productId; //商品款号
    private String skuNo;//商品库存sku

    public String getSkuNo() {
        return skuNo;
    }

    public void setSkuNo(String skuNo) {
        this.skuNo = skuNo;
    }

    public Map<String, String> getUrlMap() {
        return urlMap;
    }

    public void setUrlMap(Map<String, String> urlMap) {
        this.urlMap = urlMap;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Long getIntegral() {
        return integral;
    }

    public void setIntegral(Long integral) {
        this.integral = integral;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }


    public Integer getProbability() {
        return probability;
    }

    public void setProbability(Integer probability) {
        this.probability = probability;
    }

    public Double getOdds() {
        return odds;
    }

    public void setOdds(Double odds) {
        this.odds = odds;
    }

    public String getIsSend() {
        return isSend;
    }

    public void setIsSend(String isSend) {
        this.isSend = isSend;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getDeductionIntegral() {
        return deductionIntegral;
    }

    public void setDeductionIntegral(Long deductionIntegral) {
        this.deductionIntegral = deductionIntegral;
    }
}