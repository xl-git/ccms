package com.szit.eurekastaging.service;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface TransactionService {
    /**
     * 本期消费金额
     * @param cardId
     * @return
     */
    double getTransMoneyByCardId(Integer cardId);
}
