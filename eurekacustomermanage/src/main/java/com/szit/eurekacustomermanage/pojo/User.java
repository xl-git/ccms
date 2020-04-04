package com.szit.eurekacustomermanage.pojo;

import java.io.Serializable;

/**
 * 信用卡信息实体类
 *  @author  苏泽平
 *  @version 1.0 2020.03.31
 */
public class User implements Serializable {
    private Integer uid;//用户编号

    private String telphone;//手机号

    private String userName;//用户名

    private String uPassword;//登录密码

    public User() {
    }

    public User(Integer uid, String telphone, String userName, String uPassword) {
        this.uid = uid;
        this.telphone = telphone;
        this.userName = userName;
        this.uPassword = uPassword;
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
}