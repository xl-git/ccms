package com.szit.eurekauser.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 信用卡信息实体类
 *  @author  苏泽平
 *  @version 1.0 2020.03.31
 */
public class User implements Serializable {
//    private static final long serialVersionUID = 386304230562814645L;
    private Integer uid;//用户编号

    private String telphone;//手机号

    private String userName;//用户名

    private String uPassword;//登录密码

    private String loginDate;//最后登录时间

    public User() {

    }

    public User(Integer uid, String telphone, String userName, String uPassword,String loginDate) {
        this.uid = uid;
        this.telphone = telphone;
        this.userName = userName;
        this.uPassword = uPassword;
        this.loginDate = loginDate;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(String loginDate) {
        this.loginDate = loginDate;
    }
}