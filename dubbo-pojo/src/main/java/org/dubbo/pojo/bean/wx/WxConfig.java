package org.dubbo.pojo.bean.wx;

import java.io.Serializable;

/**
 * Created by jiangbin on 2018/1/16.
 */
public class WxConfig implements Serializable {

    private Integer rentid;

    private String weid;

    private String appid;
    private  String appsecret;
    private String hash;

    private String type;
    private String token;

    private String accesstoken;

    private String name;
    private String account;

    private String original;

    private String signature;
    private String country;
    private String province;
    private String city;
    private String username;
    private String password;
    private String welcome;
    private String default_message	;
    private String default_period	;
    private String  lastupdate	;
    private String subscribepage;
    private String createcardpage	;//	y			开卡页面
    private String bindcardpage	;//	y			绑卡页面
    private String iswgw;//	'n'		是否上了微购物
    private String  wgwhash;//	y			微购物hash,对应wg_config.hash
    private String cardimage	;//	y			会员卡图片
    private String cardprivilege	;//	y			会员卡特权，可以写成html格式
    private String createcardcol;//	y			开卡需要的字段
    private String createcardintro	;//	y			开卡说明，可以写成html格式
    private String bindcardcol;//	y			绑卡需要的字段
    private String bindcardintro	;//	y			绑卡说明，可以写成html格式
    private String cardindexcol;//	y			卡主页显示字段，用逗号分隔
    private String cardusercol;//	y			卡个人信息字段
    private String   cardcanunbind;//	'n'		是否可以解绑
    private String cardisunion;//	'n'		是否使用粉丝的unionid来关联多个公众号
    private String ppinfourl	;//	y			品牌介绍
    private String fhstore;//	y			发货仓库编号
    private String  id	;//y
    private String indexnum	;//y			个人中心排序
    private String englishpp	;//	y			英文品牌
    private String  logurl	;//	y			品牌图片

    public Integer getRentid() {
        return rentid;
    }

    public void setRentid(Integer rentid) {
        this.rentid = rentid;
    }

    public String getWeid() {
        return weid;
    }

    public void setWeid(String weid) {
        this.weid = weid;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAccesstoken() {
        return accesstoken;
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWelcome() {
        return welcome;
    }

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }

    public String getDefault_message() {
        return default_message;
    }

    public void setDefault_message(String default_message) {
        this.default_message = default_message;
    }

    public String getDefault_period() {
        return default_period;
    }

    public void setDefault_period(String default_period) {
        this.default_period = default_period;
    }

    public String getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(String lastupdate) {
        this.lastupdate = lastupdate;
    }

    public String getSubscribepage() {
        return subscribepage;
    }

    public void setSubscribepage(String subscribepage) {
        this.subscribepage = subscribepage;
    }

    public String getCreatecardpage() {
        return createcardpage;
    }

    public void setCreatecardpage(String createcardpage) {
        this.createcardpage = createcardpage;
    }

    public String getBindcardpage() {
        return bindcardpage;
    }

    public void setBindcardpage(String bindcardpage) {
        this.bindcardpage = bindcardpage;
    }

    public String getIswgw() {
        return iswgw;
    }

    public void setIswgw(String iswgw) {
        this.iswgw = iswgw;
    }

    public String getWgwhash() {
        return wgwhash;
    }

    public void setWgwhash(String wgwhash) {
        this.wgwhash = wgwhash;
    }

    public String getCardimage() {
        return cardimage;
    }

    public void setCardimage(String cardimage) {
        this.cardimage = cardimage;
    }

    public String getCardprivilege() {
        return cardprivilege;
    }

    public void setCardprivilege(String cardprivilege) {
        this.cardprivilege = cardprivilege;
    }

    public String getCreatecardcol() {
        return createcardcol;
    }

    public void setCreatecardcol(String createcardcol) {
        this.createcardcol = createcardcol;
    }

    public String getCreatecardintro() {
        return createcardintro;
    }

    public void setCreatecardintro(String createcardintro) {
        this.createcardintro = createcardintro;
    }

    public String getBindcardcol() {
        return bindcardcol;
    }

    public void setBindcardcol(String bindcardcol) {
        this.bindcardcol = bindcardcol;
    }

    public String getBindcardintro() {
        return bindcardintro;
    }

    public void setBindcardintro(String bindcardintro) {
        this.bindcardintro = bindcardintro;
    }

    public String getCardindexcol() {
        return cardindexcol;
    }

    public void setCardindexcol(String cardindexcol) {
        this.cardindexcol = cardindexcol;
    }

    public String getCardusercol() {
        return cardusercol;
    }

    public void setCardusercol(String cardusercol) {
        this.cardusercol = cardusercol;
    }

    public String getCardcanunbind() {
        return cardcanunbind;
    }

    public void setCardcanunbind(String cardcanunbind) {
        this.cardcanunbind = cardcanunbind;
    }

    public String getCardisunion() {
        return cardisunion;
    }

    public void setCardisunion(String cardisunion) {
        this.cardisunion = cardisunion;
    }

    public String getPpinfourl() {
        return ppinfourl;
    }

    public void setPpinfourl(String ppinfourl) {
        this.ppinfourl = ppinfourl;
    }

    public String getFhstore() {
        return fhstore;
    }

    public void setFhstore(String fhstore) {
        this.fhstore = fhstore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIndexnum() {
        return indexnum;
    }

    public void setIndexnum(String indexnum) {
        this.indexnum = indexnum;
    }

    public String getEnglishpp() {
        return englishpp;
    }

    public void setEnglishpp(String englishpp) {
        this.englishpp = englishpp;
    }

    public String getLogurl() {
        return logurl;
    }

    public void setLogurl(String logurl) {
        this.logurl = logurl;
    }
}
