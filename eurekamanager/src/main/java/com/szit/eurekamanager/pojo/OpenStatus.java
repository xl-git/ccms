package com.szit.eurekamanager.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 申请卡状态实体类
 */
public class OpenStatus implements Serializable {
    private Integer id;//--主键（可选值1、2、3）
    private Integer userId;//--用户外键id
    private String status ;//--申请卡状态（1为待审核，2为成功，3为失败）
    private Date opDate;
    private Integer cardType;
    private User user;//用户实体类对象

    public OpenStatus() {
    }


    public OpenStatus(Integer id, Integer userId, String status, Date opDate, Integer cardType, User user) {
        this.id = id;
        this.userId = userId;
        this.status = status;
        this.opDate = opDate;
        this.cardType = cardType;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOpDate() {
        return opDate;
    }

    public void setOpDate(Date opDate) {
        this.opDate = opDate;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
