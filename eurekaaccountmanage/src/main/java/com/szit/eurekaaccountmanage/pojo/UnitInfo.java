package com.szit.eurekaaccountmanage.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * 单位信息实体类
 */
public class UnitInfo implements Serializable {
    private Integer in;//--主键
    private String companyName;//--单位名称
    private String companyTpe;//--单位性质(1为国有企业，2为私营企业，3事业单位，4政府关机，5为个体户)
    private String unitIphone;//--单位电话
    private String unitAddress ;//--单位地址
    private Integer yearIncome;//--年收入（1为5万以下，2为5-15万，3为15-30万，4为30-50，5为50以上）
    private String duty;//--担任职务（总经理、销售经理、技术部长、生产部长、采购主管、品质主管、车间主任、财务主管、人事行政主管、其他）
    private String unitMail;//--邮政编码
    private Integer userId ;//--用户外键id

    private User user;//用户实体类对象

    public UnitInfo() {
    }

    public UnitInfo(Integer in, String companyName, String companyTpe, String unitIphone, String unitAddress, Integer yearIncome, String duty, String unitMail, Integer userId, User user) {
        this.in = in;
        this.companyName = companyName;
        this.companyTpe = companyTpe;
        this.unitIphone = unitIphone;
        this.unitAddress = unitAddress;
        this.yearIncome = yearIncome;
        this.duty = duty;
        this.unitMail = unitMail;
        this.userId = userId;
        this.user = user;
    }

    public Integer getIn() {
        return in;
    }

    public void setIn(Integer in) {
        this.in = in;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyTpe() {
        return companyTpe;
    }

    public void setCompanyTpe(String companyTpe) {
        this.companyTpe = companyTpe;
    }

    public String getUnitIphone() {
        return unitIphone;
    }

    public void setUnitIphone(String unitIphone) {
        this.unitIphone = unitIphone;
    }

    public String getUnitAddress() {
        return unitAddress;
    }

    public void setUnitAddress(String unitAddress) {
        this.unitAddress = unitAddress;
    }

    public Integer getYearIncome() {
        return yearIncome;
    }

    public void setYearIncome(Integer yearIncome) {
        this.yearIncome = yearIncome;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getUnitMail() {
        return unitMail;
    }

    public void setUnitMail(String unitMail) {
        this.unitMail = unitMail;
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
        UnitInfo unitInfo = (UnitInfo) o;
        return Objects.equals(in, unitInfo.in) &&
                Objects.equals(companyName, unitInfo.companyName) &&
                Objects.equals(companyTpe, unitInfo.companyTpe) &&
                Objects.equals(unitIphone, unitInfo.unitIphone) &&
                Objects.equals(unitAddress, unitInfo.unitAddress) &&
                Objects.equals(yearIncome, unitInfo.yearIncome) &&
                Objects.equals(duty, unitInfo.duty) &&
                Objects.equals(unitMail, unitInfo.unitMail) &&
                Objects.equals(userId, unitInfo.userId) &&
                Objects.equals(user, unitInfo.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(in, companyName, companyTpe, unitIphone, unitAddress, yearIncome, duty, unitMail, userId, user);
    }

    @Override
    public String toString() {
        return "UnitInfo{" +
                "in=" + in +
                ", companyName='" + companyName + '\'' +
                ", companyTpe='" + companyTpe + '\'' +
                ", unitIphone='" + unitIphone + '\'' +
                ", unitAddress='" + unitAddress + '\'' +
                ", yearIncome=" + yearIncome +
                ", duty='" + duty + '\'' +
                ", unitMail='" + unitMail + '\'' +
                ", userId=" + userId +
                ", user=" + user +
                '}';
    }
}
