package com.szit.eurekastaging.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 还款记录信息实体类
 * @author 刘成发
 * @version 1.0 2020-03-31
 */
public class Repament implements Serializable {
    private int rid;//编号
    private int cid;//卡id（外键）
    private double rMoney;//还款金额；
    private Date dueDate ; //还款日期
    private String rAccount;//还款账户

    public Repament() {
    }

    public Repament(int rid, int cid, double rMoney, Date dueDate, String rAccount) {
        this.rid = rid;
        this.cid = cid;
        this.rMoney = rMoney;
        this.dueDate = dueDate;
        this.rAccount = rAccount;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public double getrMoney() {
        return rMoney;
    }

    public void setrMoney(double rMoney) {
        this.rMoney = rMoney;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getrAccount() {
        return rAccount;
    }

    public void setrAccount(String rAccount) {
        this.rAccount = rAccount;
    }
}
