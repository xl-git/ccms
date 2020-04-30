package com.szit.eurekastaging.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface TransactionMapper {

    /**
     * 本期消费金额
     * @param cardId
     * @param fromDate
     * @param nowDate
     * @return
     */
    double getTransMoneyByCardId(@Param("cardId") Integer cardId, @Param("fromDate")Date fromDate,
                                 @Param("nowDate") Date nowDate);

    int getCountByDate(@Param("cardId") Integer cardId, @Param("fromDate")Date fromDate,
                       @Param("nowDate") Date nowDate);
}
