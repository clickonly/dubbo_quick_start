package org.dubbo.pojo.bean.activity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by jiangbin on 2018/1/9.
 * 优惠券规则
 */
public class NewActivityAward implements Serializable {
    private Integer id;
    private Integer activityId;
    private Integer version;
    private String name;
    private String type;//奖品类型：'xjq'：店现金券；‘hgjf’:换购积分；‘zkq’：折扣券；‘jcxjq’：交叉现金券；‘wxsc’：商城券
    private Integer rate;
    private Integer num;
    private Integer hitnum;
    private Integer levelnumber;
    private String imageurl;
    private String nullaward;//卡类型限制
    private String nulllotteryaward;//兑换规则
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
    private Integer ruleid;//jcxjq规则id,若为‘wxsc’券则对应wx_scrule ruleid
    private BigDecimal qz; //消费满，用于jcxjq

    private Integer is_zk;//是否折扣券
    private Integer numlimit;//兑换张数限制
    private Integer is_gg;//是否广告款
    private String  ggurl;//广告图地址
    private String changdp;//使用店铺，若为‘y’，则搜索new_activitystore表
    private String isqudao;//显示渠道 z 直营 j 经销 a 通用
    private Integer validmode;
    private Integer validbegin;
    private Integer  validend;
    private Integer qd;
    private String isnew;
    private String  ishot;
    private String flag1;
    private String flag2;
    private String flag3;
    private Integer uservalidity;//兑换有效期（自兑换日起的天数）
    private String  exmonthid;//	允许兑换月份 (y为全年，n为 new_activitymonth 表  月份  )
    private String exmember;//兑换对象
    private String  expintai;//a微信商城 b正价门店c通用
    private String exdetails;//优惠详情
    private String limiting_condition;//限制条件 和numlimit  组合使用（m月，y年）
    private String ppurl;//pp图片
    private String vou_type;//y 优惠券  h  活动券
    private Integer jnby_vouid;//	关系券关联id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
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

    public Integer getRuleid() {
        return ruleid;
    }

    public void setRuleid(Integer ruleid) {
        this.ruleid = ruleid;
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

    public Integer getNumlimit() {
        return numlimit;
    }

    public void setNumlimit(Integer numlimit) {
        this.numlimit = numlimit;
    }

    public Integer getIs_gg() {
        return is_gg;
    }

    public void setIs_gg(Integer is_gg) {
        this.is_gg = is_gg;
    }

    public String getGgurl() {
        return ggurl;
    }

    public void setGgurl(String ggurl) {
        this.ggurl = ggurl;
    }

    public String getChangdp() {
        return changdp;
    }

    public void setChangdp(String changdp) {
        this.changdp = changdp;
    }

    public String getIsqudao() {
        return isqudao;
    }

    public void setIsqudao(String isqudao) {
        this.isqudao = isqudao;
    }

    public Integer getValidmode() {
        return validmode;
    }

    public void setValidmode(Integer validmode) {
        this.validmode = validmode;
    }

    public Integer getValidbegin() {
        return validbegin;
    }

    public void setValidbegin(Integer validbegin) {
        this.validbegin = validbegin;
    }

    public Integer getValidend() {
        return validend;
    }

    public void setValidend(Integer validend) {
        this.validend = validend;
    }

    public Integer getQd() {
        return qd;
    }

    public void setQd(Integer qd) {
        this.qd = qd;
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

    public String getFlag1() {
        return flag1;
    }

    public void setFlag1(String flag1) {
        this.flag1 = flag1;
    }

    public String getFlag2() {
        return flag2;
    }

    public void setFlag2(String flag2) {
        this.flag2 = flag2;
    }

    public String getFlag3() {
        return flag3;
    }

    public void setFlag3(String flag3) {
        this.flag3 = flag3;
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

    public Integer getJnby_vouid() {
        return jnby_vouid;
    }

    public void setJnby_vouid(Integer jnby_vouid) {
        this.jnby_vouid = jnby_vouid;
    }
}
