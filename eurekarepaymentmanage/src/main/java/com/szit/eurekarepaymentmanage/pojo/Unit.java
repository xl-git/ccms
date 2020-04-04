package com.szit.eurekarepaymentmanage.pojo;

import java.io.Serializable;

/**
 * 单位信息表
 *  @author  刘志强
 *  @version 1.0 2020.03.31
 */
public class Unit implements Serializable {
    private Integer unid;//主键
    private String uName;//单位名称
    private String uNature;//单位性质
    private String uPhone;//单位电话
    private String uDvelop;//发展行业
    private String uAddress;//单位地址
    private String uDuty;//担任职务
    private String uThing;//从事行业
    private double uIncome;//年收入
    private Integer uPostal;//邮政编码

    private Unit(){

    }

    public Unit(Integer unid, String uName, String uNature, String uPhone, String uDvelop, String uAddress, String uDuty, String uThing, double uIncome, Integer uPostal) {
        this.unid = unid;
        this.uName = uName;
        this.uNature = uNature;
        this.uPhone = uPhone;
        this.uDvelop = uDvelop;
        this.uAddress = uAddress;
        this.uDuty = uDuty;
        this.uThing = uThing;
        this.uIncome = uIncome;
        this.uPostal = uPostal;
    }

    public Integer getUnid() {
        return unid;
    }

    public void setUnid(Integer unid) {
        this.unid = unid;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuNature() {
        return uNature;
    }

    public void setuNature(String uNature) {
        this.uNature = uNature;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public String getuDvelop() {
        return uDvelop;
    }

    public void setuDvelop(String uDvelop) {
        this.uDvelop = uDvelop;
    }

    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
    }

    public String getuDuty() {
        return uDuty;
    }

    public void setuDuty(String uDuty) {
        this.uDuty = uDuty;
    }

    public String getuThing() {
        return uThing;
    }

    public void setuThing(String uThing) {
        this.uThing = uThing;
    }

    public double getuIncome() {
        return uIncome;
    }

    public void setuIncome(double uIncome) {
        this.uIncome = uIncome;
    }

    public Integer getuPostal() {
        return uPostal;
    }

    public void setuPostal(Integer uPostal) {
        this.uPostal = uPostal;
    }
}
