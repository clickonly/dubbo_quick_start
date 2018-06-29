package org.dubbo.pojo.bean.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by fanglei on 2017/12/19.
 */
public class OrderDetail implements Serializable {

    private Integer id	;
    private Integer orderid	;
    private Integer goodsid	;
    private Integer skuid	;
    private BigDecimal price	;			//吊牌价
    private Integer sl	;			//数量
    private BigDecimal je	;			//吊牌金额
    private Date inputdate	;	//		时间
    private Integer cid	;			//购物车id
    private BigDecimal yhprice	;		//	优惠价
    private Integer activityid	;		//	活动id
    private Integer trydetailid	;		//	预约试衣id
    private double vipzk	;			//会员折扣
    private BigDecimal activityprice	;		//	促销金额
    private BigDecimal vouprice	;			//券金额
    private BigDecimal amt_actualprice	;		//	支付金额
    private BigDecimal amt_actualje	;		//	支付总金额
    private String more	;	//	备注
    private Integer integral	;		//	扣除积分（积分兑换）
    private BigDecimal yue_zzje	;		//	预付款余额
    private BigDecimal yf_zzje	;			//预付金额
    private String yf_strtus	;		//是否是预付款
    private String comments	;		//添加说明

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getSkuid() {
        return skuid;
    }

    public void setSkuid(Integer skuid) {
        this.skuid = skuid;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSl() {
        return sl;
    }

    public void setSl(Integer sl) {
        this.sl = sl;
    }

    public BigDecimal getJe() {
        return je;
    }

    public void setJe(BigDecimal je) {
        this.je = je;
    }

    public Date getInputdate() {
        return inputdate;
    }

    public void setInputdate(Date inputdate) {
        this.inputdate = inputdate;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public BigDecimal getYhprice() {
        return yhprice;
    }

    public void setYhprice(BigDecimal yhprice) {
        this.yhprice = yhprice;
    }

    public Integer getActivityid() {
        return activityid;
    }

    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
    }

    public Integer getTrydetailid() {
        return trydetailid;
    }

    public void setTrydetailid(Integer trydetailid) {
        this.trydetailid = trydetailid;
    }

    public double getVipzk() {
        return vipzk;
    }

    public void setVipzk(double vipzk) {
        this.vipzk = vipzk;
    }

    public BigDecimal getActivityprice() {
        return activityprice;
    }

    public void setActivityprice(BigDecimal activityprice) {
        this.activityprice = activityprice;
    }

    public BigDecimal getVouprice() {
        return vouprice;
    }

    public void setVouprice(BigDecimal vouprice) {
        this.vouprice = vouprice;
    }

    public BigDecimal getAmt_actualprice() {
        return amt_actualprice;
    }

    public void setAmt_actualprice(BigDecimal amt_actualprice) {
        this.amt_actualprice = amt_actualprice;
    }

    public BigDecimal getAmt_actualje() {
        return amt_actualje;
    }

    public void setAmt_actualje(BigDecimal amt_actualje) {
        this.amt_actualje = amt_actualje;
    }

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public BigDecimal getYue_zzje() {
        return yue_zzje;
    }

    public void setYue_zzje(BigDecimal yue_zzje) {
        this.yue_zzje = yue_zzje;
    }

    public BigDecimal getYf_zzje() {
        return yf_zzje;
    }

    public void setYf_zzje(BigDecimal yf_zzje) {
        this.yf_zzje = yf_zzje;
    }

    public String getYf_strtus() {
        return yf_strtus;
    }

    public void setYf_strtus(String yf_strtus) {
        this.yf_strtus = yf_strtus;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
