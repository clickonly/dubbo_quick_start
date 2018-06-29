package org.dubbo.pojo.bean.user;

import java.io.Serializable;
import java.util.Date;

public class WxQrcode implements Serializable{
    //ID
    private Long id;
    //租户ID
    private Long rentid;
    //微信ID
    private Long weid;
    //二维码场景ID号，要一直递增，永久的不能超过100000，
    private Integer qrcid;
    //关联的编号，可能是店铺或者是人员
    private String linkid;
    //场景名称
    private String name;
    //类型,MKT：店铺二维码，POS （pos的二维码）   ,HD   活动二维码,GXQ   关系券二维码
    private String type;
    //模式，0永久，1临时
    private String model;
    //标识
    private String ticket;
    //过期时间，秒数，永久的为0
    private Integer exprire;
    //创建时间
    private Date createtime;
    //状态，N未生成，Y有效，S停用
    private String status;
    private String webpos_no;
    private String url;
    //导购ID，只有导购的身份才能具有，且是永久的
    private Integer employeeid;
    //WEBPOS流水编号
    private String order_id;
    //款机编号
    private String str1;
    private Date updatetime;
    //关系券关联ID
    private String voucherlink;
    //new_activityid    关联new_activity  扫码送券
    private Integer new_activityid;
    private String qrurl;
    private String qnurl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRentid() {
        return rentid;
    }

    public void setRentid(Long rentid) {
        this.rentid = rentid;
    }

    public Long getWeid() {
        return weid;
    }

    public void setWeid(Long weid) {
        this.weid = weid;
    }

    public Integer getQrcid() {
        return qrcid;
    }

    public void setQrcid(Integer qrcid) {
        this.qrcid = qrcid;
    }

    public String getLinkid() {
        return linkid;
    }

    public void setLinkid(String linkid) {
        this.linkid = linkid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getExprire() {
        return exprire;
    }

    public void setExprire(Integer exprire) {
        this.exprire = exprire;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWebpos_no() {
        return webpos_no;
    }

    public void setWebpos_no(String webpos_no) {
        this.webpos_no = webpos_no;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getVoucherlink() {
        return voucherlink;
    }

    public void setVoucherlink(String voucherlink) {
        this.voucherlink = voucherlink;
    }

    public Integer getNew_activityid() {
        return new_activityid;
    }

    public void setNew_activityid(Integer new_activityid) {
        this.new_activityid = new_activityid;
    }

    public String getQrurl() {
        return qrurl;
    }

    public void setQrurl(String qrurl) {
        this.qrurl = qrurl;
    }

    public String getQnurl() {
        return qnurl;
    }

    public void setQnurl(String qnurl) {
        this.qnurl = qnurl;
    }
}