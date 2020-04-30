package com.szit.eurekarepaymentmanage.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * 信用卡状态实体类
 */
public class CardStatus implements Serializable {
    private Integer id;//--主键（可选值1、2、3、4、5、6）
    private String status;//--卡状态（1为未开卡，2为已开卡，3为异常，4为冻结，5为挂失，6为销户）

    public CardStatus() {
    }

    public CardStatus(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardStatus that = (CardStatus) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status);
    }

    @Override
    public String toString() {
        return "CardStatus{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
