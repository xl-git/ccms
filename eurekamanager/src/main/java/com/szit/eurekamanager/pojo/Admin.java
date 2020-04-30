package com.szit.eurekamanager.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * 管理员实体类
 */
public class Admin implements Serializable {
    private Integer id;//--主键
    private String adminName;//--管理员用户名
    private String adminPwd;//--密码
    private Integer grade;//--管理员等级;（可选值1、2、3）

    public Admin() {
    }

    public Admin(Integer id, String adminName, String adminPwd, Integer grade) {
        this.id = id;
        this.adminName = adminName;
        this.adminPwd = adminPwd;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(id, admin.id) &&
                Objects.equals(adminName, admin.adminName) &&
                Objects.equals(adminPwd, admin.adminPwd) &&
                Objects.equals(grade, admin.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, adminName, adminPwd, grade);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", adminName='" + adminName + '\'' +
                ", adminPwd='" + adminPwd + '\'' +
                ", grade=" + grade +
                '}';
    }
}
