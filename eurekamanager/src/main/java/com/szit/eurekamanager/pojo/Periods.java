package com.szit.eurekamanager.pojo;

import java.io.Serializable;

/**
 * 期数实体类
 * @author 刘鑫垚
 * @version 1.0 2020-03-31
 */
public class Periods implements Serializable {
    private Integer pid;//主键编号
    private Integer pNum;//可分期期数
    private Double rate;//期率

    public Periods() {
    }

    public Periods(Integer pid, Integer pNum, Double rate) {
        this.pid = pid;
        this.pNum = pNum;
        this.rate = rate;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getpNum() {
        return pNum;
    }

    public void setpNum(Integer pNum) {
        this.pNum = pNum;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
