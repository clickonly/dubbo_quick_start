package org.dubbo.pojo.dto.activity;


import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by fanglei on 2018/6/2.
 */
public class ActivityAuctionDto extends ActivityDto implements Serializable{


    private Long id;



    private Long prizeId; //当前奖项的ID

    private BigDecimal price;//当前价格

    private String timestamp;//时间戳

    private String code;

    private String message;

    private String username;//用户名称

    private String prizeIds;//奖品id列表逗号分隔

    private String addTime;

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Long prizeId) {
        this.prizeId = prizeId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPrizeIds() {
        return prizeIds;
    }

    public void setPrizeIds(String prizeIds) {
        this.prizeIds = prizeIds;
    }
}

