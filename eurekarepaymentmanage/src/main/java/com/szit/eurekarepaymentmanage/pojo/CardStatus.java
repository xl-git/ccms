package com.szit.eurekarepaymentmanage.pojo;

import java.io.Serializable;

/**
 * 信用卡状态实体类
 *
 * @author 肖林
 * @version 1.0 2020-03-31
 */
public class CardStatus implements Serializable {
    private Integer csid;//信用卡状态编号
    private String cardStatusType;//信用卡状态类型

    public CardStatus() {

    }

    public CardStatus(Integer csid, String cardStatusType) {
        this.csid = csid;
        this.cardStatusType = cardStatusType;
    }

    public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }

    public String getCardStatusType() {
        return cardStatusType;
    }

    public void setCardStatusType(String cardStatusType) {
        this.cardStatusType = cardStatusType;
    }
}
