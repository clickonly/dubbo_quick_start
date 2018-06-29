package org.dubbo.pojo.bean.activity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by jiangbin on 2018/1/10.
 */
public class VoucherBase  implements Serializable {

    private Integer id;

    private Integer rentid;
    private Long weid;
    private String openid;
    private String name;
    private String type;//类型，dxjq:店铺现金券，dzkq：店铺折扣券，vzkq:线上折扣券，czk:储值卡，lshd:临时获得券,qyzz权益转增
    private Date insertdate;
    private String insertsource;//生成来源，lsxxx:：零售单xx生成
    private String linksource;//关联id，如erp系统中的券号，e：erp系统，s本系统
    private String no;//券号，如erp系统中的券号
    private String status ;//状态标志，n无效，y有效
    private Date verifyeddate;//核销日期
    private String verifyedtype;//核销类型：x：消费，z：转赠，g：过期，s转赠中（转赠给某人但对方未确认）
    private String hykh;//会员卡号
    private Integer sclx;//	首次生成该券的类型:1:微信券，0：短信券
    private String tel;//推送手机号
    private String hash;//推送到的相关hash
    private String bodjt;//关联伯俊系统中的单据头
    private BigDecimal amt;//金额

    private String kkdc;//开卡店仓
    private String maxdate;//有效期描述
    private String memo;

    private String islock;//		是否锁定
    private Integer sc_ruleid;//	商城券规则id,对应表wx_scrule
    private Integer awarid;//奖品id
    private Integer givetimes;//赠送次数
    private Date    lastgivedate	;//	最后赠送时间
    private String bjisverifyed	;//是否核销
    private Date bjverifytime	;//n	date	y			核销时间
    private Integer bjverifystore;//核销店铺
    private  BigDecimal bjmoney;	//
    private Integer validdate	;//
    private Integer validmindate	;//
    private String ishot;//				最热
    private String isnew	;//	最新
    private Integer integral;//积分
    private String  ppurl	;//pp图片路径
    private String   usermemo	;//	使用说明
    private String  exmemo	;//	兑换说明
    private String   voutype	;//	券类型   y 优惠券    h  活动券
    private String  expintai;	//	使用渠道a微信商城 b正价门店c通用
    private String  exdetails;//	优惠详情
    private String exmonthid	;//允许兑换月份 (为空全年，不为空 new_activitymonth 表   id  )
    private String unionid1	;//n
    private Integer uservalidity;//兑换有效期（自兑换日起的天数）

    private String unionid;

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public Integer getUservalidity() {
        return uservalidity;
    }

    public void setUservalidity(Integer uservalidity) {
        this.uservalidity = uservalidity;
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

    public Long getWeid() {
        return weid;
    }

    public void setWeid(Long weid) {
        this.weid = weid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
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

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }

    public String getInsertsource() {
        return insertsource;
    }

    public void setInsertsource(String insertsource) {
        this.insertsource = insertsource;
    }

    public String getLinksource() {
        return linksource;
    }

    public void setLinksource(String linksource) {
        this.linksource = linksource;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getVerifyeddate() {
        return verifyeddate;
    }

    public void setVerifyeddate(Date verifyeddate) {
        this.verifyeddate = verifyeddate;
    }

    public String getVerifyedtype() {
        return verifyedtype;
    }

    public void setVerifyedtype(String verifyedtype) {
        this.verifyedtype = verifyedtype;
    }

    public String getHykh() {
        return hykh;
    }

    public void setHykh(String hykh) {
        this.hykh = hykh;
    }

    public Integer getSclx() {
        return sclx;
    }

    public void setSclx(Integer sclx) {
        this.sclx = sclx;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getBodjt() {
        return bodjt;
    }

    public void setBodjt(String bodjt) {
        this.bodjt = bodjt;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public String getKkdc() {
        return kkdc;
    }

    public void setKkdc(String kkdc) {
        this.kkdc = kkdc;
    }

    public String getMaxdate() {
        return maxdate;
    }

    public void setMaxdate(String maxdate) {
        this.maxdate = maxdate;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getIslock() {
        return islock;
    }

    public void setIslock(String islock) {
        this.islock = islock;
    }

    public Integer getSc_ruleid() {
        return sc_ruleid;
    }

    public void setSc_ruleid(Integer sc_ruleid) {
        this.sc_ruleid = sc_ruleid;
    }

    public Integer getAwarid() {
        return awarid;
    }

    public void setAwarid(Integer awarid) {
        this.awarid = awarid;
    }

    public Integer getGivetimes() {
        return givetimes;
    }

    public void setGivetimes(Integer givetimes) {
        this.givetimes = givetimes;
    }

    public Date getLastgivedate() {
        return lastgivedate;
    }

    public void setLastgivedate(Date lastgivedate) {
        this.lastgivedate = lastgivedate;
    }

    public String getBjisverifyed() {
        return bjisverifyed;
    }

    public void setBjisverifyed(String bjisverifyed) {
        this.bjisverifyed = bjisverifyed;
    }

    public Date getBjverifytime() {
        return bjverifytime;
    }

    public void setBjverifytime(Date bjverifytime) {
        this.bjverifytime = bjverifytime;
    }

    public Integer getBjverifystore() {
        return bjverifystore;
    }

    public void setBjverifystore(Integer bjverifystore) {
        this.bjverifystore = bjverifystore;
    }

    public BigDecimal getBjmoney() {
        return bjmoney;
    }

    public void setBjmoney(BigDecimal bjmoney) {
        this.bjmoney = bjmoney;
    }

    public Integer getValiddate() {
        return validdate;
    }

    public void setValiddate(Integer validdate) {
        this.validdate = validdate;
    }

    public Integer getValidmindate() {
        return validmindate;
    }

    public void setValidmindate(Integer validmindate) {
        this.validmindate = validmindate;
    }

    public String getIshot() {
        return ishot;
    }

    public void setIshot(String ishot) {
        this.ishot = ishot;
    }

    public String getIsnew() {
        return isnew;
    }

    public void setIsnew(String isnew) {
        this.isnew = isnew;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public String getPpurl() {
        return ppurl;
    }

    public void setPpurl(String ppurl) {
        this.ppurl = ppurl;
    }

    public String getUsermemo() {
        return usermemo;
    }

    public void setUsermemo(String usermemo) {
        this.usermemo = usermemo;
    }

    public String getExmemo() {
        return exmemo;
    }

    public void setExmemo(String exmemo) {
        this.exmemo = exmemo;
    }

    public String getVoutype() {
        return voutype;
    }

    public void setVoutype(String voutype) {
        this.voutype = voutype;
    }

    public String getExpintai() {
        return expintai;
    }

    public void setExpintai(String expintai) {
        this.expintai = expintai;
    }

    public String getExdetails() {
        return exdetails;
    }

    public void setExdetails(String exdetails) {
        this.exdetails = exdetails;
    }

    public String getExmonthid() {
        return exmonthid;
    }

    public void setExmonthid(String exmonthid) {
        this.exmonthid = exmonthid;
    }

    public String getUnionid1() {
        return unionid1;
    }

    public void setUnionid1(String unionid1) {
        this.unionid1 = unionid1;
    }
}
