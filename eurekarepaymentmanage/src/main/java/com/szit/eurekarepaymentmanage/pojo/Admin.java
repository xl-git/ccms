package com.szit.eurekarepaymentmanage.pojo;

import java.io.Serializable;

/**
 * 工作人员实体类
 * @author 刘成发
 * @version 1.0 2020-03-31
 */
public class Admin implements Serializable {
    private Integer aid;//编号；
    private String anum;//账号
    private String aPassword;//密码；
    private Integer pid;//权限编号
    private Power power;//权限外键

    public Admin() {
        power=new Power();
    }

    public Admin(Integer aid, String anum, String aPassword, Integer pid, Power power) {
        this.aid = aid;
        this.anum = anum;
        this.aPassword = aPassword;
        this.pid = pid;
        this.power = power;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAnum() {
        return anum;
    }

    public void setAnum(String anum) {
        this.anum = anum;
    }

    public String getaPassword() {
        return aPassword;
    }

    public void setaPassword(String aPassword) {
        this.aPassword = aPassword;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Power getPower() {
        return power;
    }

    public void setPower(Power power) {
        this.power = power;
    }
}
