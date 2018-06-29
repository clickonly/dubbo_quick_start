package org.dubbo.pojo.bean.voucher;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by jiangbin on 2018/1/22.
 */
public class VoucherListBean implements Serializable {
       private Long id;
       private String vouchers_no;
       private String zt;
       private String vou_type;
       private BigDecimal amt_acount;
        private String is_verifyed;
        private String is_valid;
        private String  verifyed_store_id;
        private String valid_date;
        private Integer rentid;
        private String weid;
        private String openid;
        private String unionid;
        private String type;
        private String vouname;
        private Long sc_ruleid;
        private String klb;
        private BigDecimal vou_dis;
        private String usetip;
        private String  ishot;
        private String isnew;
        private Integer integral;
        private String ppurl;
        private String  usermemo;
        private String exmemo;
        private String voutype;
        private String   activitytype;
        private String  usetype;
        private String  px;
        private String  url;
        private String expintai;
        private String exdetails;
        private Date insertdate;
        private String  ruletype;
        private Long  awarid;
        private Long  wx_id;
        private String  maxdate;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getVouchers_no() {
                return vouchers_no;
        }

        public void setVouchers_no(String vouchers_no) {
                this.vouchers_no = vouchers_no;
        }

        public String getZt() {
                return zt;
        }

        public void setZt(String zt) {
                this.zt = zt;
        }

        public String getVou_type() {
                return vou_type;
        }

        public void setVou_type(String vou_type) {
                this.vou_type = vou_type;
        }

        public BigDecimal getAmt_acount() {
                return amt_acount;
        }

        public void setAmt_acount(BigDecimal amt_acount) {
                this.amt_acount = amt_acount;
        }

        public String getIs_verifyed() {
                return is_verifyed;
        }

        public void setIs_verifyed(String is_verifyed) {
                this.is_verifyed = is_verifyed;
        }

        public String getIs_valid() {
                return is_valid;
        }

        public void setIs_valid(String is_valid) {
                this.is_valid = is_valid;
        }

        public String getVerifyed_store_id() {
                return verifyed_store_id;
        }

        public void setVerifyed_store_id(String verifyed_store_id) {
                this.verifyed_store_id = verifyed_store_id;
        }

        public String getValid_date() {
                return valid_date;
        }

        public void setValid_date(String valid_date) {
                this.valid_date = valid_date;
        }

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

        public String getOpenid() {
                return openid;
        }

        public void setOpenid(String openid) {
                this.openid = openid;
        }

        public String getUnionid() {
                return unionid;
        }

        public void setUnionid(String unionid) {
                this.unionid = unionid;
        }

        public String getType() {
                return type;
        }

        public void setType(String type) {
                this.type = type;
        }

        public String getVouname() {
                return vouname;
        }

        public void setVouname(String vouname) {
                this.vouname = vouname;
        }

        public Long getSc_ruleid() {
                return sc_ruleid;
        }

        public void setSc_ruleid(Long sc_ruleid) {
                this.sc_ruleid = sc_ruleid;
        }

        public String getKlb() {
                return klb;
        }

        public void setKlb(String klb) {
                this.klb = klb;
        }

        public BigDecimal getVou_dis() {
                return vou_dis;
        }

        public void setVou_dis(BigDecimal vou_dis) {
                this.vou_dis = vou_dis;
        }

        public String getUsetip() {
                return usetip;
        }

        public void setUsetip(String usetip) {
                this.usetip = usetip;
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

        public String getActivitytype() {
                return activitytype;
        }

        public void setActivitytype(String activitytype) {
                this.activitytype = activitytype;
        }

        public String getUsetype() {
                return usetype;
        }

        public void setUsetype(String usetype) {
                this.usetype = usetype;
        }

        public String getPx() {
                return px;
        }

        public void setPx(String px) {
                this.px = px;
        }

        public String getUrl() {
                return url;
        }

        public void setUrl(String url) {
                this.url = url;
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

        public Date getInsertdate() {
                return insertdate;
        }

        public void setInsertdate(Date insertdate) {
                this.insertdate = insertdate;
        }

        public String getRuletype() {
                return ruletype;
        }

        public void setRuletype(String ruletype) {
                this.ruletype = ruletype;
        }

        public Long getAwarid() {
                return awarid;
        }

        public void setAwarid(Long awarid) {
                this.awarid = awarid;
        }

        public Long getWx_id() {
                return wx_id;
        }

        public void setWx_id(Long wx_id) {
                this.wx_id = wx_id;
        }

        public String getMaxdate() {
                return maxdate;
        }

        public void setMaxdate(String maxdate) {
                this.maxdate = maxdate;
        }
}
