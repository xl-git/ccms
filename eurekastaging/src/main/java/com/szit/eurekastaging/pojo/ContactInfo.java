package com.szit.eurekastaging.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * 联系人信息实体类
 */
public class ContactInfo implements Serializable {
    Integer id;//--主键
    String contactName;//--联系人姓名
    String contactIphone;//--联系人电话
    String email;//--E-mail账单地址
    String relation;//--与申请人关系（1为父子，2为母子，3为夫妻，4为亲戚，5为朋友，6为同事)
    Integer userId;//--用户外键id

    private User user;//用户实体类对象

    public ContactInfo() {
    }

    public ContactInfo(Integer id, String contactName, String contactIphone, String email, String relation, Integer userId, User user) {
        this.id = id;
        this.contactName = contactName;
        this.contactIphone = contactIphone;
        this.email = email;
        this.relation = relation;
        this.userId = userId;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactIphone() {
        return contactIphone;
    }

    public void setContactIphone(String contactIphone) {
        this.contactIphone = contactIphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
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
        ContactInfo that = (ContactInfo) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(contactName, that.contactName) &&
                Objects.equals(contactIphone, that.contactIphone) &&
                Objects.equals(email, that.email) &&
                Objects.equals(relation, that.relation) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contactName, contactIphone, email, relation, userId, user);
    }

    @Override
    public String toString() {
        return "ContactInfo{" +
                "id=" + id +
                ", contactName='" + contactName + '\'' +
                ", contactIphone=" + contactIphone +
                ", email='" + email + '\'' +
                ", relation='" + relation + '\'' +
                ", userId=" + userId +
                ", user=" + user +
                '}';
    }
}

