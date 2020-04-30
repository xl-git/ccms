package com.szit.eurekacardmanage.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * 基本信息实体类
 */
public class BaseInfo implements Serializable {
    private Integer id ;//--主键
    private String name  ;//--姓名
    private String identityCard ;//--身份证号
    private String iphoneNum ;//--预留手机号码
    private String answer ;//--预留答案
    private String homeAddress ;//--现住宅地址
    private String familyAddress;//--家庭地址
    private String nation ;//--民族
    private String marriage ;//--婚姻状况 （1为未婚，2为已婚，3为离异，4为丧偶）
    private String education ; //--受教育程度（1为小学 2为初中，3为高中，4为大专，5为本科，6为研究生及以上）
    private String baseMail ; //--邮政编码
    private Integer questionId ; //--安全问题外键id
    private Integer userId ;  //--用户外键id

    private Question question;//安全问题实体类对象
    private User user;//用户实体类对象

    public BaseInfo() {
    }

    public BaseInfo(Integer id, String name, String identityCard, String iphoneNum, String answer, String homeAddress, String familyAddress, String nation, String marriage, String education, String baseMail, Integer questionId, Integer userId, Question question, User user) {
        this.id = id;
        this.name = name;
        this.identityCard = identityCard;
        this.iphoneNum = iphoneNum;
        this.answer = answer;
        this.homeAddress = homeAddress;
        this.familyAddress = familyAddress;
        this.nation = nation;
        this.marriage = marriage;
        this.education = education;
        this.baseMail = baseMail;
        this.questionId = questionId;
        this.userId = userId;
        this.question = question;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getIphoneNum() {
        return iphoneNum;
    }

    public void setIphoneNum(String iphoneNum) {
        this.iphoneNum = iphoneNum;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getFamilyAddress() {
        return familyAddress;
    }

    public void setFamilyAddress(String familyAddress) {
        this.familyAddress = familyAddress;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getBaseMail() {
        return baseMail;
    }

    public void setBaseMail(String baseMail) {
        this.baseMail = baseMail;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
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
        BaseInfo baseInfo = (BaseInfo) o;
        return Objects.equals(id, baseInfo.id) &&
                Objects.equals(name, baseInfo.name) &&
                Objects.equals(identityCard, baseInfo.identityCard) &&
                Objects.equals(iphoneNum, baseInfo.iphoneNum) &&
                Objects.equals(answer, baseInfo.answer) &&
                Objects.equals(homeAddress, baseInfo.homeAddress) &&
                Objects.equals(familyAddress, baseInfo.familyAddress) &&
                Objects.equals(nation, baseInfo.nation) &&
                Objects.equals(marriage, baseInfo.marriage) &&
                Objects.equals(education, baseInfo.education) &&
                Objects.equals(baseMail, baseInfo.baseMail) &&
                Objects.equals(questionId, baseInfo.questionId) &&
                Objects.equals(userId, baseInfo.userId) &&
                Objects.equals(question, baseInfo.question) &&
                Objects.equals(user, baseInfo.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, identityCard, iphoneNum, answer, homeAddress, familyAddress, nation, marriage, education, baseMail, questionId, userId, question, user);
    }

    @Override
    public String toString() {
        return "BaseInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", identityCard='" + identityCard + '\'' +
                ", iphoneNum=" + iphoneNum +
                ", answer='" + answer + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", familyAddress='" + familyAddress + '\'' +
                ", nation='" + nation + '\'' +
                ", marriage='" + marriage + '\'' +
                ", education='" + education + '\'' +
                ", baseMail='" + baseMail + '\'' +
                ", questionId=" + questionId +
                ", userId=" + userId +
                ", question=" + question +
                ", user=" + user +
                '}';
    }
}
