package org.dubbo.pojo.bean.user;

import java.io.Serializable;

/**
 * Created by fanglei on 2018/6/11.
 */
public class UserInfo implements Serializable {

    private Long id ;
    private String nickName; //昵称
    private String realName;//真实姓名
    private String sex;
    private Long birthday;
    private String tel;
    private String email;
    private Long cStoreId; //门店ID
    private Long cCustomerId;
    private Long cardIntegral;//当前卡积分
    private String openId;
    private Long groupId;//集团卡ID
    private String cardno; //当前卡号
    private String unionId;
    private Long vipTypeId;
    private String vipTypeName;//卡类型名称
    private Long discount;
    private String groupCardNo;//集团卡号
    private Long allIntegral; //全部积分
    private String storeCode;//门店code




    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public Long getAllIntegral() {
        return allIntegral;
    }

    public void setAllIntegral(Long allIntegral) {
        this.allIntegral = allIntegral;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getcStoreId() {
        return cStoreId;
    }

    public void setcStoreId(Long cStoreId) {
        this.cStoreId = cStoreId;
    }

    public Long getcCustomerId() {
        return cCustomerId;
    }

    public void setcCustomerId(Long cCustomerId) {
        this.cCustomerId = cCustomerId;
    }

    public Long getCardIntegral() {
        return cardIntegral;
    }

    public void setCardIntegral(Long cardIntegral) {
        this.cardIntegral = cardIntegral;
    }


    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public Long getVipTypeId() {
        return vipTypeId;
    }

    public void setVipTypeId(Long vipTypeId) {
        this.vipTypeId = vipTypeId;
    }

    public String getVipTypeName() {
        return vipTypeName;
    }

    public void setVipTypeName(String vipTypeName) {
        this.vipTypeName = vipTypeName;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public String getGroupCardNo() {
        return groupCardNo;
    }

    public void setGroupCardNo(String groupCardNo) {
        this.groupCardNo = groupCardNo;
    }
}
