package com.szit.eurekacustomermanage.pojo;

import javax.smartcardio.Card;
import java.io.Serializable;
import java.util.Date;

/**
 *交易信息表实体类
 * @author 艾邓枫
 * @version 1.0 2020.03.31
 */
public class Transaction implements Serializable {
    private Integer tid; //编号
    private Integer tcid; //卡id
    private Double tMoney; //交易金额
    private Date tDate; //交易时间
    private String tStaus; //交易类型
    private String tAddress; //交易地点
    private String digest;  //交易摘要
    private Date billDate; //出账日期

    private Card card; //信用卡实体类

    public Transaction() {
    }

    public Transaction(Integer tid, Integer tcid, Double tMoney, Date tDate, String tStaus, String tAddress, String digest, Date billDate, Card card) {
        this.tid = tid;
        this.tcid = tcid;
        this.tMoney = tMoney;
        this.tDate = tDate;
        this.tStaus = tStaus;
        this.tAddress = tAddress;
        this.digest = digest;
        this.billDate = billDate;
        this.card = card;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getTcid() {
        return tcid;
    }

    public void setTcid(Integer tcid) {
        this.tcid = tcid;
    }

    public Double gettMoney() {
        return tMoney;
    }

    public void settMoney(Double tMoney) {
        this.tMoney = tMoney;
    }

    public Date gettDate() {
        return tDate;
    }

    public void settDate(Date tDate) {
        this.tDate = tDate;
    }

    public String gettStaus() {
        return tStaus;
    }

    public void settStaus(String tStaus) {
        this.tStaus = tStaus;
    }

    public String gettAddress() {
        return tAddress;
    }

    public void settAddress(String tAddress) {
        this.tAddress = tAddress;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
