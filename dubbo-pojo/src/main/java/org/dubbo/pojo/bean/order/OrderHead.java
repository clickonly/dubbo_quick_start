package org.dubbo.pojo.bean.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by jiangbin on 2017/12/19.
 */
public class OrderHead implements Serializable {

    private Integer	id	           ;
    private Integer	rentid		   ;
    private Integer	weid		   ;
    private String	openid			;
    private String	storeid			;
    private Date inputdate		;
    private Integer	flag	       ;//R:未确认 N:未付款 P:已付款待发货 S:已发货   T退货 A 退款申请  F 退款完成  C 取消  I已发货整单退(新增T) H已付款整单退(新增A)  D待评价 K已评价 E取消订单
    private Date	paydate	       ;
    private String	paymode	       ;//暂定为 退货方式 company:总部 store:店铺
    private BigDecimal sjje	       ;
    private BigDecimal	cjje	       ;
    private BigDecimal	zk	           ;
    private String	soucecode	   ;
    private String	ordercode	   ;
    private String	orderstatus	   ;
    private String	expressid	   ;
    private String	expresscode	   ;
    private String	ismerge	       ;
    private Integer	oriorderid	   ;
    private String	channel		   ;
    private String	unit	       ;
    private String	payunit		   ;
    private String	no	           ;
    private BigDecimal	zzje	       ;
    private String	is_voucher	   ;
    private String	vou_no	       ;
    private BigDecimal	expressprice	;
    private String	adname	       ;
    private String	address	       ;
    private String	adphone	       ;
    private BigDecimal	zhje	       ;
    private Date	n_date	       ;
    private String	sendflag	   ;//是否发到伯俊
    private Integer	c_province_id	;
    private Integer	c_city_id		;
    private Integer	c_district_id	;
    private String	c_address		;
    private String	is_allvoucher	;
    private Date	refunddate		;
    private Integer	tryorderid		;
    private String	vou_type		;
    private BigDecimal	vou_amtdis	   ;
    private String	servestore		;
    private BigDecimal	vou_amt	       ;
    private String	commnetstatus	;
    private BigDecimal	yue_zzje	   ;
    private BigDecimal	yf_zzje	       ;
    private String	yf_strtus		;
    private String	comments	   ;
    private String	unionid	       ;

    private List<OrderDetail> orderDetailList;

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRentid() {
        return rentid;
    }

    public void setRentid(Integer rentid) {
        this.rentid = rentid;
    }

    public Integer getWeid() {
        return weid;
    }

    public void setWeid(Integer weid) {
        this.weid = weid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    public Date getInputdate() {
        return inputdate;
    }

    public void setInputdate(Date inputdate) {
        this.inputdate = inputdate;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Date getPaydate() {
        return paydate;
    }

    public void setPaydate(Date paydate) {
        this.paydate = paydate;
    }

    public String getPaymode() {
        return paymode;
    }

    public void setPaymode(String paymode) {
        this.paymode = paymode;
    }

    public BigDecimal getSjje() {
        return sjje;
    }

    public void setSjje(BigDecimal sjje) {
        this.sjje = sjje;
    }

    public BigDecimal getCjje() {
        return cjje;
    }

    public void setCjje(BigDecimal cjje) {
        this.cjje = cjje;
    }

    public BigDecimal getZk() {
        return zk;
    }

    public void setZk(BigDecimal zk) {
        this.zk = zk;
    }

    public String getSoucecode() {
        return soucecode;
    }

    public void setSoucecode(String soucecode) {
        this.soucecode = soucecode;
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode;
    }

    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
    }

    public String getExpressid() {
        return expressid;
    }

    public void setExpressid(String expressid) {
        this.expressid = expressid;
    }

    public String getExpresscode() {
        return expresscode;
    }

    public void setExpresscode(String expresscode) {
        this.expresscode = expresscode;
    }

    public String getIsmerge() {
        return ismerge;
    }

    public void setIsmerge(String ismerge) {
        this.ismerge = ismerge;
    }

    public Integer getOriorderid() {
        return oriorderid;
    }

    public void setOriorderid(Integer oriorderid) {
        this.oriorderid = oriorderid;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getPayunit() {
        return payunit;
    }

    public void setPayunit(String payunit) {
        this.payunit = payunit;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public BigDecimal getZzje() {
        return zzje;
    }

    public void setZzje(BigDecimal zzje) {
        this.zzje = zzje;
    }

    public String getIs_voucher() {
        return is_voucher;
    }

    public void setIs_voucher(String is_voucher) {
        this.is_voucher = is_voucher;
    }

    public String getVou_no() {
        return vou_no;
    }

    public void setVou_no(String vou_no) {
        this.vou_no = vou_no;
    }

    public BigDecimal getExpressprice() {
        return expressprice;
    }

    public void setExpressprice(BigDecimal expressprice) {
        this.expressprice = expressprice;
    }

    public String getAdname() {
        return adname;
    }

    public void setAdname(String adname) {
        this.adname = adname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAdphone() {
        return adphone;
    }

    public void setAdphone(String adphone) {
        this.adphone = adphone;
    }

    public BigDecimal getZhje() {
        return zhje;
    }

    public void setZhje(BigDecimal zhje) {
        this.zhje = zhje;
    }

    public Date getN_date() {
        return n_date;
    }

    public void setN_date(Date n_date) {
        this.n_date = n_date;
    }

    public String getSendflag() {
        return sendflag;
    }

    public void setSendflag(String sendflag) {
        this.sendflag = sendflag;
    }

    public Integer getC_province_id() {
        return c_province_id;
    }

    public void setC_province_id(Integer c_province_id) {
        this.c_province_id = c_province_id;
    }

    public Integer getC_city_id() {
        return c_city_id;
    }

    public void setC_city_id(Integer c_city_id) {
        this.c_city_id = c_city_id;
    }

    public Integer getC_district_id() {
        return c_district_id;
    }

    public void setC_district_id(Integer c_district_id) {
        this.c_district_id = c_district_id;
    }

    public String getC_address() {
        return c_address;
    }

    public void setC_address(String c_address) {
        this.c_address = c_address;
    }

    public String getIs_allvoucher() {
        return is_allvoucher;
    }

    public void setIs_allvoucher(String is_allvoucher) {
        this.is_allvoucher = is_allvoucher;
    }

    public Date getRefunddate() {
        return refunddate;
    }

    public void setRefunddate(Date refunddate) {
        this.refunddate = refunddate;
    }

    public Integer getTryorderid() {
        return tryorderid;
    }

    public void setTryorderid(Integer tryorderid) {
        this.tryorderid = tryorderid;
    }

    public String getVou_type() {
        return vou_type;
    }

    public void setVou_type(String vou_type) {
        this.vou_type = vou_type;
    }

    public BigDecimal getVou_amtdis() {
        return vou_amtdis;
    }

    public void setVou_amtdis(BigDecimal vou_amtdis) {
        this.vou_amtdis = vou_amtdis;
    }

    public String getServestore() {
        return servestore;
    }

    public void setServestore(String servestore) {
        this.servestore = servestore;
    }

    public BigDecimal getVou_amt() {
        return vou_amt;
    }

    public void setVou_amt(BigDecimal vou_amt) {
        this.vou_amt = vou_amt;
    }

    public String getCommnetstatus() {
        return commnetstatus;
    }

    public void setCommnetstatus(String commnetstatus) {
        this.commnetstatus = commnetstatus;
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

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
}
