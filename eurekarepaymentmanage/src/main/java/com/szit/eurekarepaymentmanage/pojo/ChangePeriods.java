package com.szit.eurekarepaymentmanage.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 分期信息实体类
 */
public class ChangePeriods implements Serializable {
    private Integer id;//--主键
    private Integer periodsId;//--期数(3期、6期、12期)
    private Double rate;//--利率(3期1.95%、6期3.6%、12期7.2%)
    private Double amount;//--分期金额
    private Date changeDate;//	--申请时间
    private Integer changeStatus;//--分期状态（1为未还、2为已还）
    private Integer cardId;//--信用卡外键id

    private CreditCard creditCard;//信用卡实体类对象

    public ChangePeriods() {
    }

    public ChangePeriods(Integer id, Integer periodsId, Double rate, Double amount, Date changeDate, Integer changeStatus, Integer cardId, CreditCard creditCard) {
        this.id = id;
        this.periodsId = periodsId;
        this.rate = rate;
        this.amount = amount;
        this.changeDate = changeDate;
        this.changeStatus = changeStatus;
        this.cardId = cardId;
        this.creditCard = creditCard;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPeriodsId() {
        return periodsId;
    }

    public void setPeriodsId(Integer periodsId) {
        this.periodsId = periodsId;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public Integer getChangeStatus() {
        return changeStatus;
    }

    public void setChangeStatus(Integer changeStatus) {
        this.changeStatus = changeStatus;
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
        ChangePeriods that = (ChangePeriods) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(periodsId, that.periodsId) &&
                Objects.equals(rate, that.rate) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(changeDate, that.changeDate) &&
                Objects.equals(changeStatus, that.changeStatus) &&
                Objects.equals(cardId, that.cardId) &&
                Objects.equals(creditCard, that.creditCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, periodsId, rate, amount, changeDate, changeStatus, cardId, creditCard);
    }

    @Override
    public String toString() {
        return "ChangePeriods{" +
                "id=" + id +
                ", periodsId=" + periodsId +
                ", rate=" + rate +
                ", amount=" + amount +
                ", changeDate=" + changeDate +
                ", changeStatus=" + changeStatus +
                ", cardId=" + cardId +
                ", creditCard=" + creditCard +
                '}';
    }
}
