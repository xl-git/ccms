package com.szit.eurekaaccountmanage.service;

import com.szit.eurekaaccountmanage.pojo.CreditCard;

public interface CreditCardService {
    /**
     * 根据用户主键ID获取信用卡信息
     * @return 返回信用卡实体类对象
     */
    CreditCard getCreditCardByUserId(int userId);

    double getMoneyByDate(Integer cardId);
    double getAlreadyMoneyByDate(Integer cardId);
}
