package com.szit.eurekauser.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * 借记卡实体类
 */
public class DebitCard implements Serializable {
    private Integer id;//--主键
    private String debitCardId;//--借记卡账号
    private Integer  payPassword;//--交易密码
    private Double balance;//--账户余额
    private Integer userId;//--用户外键id

    private User user;//用户实体类对象

    public DebitCard() {
    }

    public DebitCard(Integer id, String debitCardId, Integer payPassword, Double balance, Integer userId, User user) {
        this.id = id;
        this.debitCardId = debitCardId;
        this.payPassword = payPassword;
        this.balance = balance;
        this.userId = userId;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDebitCardId() {
        return debitCardId;
    }

    public void setDebitCardId(String debitCardId) {
        this.debitCardId = debitCardId;
    }

    public Integer getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(Integer payPassword) {
        this.payPassword = payPassword;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DebitCard debitCard = (DebitCard) o;
        return Objects.equals(id, debitCard.id) &&
                Objects.equals(debitCardId, debitCard.debitCardId) &&
                Objects.equals(payPassword, debitCard.payPassword) &&
                Objects.equals(balance, debitCard.balance) &&
                Objects.equals(userId, debitCard.userId) &&
                Objects.equals(user, debitCard.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, debitCardId, payPassword, balance, userId, user);
    }

    @Override
    public String toString() {
        return "DebitCard{" +
                "id=" + id +
                ", debitCardId='" + debitCardId + '\'' +
                ", payPassword=" + payPassword +
                ", balance=" + balance +
                ", userId=" + userId +
                ", user=" + user +
                '}';
    }
}
