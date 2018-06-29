package org.dubbo.pojo.bean.user;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 会员卡表
 * Created by fanglei on 2017/12/13.
 */
public class CardMain implements Serializable {

    private Integer id;

    private Integer  rentId;  //租户ID

    private Long weId;

    private String openId;

    private Integer cardType; //卡类型\

    private String cardNo; //卡号码

    private String userName; //昵称

    private Integer jfye; //剩余积分

    private Integer jfTotal ;//总积分

    private Integer jfxf ;//消费积分

    private Integer jfSign;//签到积分

    private Integer xfje ;//总消费积分

    private String tel ;//联系电话

    private Date birthday ;// 生日

    private String birthdayStr; //生日的字符串  yyyy-mm-dd

    private String address; //地址

    private String sex;//性别

    private String email;//邮箱

    private String status ;//状态

    private String  remark;//集团卡号

    private Date modifyDate;  //更新时间

    private Date  inputDate;// 开卡时间

    private Date  validDate ;//到期时间

    private String isLink; //是否绑定

    private String  linkSource; //绑定来源

    private String linkId; //绑定ID

    private Integer roleId; //角色ID，0会员，1客服 2阵列师

    private Integer kfId; //客服ID

    private String  kkStore; //开卡门店

    private String isSend; //是否发送生日祝福

    private Integer sendTime; //发送次数

    private String cdmunionId;

    private  String  cdmSourceType ; //来源类型

    private String  cdmSourceVal;//来源值

    private String  isPostFitting ; //是否邮寄试衣

    private Integer PostFittingTime;//邮寄次数

    private BigDecimal oYearPayAmount;//一年的消费金额

    private BigDecimal dYearPayAmount; //当前年的消费金额

    private Integer oYearPayCount; //一年消费次数

    private Integer dYearPayCount ;//前年消费次数

    private BigDecimal oMonthPayAmount; //当前月份消费金额

    private Integer oMonthPayCount; //当前消费次数

    private BigDecimal dMonthPayAmount;//上一个消费金额

    private Integer dMonthPayCount;//上一个消费次数

    private Integer jnbean;
    private Integer by1;
    private String by2;
    private String by3;
    private String wxOpenId;//微信传入的openid

    private String uuId;//手机APP端登录用uuid

    private String unionId; //unionId,同步wx_fans

    private String nickName; //新增真实姓名对应伯俊的NICKNAME

    private Long integral; //当前积分

    private String cardlevel;//卡等级

    private String cynum;//超越数量

    private Integer dqlintegral; //清除的积分

    private Integer c_viptype_id; //直营店ID

    private String yt;

    private String storeCode;

    private String headimgurl;

    private Long levelid;

    private Double discount;

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Long getLevelid() {
        return levelid;
    }

    public void setLevelid(Long levelid) {
        this.levelid = levelid;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public Integer getC_viptype_id() {
        return c_viptype_id;
    }

    public void setC_viptype_id(Integer c_viptype_id) {
        this.c_viptype_id = c_viptype_id;
    }

    public String getYt() {
        return yt;
    }

    public void setYt(String yt) {
        this.yt = yt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRentId() {
        return rentId;
    }

    public void setRentId(Integer rentId) {
        this.rentId = rentId;
    }

    public Long getWeId() {
        return weId;
    }

    public void setWeId(Long weId) {
        this.weId = weId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getJfye() {
        return jfye;
    }

    public void setJfye(Integer jfye) {
        this.jfye = jfye;
    }

    public Integer getJfTotal() {
        return jfTotal;
    }

    public void setJfTotal(Integer jfTotal) {
        this.jfTotal = jfTotal;
    }

    public Integer getJfxf() {
        return jfxf;
    }

    public void setJfxf(Integer jfxf) {
        this.jfxf = jfxf;
    }

    public Integer getJfSign() {
        return jfSign;
    }

    public void setJfSign(Integer jfSign) {
        this.jfSign = jfSign;
    }

    public Integer getXfje() {
        return xfje;
    }

    public void setXfje(Integer xfje) {
        this.xfje = xfje;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getBirthdayStr() {
        return birthdayStr;
    }

    public void setBirthdayStr(String birthdayStr) {
        this.birthdayStr = birthdayStr;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public String getIsLink() {
        return isLink;
    }

    public void setIsLink(String isLink) {
        this.isLink = isLink;
    }

    public String getLinkSource() {
        return linkSource;
    }

    public void setLinkSource(String linkSource) {
        this.linkSource = linkSource;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getKfId() {
        return kfId;
    }

    public void setKfId(Integer kfId) {
        this.kfId = kfId;
    }

    public String getKkStore() {
        return kkStore;
    }

    public void setKkStore(String kkStore) {
        this.kkStore = kkStore;
    }

    public String getIsSend() {
        return isSend;
    }

    public void setIsSend(String isSend) {
        this.isSend = isSend;
    }

    public Integer getSendTime() {
        return sendTime;
    }

    public void setSendTime(Integer sendTime) {
        this.sendTime = sendTime;
    }

    public String getCdmunionId() {
        return cdmunionId;
    }

    public void setCdmunionId(String cdmunionId) {
        this.cdmunionId = cdmunionId;
    }

    public String getCdmSourceType() {
        return cdmSourceType;
    }

    public void setCdmSourceType(String cdmSourceType) {
        this.cdmSourceType = cdmSourceType;
    }

    public String getCdmSourceVal() {
        return cdmSourceVal;
    }

    public void setCdmSourceVal(String cdmSourceVal) {
        this.cdmSourceVal = cdmSourceVal;
    }

    public String getIsPostFitting() {
        return isPostFitting;
    }

    public void setIsPostFitting(String isPostFitting) {
        this.isPostFitting = isPostFitting;
    }

    public Integer getPostFittingTime() {
        return PostFittingTime;
    }

    public void setPostFittingTime(Integer postFittingTime) {
        PostFittingTime = postFittingTime;
    }

    public BigDecimal getoYearPayAmount() {
        return oYearPayAmount;
    }

    public void setoYearPayAmount(BigDecimal oYearPayAmount) {
        this.oYearPayAmount = oYearPayAmount;
    }

    public BigDecimal getdYearPayAmount() {
        return dYearPayAmount;
    }

    public void setdYearPayAmount(BigDecimal dYearPayAmount) {
        this.dYearPayAmount = dYearPayAmount;
    }

    public Integer getoYearPayCount() {
        return oYearPayCount;
    }

    public void setoYearPayCount(Integer oYearPayCount) {
        this.oYearPayCount = oYearPayCount;
    }

    public Integer getdYearPayCount() {
        return dYearPayCount;
    }

    public void setdYearPayCount(Integer dYearPayCount) {
        this.dYearPayCount = dYearPayCount;
    }

    public BigDecimal getoMonthPayAmount() {
        return oMonthPayAmount;
    }

    public void setoMonthPayAmount(BigDecimal oMonthPayAmount) {
        this.oMonthPayAmount = oMonthPayAmount;
    }

    public Integer getoMonthPayCount() {
        return oMonthPayCount;
    }

    public void setoMonthPayCount(Integer oMonthPayCount) {
        this.oMonthPayCount = oMonthPayCount;
    }

    public BigDecimal getdMonthPayAmount() {
        return dMonthPayAmount;
    }

    public void setdMonthPayAmount(BigDecimal dMonthPayAmount) {
        this.dMonthPayAmount = dMonthPayAmount;
    }

    public Integer getdMonthPayCount() {
        return dMonthPayCount;
    }

    public void setdMonthPayCount(Integer dMonthPayCount) {
        this.dMonthPayCount = dMonthPayCount;
    }

    public Integer getJnbean() {
        return jnbean;
    }

    public void setJnbean(Integer jnbean) {
        this.jnbean = jnbean;
    }

    public Integer getBy1() {
        return by1;
    }

    public void setBy1(Integer by1) {
        this.by1 = by1;
    }

    public String getBy2() {
        return by2;
    }

    public void setBy2(String by2) {
        this.by2 = by2;
    }

    public String getBy3() {
        return by3;
    }

    public void setBy3(String by3) {
        this.by3 = by3;
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Long getIntegral() {
        return integral;
    }

    public void setIntegral(Long integral) {
        this.integral = integral;
    }

    public String getCardlevel() {
        return cardlevel;
    }

    public void setCardlevel(String cardlevel) {
        this.cardlevel = cardlevel;
    }

    public String getCynum() {
        return cynum;
    }

    public void setCynum(String cynum) {
        this.cynum = cynum;
    }

    public Integer getDqlintegral() {
        return dqlintegral;
    }

    public void setDqlintegral(Integer dqlintegral) {
        this.dqlintegral = dqlintegral;
    }
}
