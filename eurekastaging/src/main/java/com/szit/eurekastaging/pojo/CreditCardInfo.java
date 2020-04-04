package com.szit.eurekastaging.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 信用卡基本信息实体类
 *
 * @author 肖林
 * @version 1.0 2020-03-31
 */
public class CreditCardInfo implements Serializable {
    private Integer ccid;//信用卡基本信息编号
    private String cardHolderName;//办卡人姓名
    private String certificateType;//证件类型
    private String certificateNum;//证件号
    private String phone;//手机号
    private String nation;//民族
    private String maritalStatus;//婚姻状况
    private Date certificateDate;//证件有效期
    private String educationLevel;//受教育程度
    private String nowAddress;//现住宅地址
    private String homeCondition;//住宅状况
    private String postalCode;//邮政编码

    public CreditCardInfo() {

    }

    public CreditCardInfo(Integer ccid, String cardHolderName, String certificateType, String certificateNum, String phone, String nation, String maritalStatus, Date certificateDate, String educationLevel, String nowAddress, String homeCondition, String postalCode) {
        this.ccid = ccid;
        this.cardHolderName = cardHolderName;
        this.certificateType = certificateType;
        this.certificateNum = certificateNum;
        this.phone = phone;
        this.nation = nation;
        this.maritalStatus = maritalStatus;
        this.certificateDate = certificateDate;
        this.educationLevel = educationLevel;
        this.nowAddress = nowAddress;
        this.homeCondition = homeCondition;
        this.postalCode = postalCode;
    }

    public Integer getCcid() {
        return ccid;
    }

    public void setCcid(Integer ccid) {
        this.ccid = ccid;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public String getCertificateNum() {
        return certificateNum;
    }

    public void setCertificateNum(String certificateNum) {
        this.certificateNum = certificateNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Date getCertificateDate() {
        return certificateDate;
    }

    public void setCertificateDate(Date certificateDate) {
        this.certificateDate = certificateDate;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getNowAddress() {
        return nowAddress;
    }

    public void setNowAddress(String nowAddress) {
        this.nowAddress = nowAddress;
    }

    public String getHomeCondition() {
        return homeCondition;
    }

    public void setHomeCondition(String homeCondition) {
        this.homeCondition = homeCondition;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
