package com.szit.eurekacardmanage.pojo;

import java.io.Serializable;

/**
 * 安全问题信息表
 *  @author  刘志强
 *  @version 1.0 2020.03.31
 */
public class Safety implements Serializable {
    private Integer sid;//主键
    private String sMessage;//问题信息
    private String sAnswer;//问题答案
    private Integer sccid;//信用卡基本信息编号

    public Safety(){

    }

    public Safety(Integer sid, String sMessage, String sAnswer, Integer sccid) {
        this.sid = sid;
        this.sMessage = sMessage;
        this.sAnswer = sAnswer;
        this.sccid = sccid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getsMessage() {
        return sMessage;
    }

    public void setsMessage(String sMessage) {
        this.sMessage = sMessage;
    }

    public String getsAnswer() {
        return sAnswer;
    }

    public void setsAnswer(String sAnswer) {
        this.sAnswer = sAnswer;
    }

    public Integer getSccid() {
        return sccid;
    }

    public void setSccid(Integer sccid) {
        this.sccid = sccid;
    }
}
