package com.szit.eurekacustomermanage.pojo;

import java.io.Serializable;

/**
 * 权限登记实体类
 * @author 刘成发
 * @version 1.0 2020-03-31
 */
public class Power implements Serializable {
    private int pid;//编号
    private String pGrade;//权限等级
    private String pExlain;//权限说明

    public Power() {
    }

    public Power(int pid, String pGrade, String pExlain) {
        this.pid = pid;
        this.pGrade = pGrade;
        this.pExlain = pExlain;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getpGrade() {
        return pGrade;
    }

    public void setpGrade(String pGrade) {
        this.pGrade = pGrade;
    }

    public String getpExlain() {
        return pExlain;
    }

    public void setpExlain(String pExlain) {
        this.pExlain = pExlain;
    }
}
