package com.szit.eurekacardmanage.pojo;

import java.io.Serializable;

/**
 * 信用卡实体类
 */
public class CreditCard implements Serializable {
    private Integer id ;//主键
    private String cardNum;//信用卡号
    private Integer cardType;//卡类型（1为普卡 2位金卡 3位白金卡）
    private Double creditLimit;//信用额度
    private Double useableLimit;//可用额度
    private Double alreadyLimit;//已消费额度
    private Double overdueAmount;//逾期金额
    private Double changeLimit;//剩余未还分期金额
    private Integer outDate;//出账日
    private Integer inDate;//还款日
    private Integer payPassword;//支付密码
    private String currency;//币种
    private String openDate;//开卡时间
    private Integer userId;//用户外键id
    private Integer cardStatusId;//信用卡状态外键

    private User user;//用户实体对象
    private CardStatus cardStatus;//信用卡状态实体类对象

    private BaseInfo baseInfo;

    public CreditCard() {
    }

    public CreditCard(Integer id, String cardNum, Integer cardType, Double creditLimit, Double useableLimit, Double alreadyLimit, Double overdueAmount, Double changeLimit, Integer outDate, Integer inDate, Integer payPassword, String currency, String openDate, Integer userId, Integer cardStatusId, User user, CardStatus cardStatus, BaseInfo baseInfo) {
        this.id = id;
        this.cardNum = cardNum;
        this.cardType = cardType;
        this.creditLimit = creditLimit;
        this.useableLimit = useableLimit;
        this.alreadyLimit = alreadyLimit;
        this.overdueAmount = overdueAmount;
        this.changeLimit = changeLimit;
        this.outDate = outDate;
        this.inDate = inDate;
        this.payPassword = payPassword;
        this.currency = currency;
        this.openDate = openDate;
        this.userId = userId;
        this.cardStatusId = cardStatusId;
        this.user = user;
        this.cardStatus = cardStatus;
        this.baseInfo = baseInfo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Double getUseableLimit() {
        return useableLimit;
    }

    public void setUseableLimit(Double useableLimit) {
        this.useableLimit = useableLimit;
    }

    public Double getAlreadyLimit() {
        return alreadyLimit;
    }

    public void setAlreadyLimit(Double alreadyLimit) {
        this.alreadyLimit = alreadyLimit;
    }

    public Double getOverdueAmount() {
        return overdueAmount;
    }

    public void setOverdueAmount(Double overdueAmount) {
        this.overdueAmount = overdueAmount;
    }

    public Double getChangeLimit() {
        return changeLimit;
    }

    public void setChangeLimit(Double changeLimit) {
        this.changeLimit = changeLimit;
    }

    public Integer getOutDate() {
        return outDate;
    }

    public void setOutDate(Integer outDate) {
        this.outDate = outDate;
    }

    public Integer getInDate() {
        return inDate;
    }

    public void setInDate(Integer inDate) {
        this.inDate = inDate;
    }

    public Integer getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(Integer payPassword) {
        this.payPassword = payPassword;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCardStatusId() {
        return cardStatusId;
    }

    public void setCardStatusId(Integer cardStatusId) {
        this.cardStatusId = cardStatusId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", cardNum='" + cardNum + '\'' +
                ", cardType=" + cardType +
                ", creditLimit=" + creditLimit +
                ", useableLimit=" + useableLimit +
                ", alreadyLimit=" + alreadyLimit +
                ", overdueAmount=" + overdueAmount +
                ", changeLimit=" + changeLimit +
                ", outDate=" + outDate +
                ", inDate=" + inDate +
                ", payPassword=" + payPassword +
                ", currency='" + currency + '\'' +
                ", openDate='" + openDate + '\'' +
                ", userId=" + userId +
                ", cardStatusId=" + cardStatusId +
                ", user=" + user +
                ", cardStatus=" + cardStatus +
                ", baseInfo=" + baseInfo +
                '}';
    }
}

