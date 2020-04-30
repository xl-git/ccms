package com.szit.eurekaaccountmanage.service.impl;

import com.szit.eurekaaccountmanage.mapper.CreditCardMapper;
import com.szit.eurekaaccountmanage.pojo.CreditCard;
import com.szit.eurekaaccountmanage.service.CreditCardService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    private CreditCardMapper creditCardMapper;

    @Override
    public CreditCard getCreditCardByUserId(int userId) {
        return creditCardMapper.getCreditCardByUserId(userId);
    }

    @Override
    public double getMoneyByDate(Integer cardId) {
        Calendar nowDate=Calendar.getInstance();
        int day=nowDate.get(Calendar.DAY_OF_MONTH);
        double money=0;
        Map<String,Object> dateMap = new HashMap<String,Object>();
        if(day>=3){
            dateMap.put("fromDate",new DateTime().minusDays(day).plusDays(3).toDate());
            dateMap.put("nowDate", new Date());
            dateMap.put("cardId",cardId);
            money=this.creditCardMapper.getMoneyByDate(dateMap);
        }else{
            dateMap.put("fromDate", new DateTime().minusDays(day).plusDays(3).minusMonths(1).toDate());
            dateMap.put("nowDate", new Date());
            dateMap.put("cardId",cardId);
            money=this.creditCardMapper.getMoneyByDate(dateMap);
        }
        return money;
    }

    public double getAlreadyMoneyByDate(Integer cardId) {
        Calendar nowDate=Calendar.getInstance();
        int day=nowDate.get(Calendar.DAY_OF_MONTH);
        double money=0;
        Map<String,Object> dateMap = new HashMap<String,Object>();
        if(day>=3){
            System.out.println(new DateTime().minusMonths(1).minusDays(day).plusDays(3).toDate());
            System.out.println(new DateTime().minusDays(day).plusDays(3).toDate());
            dateMap.put("fromDate",new DateTime().minusMonths(1).minusDays(day).plusDays(3).toDate());
            dateMap.put("nowDate",new DateTime().minusDays(day).plusDays(3).toDate());
            dateMap.put("cardId",cardId);
            money=this.creditCardMapper.getMoneyByDate(dateMap);
        }else{
            dateMap.put("fromDate", new DateTime().minusDays(day).plusDays(3).minusMonths(2).toDate());
            dateMap.put("nowDate",new DateTime().minusMonths(1).minusDays(day).plusDays(3).toDate());
            dateMap.put("cardId",cardId);
            money=this.creditCardMapper.getMoneyByDate(dateMap);
        }
        System.out.println(money);
        return money;
    }
}
