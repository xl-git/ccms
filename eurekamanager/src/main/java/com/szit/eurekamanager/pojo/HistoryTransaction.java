package com.szit.eurekamanager.pojo;

import java.io.Serializable;
import java.util.Date;

public class HistoryTransaction implements Serializable {
    private String cardNum;
    private String name;
    private String identityCard;
    private String abstracts;
    private Date transDate;
    private double transMoney;

    public HistoryTransaction() {
    }

    public HistoryTransaction(String cardNum, String name, String identityCard, String abstracts, Date transDate, double transMoney) {
        this.cardNum = cardNum;
        this.name = name;
        this.identityCard = identityCard;
        this.abstracts = abstracts;
        this.transDate = transDate;
        this.transMoney = transMoney;
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

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public double getTransMoney() {
        return transMoney;
    }

    public void setTransMoney(double transMoney) {
        this.transMoney = transMoney;
    }
}
