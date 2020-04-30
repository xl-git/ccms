package com.szit.eurekastaging.service.impl;

import com.szit.eurekastaging.mapper.TransactionMapper;
import com.szit.eurekastaging.service.TransactionService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public double getTransMoneyByCardId(Integer cardId) {

        Calendar nowDate=Calendar.getInstance();
        //获取当前 '日'
        int day=nowDate.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);
        System.out.println(transactionMapper.getCountByDate(cardId,new DateTime().minusMonths(1).plusDays(25-day).toDate(),new Date()));
        System.out.println(transactionMapper.getTransMoneyByCardId(cardId,new DateTime().minusMonths(1).plusDays(25-day).toDate(),new Date()));
        double money=0;
        if(day>25){
            if(transactionMapper.getCountByDate(cardId,new Date(new Date().getTime()-(day-25)* 24 * 60 * 60 * 1000),new Date())==0){
                money=transactionMapper.getTransMoneyByCardId(cardId,new Date(new Date().getTime()-(day-25)* 24 * 60 * 60 * 1000),new Date());
            }
        }else if(day<24){
            if(transactionMapper.getCountByDate(cardId,new DateTime().minusMonths(1).plusDays(25-day).toDate(),new Date())==0){
                money=transactionMapper.getTransMoneyByCardId(cardId,new DateTime().minusMonths(1).plusDays(25-day).toDate(),new Date());
            }
        }
        return money;
    }
}
