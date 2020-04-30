package com.szit.eurekaaccountmanage.mapper;

import com.szit.eurekaaccountmanage.pojo.CreditCard;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;


@Mapper
public interface CreditCardMapper {

    CreditCard getCreditCardByUserId(int userId);

    double getMoneyByDate(Map<String,Object> dateMap);
}
