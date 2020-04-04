package com.szit.eurekauser.pojo;

import java.io.Serializable;

/**
 * 联系人信息表
 * @author 艾邓枫
 * @version 1.0 2020.03.31
 */
public class LinkMan implements Serializable {
    private Integer lid; //编号
    private String lName; //联系人姓名
    private String lPhone; //联系人电话
    private String lRelation; //与主卡申请人的关系

    public LinkMan() {
    }

    public LinkMan(Integer lid, String lName, String lPhone, String lRelation) {
        this.lid = lid;
        this.lName = lName;
        this.lPhone = lPhone;
        this.lRelation = lRelation;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getlPhone() {
        return lPhone;
    }

    public void setlPhone(String lPhone) {
        this.lPhone = lPhone;
    }

    public String getlRelation() {
        return lRelation;
    }

    public void setlRelation(String lRelation) {
        this.lRelation = lRelation;
    }
}