package com.szit.eurekacardmanage.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 还款信息实体类
 */
public class Repayment implements Serializable {
    private Integer id;//--主键
    private Double rmoney;//--还款金额
    private Date duedate;//--还款日期
    private Integer debitCardId;//--借记卡外键id
    private Integer cardId;//--信用卡外键id
    private Integer changePeriodsId;//--分期信息表外键id

    private CreditCard creditCard;//信用卡实体类对想
    private ChangePeriods changePeriods;//分期信息实体类对想
    private DebitCard debitCard;//借记卡实体类对象

    public Repayment() {
    }

    public Repayment(Integer id, Double rmoney, Date duedate, Integer debitCardId, Integer cardId, Integer changePeriodsId, CreditCard creditCard, ChangePeriods changePeriods, DebitCard debitCard) {
        this.id = id;
        this.rmoney = rmoney;
        this.duedate = duedate;
        this.debitCardId = debitCardId;
        this.cardId = cardId;
        this.changePeriodsId = changePeriodsId;
        this.creditCard = creditCard;
        this.changePeriods = changePeriods;
        this.debitCard = debitCard;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getRmoney() {
        return rmoney;
    }

    public void setRmoney(Double rmoney) {
        this.rmoney = rmoney;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public Integer getDebitCardId() {
        return debitCardId;
    }

    public void setDebitCardId(Integer debitCardId) {
        this.debitCardId = debitCardId;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getChangePeriodsId() {
        return changePeriodsId;
    }

    public void setChangePeriodsId(Integer changePeriodsId) {
        this.changePeriodsId = changePeriodsId;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public ChangePeriods getChangePeriods() {
        return changePeriods;
    }

    public void setChangePeriods(ChangePeriods changePeriods) {
        this.changePeriods = changePeriods;
    }

    public DebitCard getDebitCard() {
        return debitCard;
    }

    public void setDebitCard(DebitCard debitCard) {
        this.debitCard = debitCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repayment repayment = (Repayment) o;
        return Objects.equals(id, repayment.id) &&
                Objects.equals(rmoney, repayment.rmoney) &&
                Objects.equals(duedate, repayment.duedate) &&
                Objects.equals(debitCardId, repayment.debitCardId) &&
                Objects.equals(cardId, repayment.cardId) &&
                Objects.equals(changePeriodsId, repayment.changePeriodsId) &&
                Objects.equals(creditCard, repayment.creditCard) &&
                Objects.equals(changePeriods, repayment.changePeriods) &&
                Objects.equals(debitCard, repayment.debitCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rmoney, duedate, debitCardId, cardId, changePeriodsId, creditCard, changePeriods, debitCard);
    }

    @Override
    public String toString() {
        return "Repayment{" +
                "id=" + id +
                ", rmoney=" + rmoney +
                ", duedate=" + duedate +
                ", debitCardId=" + debitCardId +
                ", cardId=" + cardId +
                ", changePeriodsId=" + changePeriodsId +
                ", creditCard=" + creditCard +
                ", changePeriods=" + changePeriods +
                ", debitCard=" + debitCard +
                '}';
    }
}
