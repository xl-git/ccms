package com.szit.eurekamanager.pojo;

import javax.smartcardio.Card;
import java.io.Serializable;
import java.time.Period;
import java.util.Date;

/**
 * 分期信息实体类
 * @author 刘鑫垚
 * @version 1.0 2020-03-31
 */
public class ChangePeriods implements Serializable {
    private Integer cpid;//主键
    private Integer cid;//外键信用卡编号
    private Integer pid;//外键分期期数编号
    private Integer cpMoney;//申请分期金额
    private Date cpDate;//申请分期时间
    private String cpStatus;//状态

    private Card card;//信用卡实体类
    private Periods periods;//期数实体类

    public ChangePeriods() {
        periods=new Periods();
    }

    public ChangePeriods(Integer cpid, Integer cid, Integer pid, Integer cpMoney, Date cpDate, String cpStatus, Card card, Periods periods) {
        this.cpid = cpid;
        this.cid = cid;
        this.pid = pid;
        this.cpMoney = cpMoney;
        this.cpDate = cpDate;
        this.cpStatus = cpStatus;
        this.card = card;
        this.periods = periods;
    }

    public Integer getCpid() {
        return cpid;
    }

    public void setCpid(Integer cpid) {
        this.cpid = cpid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getCpMoney() {
        return cpMoney;
    }

    public void setCpMoney(Integer cpMoney) {
        this.cpMoney = cpMoney;
    }

    public Date getCpDate() {
        return cpDate;
    }

    public void setCpDate(Date cpDate) {
        this.cpDate = cpDate;
    }

    public String getCpStatus() {
        return cpStatus;
    }

    public void setCpStatus(String cpStatus) {
        this.cpStatus = cpStatus;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Periods getPeriods() {
        return periods;
    }

    public void setPeriods(Periods periods) {
        this.periods = periods;
    }
}
