package com.szit.eurekacustomermanage.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 交易信息实体类
 */
public class Transaction implements Serializable {
    private Integer id;//--主键
    private Double transMoney;//--交易金额
    private Date transDate;//--交易时间
    private String transAddress;//--交易地点
    private String abstracts;//--交易摘要（交易类型）
    private Integer cardId;//--信用卡外键id

    private CreditCard creditCard;//信用卡实体类对象

    public Transaction() {
    }

    public Transaction(Integer id, Double transMoney, Date transDate, String transAddress, String abstracts, Integer cardId, CreditCard creditCard) {
        this.id = id;
        this.transMoney = transMoney;
        this.transDate = transDate;
        this.transAddress = transAddress;
        this.abstracts = abstracts;
        this.cardId = cardId;
        this.creditCard = creditCard;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTransMoney() {
        return transMoney;
    }

    public void setTransMoney(Double transMoney) {
        this.transMoney = transMoney;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public String getTransAddress() {
        return transAddress;
    }

    public void setTransAddress(String transAddress) {
        this.transAddress = transAddress;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(transMoney, that.transMoney) &&
                Objects.equals(transDate, that.transDate) &&
                Objects.equals(transAddress, that.transAddress) &&
                Objects.equals(abstracts, that.abstracts) &&
                Objects.equals(cardId, that.cardId) &&
                Objects.equals(creditCard, that.creditCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transMoney, transDate, transAddress, abstracts, cardId, creditCard);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", transMoney=" + transMoney +
                ", transDate=" + transDate +
                ", transAddress='" + transAddress + '\'' +
                ", abstracts='" + abstracts + '\'' +
                ", cardId=" + cardId +
                ", creditCard=" + creditCard +
                '}';
    }
}
