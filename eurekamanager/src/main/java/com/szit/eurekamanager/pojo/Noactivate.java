package com.szit.eurekamanager.pojo;

public class Noactivate {
    private Integer userId;
    private String cardNum;
    private String name;
    private String identityCard;
    private String iphoneNum;
    private String status;

    public Noactivate() {
    }

    public Noactivate(Integer userId,String cardNum, String name, String identityCard, String iphoneNum, String status) {
        this.userId = userId;
        this.cardNum = cardNum;
        this.name = name;
        this.identityCard = identityCard;
        this.iphoneNum = iphoneNum;
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getIphoneNum() {
        return iphoneNum;
    }

    public void setIphoneNum(String iphoneNum) {
        this.iphoneNum = iphoneNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
