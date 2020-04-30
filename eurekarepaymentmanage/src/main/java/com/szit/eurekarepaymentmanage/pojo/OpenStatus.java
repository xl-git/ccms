package com.szit.eurekarepaymentmanage.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * 申请卡状态实体类
 */
public class OpenStatus implements Serializable {
    private Integer id;//--主键（可选值1、2、3）
    private Integer userId;//--用户外键id
    private String status ;//--申请卡状态（1为待审核，2为成功，3为失败）

    private User user;//用户实体类对象

    public OpenStatus() {
    }

    public OpenStatus(Integer id, Integer userId, String status, User user) {
        this.id = id;
        this.userId = userId;
        this.status = status;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        OpenStatus that = (OpenStatus) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(status, that.status) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, status, user);
    }

    @Override
    public String toString() {
        return "OpenStatus{" +
                "id=" + id +
                ", userId=" + userId +
                ", status='" + status + '\'' +
                ", user=" + user +
                '}';
    }
}
