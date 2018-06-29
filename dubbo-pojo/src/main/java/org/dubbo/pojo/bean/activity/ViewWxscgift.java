package org.dubbo.pojo.bean.activity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by fanglei on 2018/1/10.
 */
public class ViewWxscgift implements Serializable {

    private  Integer id;
    private  Integer activityid;
    private Integer version;
    private String name;
    private String type;
    private Integer rate;
    private Integer num;
    private Integer hitnum;
    private Integer levelnumber;
    private String  imageurl;
    private String  nullaward;
    private String   nulllotteryaward;
    private Date createtime;
    private Date modifiedtime;
    private Double mz;//奖品面值（元/分/折）
    private Double zk;
    private Date sdate;
    private Date edate;
    private String usememo;
    private String usedtype; //适用活动方式：‘r:开卡；‘m’:绑卡；‘msq’：满送券；‘scjf’：商城积分换券
    private String frompp;//t/j/l/c/a
    private String topp;//t/j/l/c/a
    private Integer jz;//基准率，用于jcxjq
    private BigDecimal qz; //消费满，用于jcxjq
    private Integer is_zk;//是否折扣券
    private String is_dclimit;
    private String  jelimit;//类型 LSJE 零售金额，ZHJE 折后金额
    private String  pp; //品牌限制
    private Integer year; //年份
    private String bd;//波段
    private String dl;//大类
    private String xl; //小类
    private String ms;
    private String jetype;//若jeype为ZHJE，则限制折扣上限
    private Integer vousl;//使用张数限制
    private Integer qtylimit;//折扣券购买件数限制
    private Integer  ruleid;
    private String isnew;
    private String  ishot;
    private Integer uservalidity;//兑换有效期（自兑换日起的天数）
    private String  exmonthid;//	允许兑换月份 (y为全年，n为 new_activitymonth 表  月份  )
    private String exmember;//兑换对象
    private String  expintai;//a微信商城 b正价门店c通用
    private String exdetails;//优惠详情
    private String limiting_condition;//限制条件 和numlimit  组合使用（m月，y年）
    private String ppurl;//pp图片
    private String vou_type;//y 优惠券  h  活动券

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivityid() {
        return activityid;
    }

    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getHitnum() {
        return hitnum;
    }

    public void setHitnum(Integer hitnum) {
        this.hitnum = hitnum;
    }

    public Integer getLevelnumber() {
        return levelnumber;
    }

    public void setLevelnumber(Integer levelnumber) {
        this.levelnumber = levelnumber;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getNullaward() {
        return nullaward;
    }

    public void setNullaward(String nullaward) {
        this.nullaward = nullaward;
    }

    public String getNulllotteryaward() {
        return nulllotteryaward;
    }

    public void setNulllotteryaward(String nulllotteryaward) {
        this.nulllotteryaward = nulllotteryaward;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(Date modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    public Double getMz() {
        return mz;
    }

    public void setMz(Double mz) {
        this.mz = mz;
    }

    public Double getZk() {
        return zk;
    }

    public void setZk(Double zk) {
        this.zk = zk;
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    public Date getEdate() {
        return edate;
    }

    public void setEdate(Date edate) {
        this.edate = edate;
    }

    public String getUsememo() {
        return usememo;
    }

    public void setUsememo(String usememo) {
        this.usememo = usememo;
    }

    public String getUsedtype() {
        return usedtype;
    }

    public void setUsedtype(String usedtype) {
        this.usedtype = usedtype;
    }

    public String getFrompp() {
        return frompp;
    }

    public void setFrompp(String frompp) {
        this.frompp = frompp;
    }

    public String getTopp() {
        return topp;
    }

    public void setTopp(String topp) {
        this.topp = topp;
    }

    public Integer getJz() {
        return jz;
    }

    public void setJz(Integer jz) {
        this.jz = jz;
    }

    public BigDecimal getQz() {
        return qz;
    }

    public void setQz(BigDecimal qz) {
        this.qz = qz;
    }

    public Integer getIs_zk() {
        return is_zk;
    }

    public void setIs_zk(Integer is_zk) {
        this.is_zk = is_zk;
    }

    public String getIs_dclimit() {
        return is_dclimit;
    }

    public void setIs_dclimit(String is_dclimit) {
        this.is_dclimit = is_dclimit;
    }

    public String getJelimit() {
        return jelimit;
    }

    public void setJelimit(String jelimit) {
        this.jelimit = jelimit;
    }

    public String getPp() {
        return pp;
    }

    public void setPp(String pp) {
        this.pp = pp;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    public String getDl() {
        return dl;
    }

    public void setDl(String dl) {
        this.dl = dl;
    }

    public String getXl() {
        return xl;
    }

    public void setXl(String xl) {
        this.xl = xl;
    }

    public String getMs() {
        return ms;
    }

    public void setMs(String ms) {
        this.ms = ms;
    }

    public String getJetype() {
        return jetype;
    }

    public void setJetype(String jetype) {
        this.jetype = jetype;
    }

    public Integer getVousl() {
        return vousl;
    }

    public void setVousl(Integer vousl) {
        this.vousl = vousl;
    }

    public Integer getQtylimit() {
        return qtylimit;
    }

    public void setQtylimit(Integer qtylimit) {
        this.qtylimit = qtylimit;
    }

    public Integer getRuleid() {
        return ruleid;
    }

    public void setRuleid(Integer ruleid) {
        this.ruleid = ruleid;
    }

    public String getIsnew() {
        return isnew;
    }

    public void setIsnew(String isnew) {
        this.isnew = isnew;
    }

    public String getIshot() {
        return ishot;
    }

    public void setIshot(String ishot) {
        this.ishot = ishot;
    }

    public Integer getUservalidity() {
        return uservalidity;
    }

    public void setUservalidity(Integer uservalidity) {
        this.uservalidity = uservalidity;
    }

    public String getExmonthid() {
        return exmonthid;
    }

    public void setExmonthid(String exmonthid) {
        this.exmonthid = exmonthid;
    }

    public String getExmember() {
        return exmember;
    }

    public void setExmember(String exmember) {
        this.exmember = exmember;
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

    public String getLimiting_condition() {
        return limiting_condition;
    }

    public void setLimiting_condition(String limiting_condition) {
        this.limiting_condition = limiting_condition;
    }

    public String getPpurl() {
        return ppurl;
    }

    public void setPpurl(String ppurl) {
        this.ppurl = ppurl;
    }

    public String getVou_type() {
        return vou_type;
    }

    public void setVou_type(String vou_type) {
        this.vou_type = vou_type;
    }
}
