package com.szit.eurekarepaymentmanage.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 用户实体类
 */
public class User implements Serializable {
    private Integer id ;//主键
    private String userName ;//用户名
    private String userPwd ;//登录密码
    private String telphone ;//手机号码
    private Date loginDate ; //登录时间
    private Integer score;//信用分

    public User() {
    }

    public User(Integer id, String userName, String userPwd, String telphone, Date loginDate, Integer score) {
        this.id = id;
        this.userName = userName;
        this.userPwd = userPwd;
        this.telphone = telphone;
        this.loginDate = loginDate;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(userPwd, user.userPwd) &&
                Objects.equals(telphone, user.telphone) &&
                Objects.equals(loginDate, user.loginDate) &&
                Objects.equals(score, user.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, userPwd, telphone, loginDate, score);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", telphone='" + telphone + '\'' +
                ", loginDate=" + loginDate +
                ", score=" + score +
                '}';
    }
}
