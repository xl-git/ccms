package com.szit.eurekauser.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 逾期实体类
 */
public class Overdue implements Serializable {
    private Integer id;//--主键
    private Double overdueAmount;//--逾期金额
    private Date overdueDate;//--逾期产生时间
    private Double overdueRate;//--逾期日利率0.05%
    private Integer count;//--逾期次数
    private Integer cardId ;//--信用卡外键id

    private CreditCard creditCard;//信用卡实体类对象

    public Overdue() {
    }

    public Overdue(Integer id, Double overdueAmount, Date overdueDate, Double overdueRate, Integer count, Integer cardId, CreditCard creditCard) {
        this.id = id;
        this.overdueAmount = overdueAmount;
        this.overdueDate = overdueDate;
        this.overdueRate = overdueRate;
        this.count = count;
        this.cardId = cardId;
        this.creditCard = creditCard;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getOverdueAmount() {
        return overdueAmount;
    }

    public void setOverdueAmount(Double overdueAmount) {
        this.overdueAmount = overdueAmount;
    }

    public Date getOverdueDate() {
        return overdueDate;
    }

    public void setOverdueDate(Date overdueDate) {
        this.overdueDate = overdueDate;
    }

    public Double getOverdueRate() {
        return overdueRate;
    }

    public void setOverdueRate(Double overdueRate) {
        this.overdueRate = overdueRate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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
        Overdue overdue = (Overdue) o;
        return Objects.equals(id, overdue.id) &&
                Objects.equals(overdueAmount, overdue.overdueAmount) &&
                Objects.equals(overdueDate, overdue.overdueDate) &&
                Objects.equals(overdueRate, overdue.overdueRate) &&
                Objects.equals(count, overdue.count) &&
                Objects.equals(cardId, overdue.cardId) &&
                Objects.equals(creditCard, overdue.creditCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, overdueAmount, overdueDate, overdueRate, count, cardId, creditCard);
    }

    @Override
    public String toString() {
        return "Overdue{" +
                "id=" + id +
                ", overdueAmount=" + overdueAmount +
                ", overdueDate=" + overdueDate +
                ", overdueRate=" + overdueRate +
                ", count=" + count +
                ", cardId=" + cardId +
                ", creditCard=" + creditCard +
                '}';
    }
}
