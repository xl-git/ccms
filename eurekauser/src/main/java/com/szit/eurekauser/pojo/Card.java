package com.szit.eurekauser.pojo;

import java.io.Serializable;

/**
 * 信用卡信息实体类
 *  @author  苏泽平
 *  @version 1.0 2020.03.31
 */
public class Card implements Serializable {
    private Integer cid;// 编号

    private String cNum;//卡号

    private String cType;//类型

    private Integer uid;//用户编号

    private Integer ccid; //基本信息编号

    private Integer unid;//单位信息编号

    private Integer lid;// 联系人编号

    private String email;//E-mail账单地址

    private String payAccount; //自动还款账号

    private String collection; //卡片领取方式

    private String knowBook;//知情书

    private Double lineCredit; //信用额度

    private Double availableCredit; //可用额度

    private String currency; //币种

    private Double cardCash; //预借现金可用额度

    private String openStatus;//开卡状态

    private String tradPassword;//交易密码

    private Integer csid;//信用卡状态
    private User user;//用户对象
    private CreditCardInfo creditCardInfo; //基本信息对象
    private Unit unit;//单位信息对象
    private LinkMan linkMan; //联系人对象
    private CardStatus cardStatus;//信用卡状态对象

    public Card() {
    }

    public Card(Integer cid, String cNum, String cType, Integer uid, Integer ccid, Integer unid, Integer lid, String email, String payAccount, String collection, String knowBook, Double lineCredit, Double availableCredit, String currency, Double cardCash, String openStatus, String tradPassword, Integer csid, User user, CreditCardInfo creditCardInfo, Unit unit, LinkMan linkMan, CardStatus cardStatus) {
        this.cid = cid;
        this.cNum = cNum;
        this.cType = cType;
        this.uid = uid;
        this.ccid = ccid;
        this.unid = unid;
        this.lid = lid;
        this.email = email;
        this.payAccount = payAccount;
        this.collection = collection;
        this.knowBook = knowBook;
        this.lineCredit = lineCredit;
        this.availableCredit = availableCredit;
        this.currency = currency;
        this.cardCash = cardCash;
        this.openStatus = openStatus;
        this.tradPassword = tradPassword;
        this.csid = csid;
        this.user = user;
        this.creditCardInfo = creditCardInfo;
        this.unit = unit;
        this.linkMan = linkMan;
        this.cardStatus = cardStatus;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getcNum() {
        return cNum;
    }

    public void setcNum(String cNum) {
        this.cNum = cNum;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCcid() {
        return ccid;
    }

    public void setCcid(Integer ccid) {
        this.ccid = ccid;
    }

    public Integer getUnid() {
        return unid;
    }

    public void setUnid(Integer unid) {
        this.unid = unid;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getKnowBook() {
        return knowBook;
    }

    public void setKnowBook(String knowBook) {
        this.knowBook = knowBook;
    }

    public Double getLineCredit() {
        return lineCredit;
    }

    public void setLineCredit(Double lineCredit) {
        this.lineCredit = lineCredit;
    }

    public Double getAvailableCredit() {
        return availableCredit;
    }

    public void setAvailableCredit(Double availableCredit) {
        this.availableCredit = availableCredit;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getCardCash() {
        return cardCash;
    }

    public void setCardCash(Double cardCash) {
        this.cardCash = cardCash;
    }

    public String getOpenStatus() {
        return openStatus;
    }

    public void setOpenStatus(String openStatus) {
        this.openStatus = openStatus;
    }

    public String getTradPassword() {
        return tradPassword;
    }

    public void setTradPassword(String tradPassword) {
        this.tradPassword = tradPassword;
    }

    public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CreditCardInfo getCreditCardInfo() {
        return creditCardInfo;
    }

    public void setCreditCardInfo(CreditCardInfo creditCardInfo) {
        this.creditCardInfo = creditCardInfo;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public LinkMan getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(LinkMan linkMan) {
        this.linkMan = linkMan;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }
}