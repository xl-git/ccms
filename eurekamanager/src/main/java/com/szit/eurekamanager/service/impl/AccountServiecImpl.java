package com.szit.eurekamanager.service.impl;

import com.szit.eurekamanager.mapper.AccountMapper;
import com.szit.eurekamanager.pojo.*;
import com.szit.eurekamanager.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("accountService")
public class AccountServiecImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<CreditCard> listByPage(String cardNum, PageIndexer page) {
        List<CreditCard> lists = accountMapper.getAccountsByPage(cardNum, (page.getPageIndex() - 1) * page.getPageSize(), page.getPageSize());

        // 计算总页数
        int count = accountMapper.getCountsByPage(cardNum);
        page.setPageCount((int)Math.ceil(count*1.0/page.getPageSize()));
        page.setCount(count);

        return lists;
    }

    @Override
    public CreditCard getAccountDetails(String cardNum) {
        return accountMapper.getAccountDetails(cardNum);
    }

    @Override
    public List<CreditCard> listHistoryTransactionsByPage(String cardNum, PageIndexer page) {
        List<CreditCard> lists = accountMapper.getHistoryTransactionsByPage(cardNum, (page.getPageIndex() - 1) * page.getPageSize(), page.getPageSize());

        // 计算总页数
        int count = accountMapper.getCounts(cardNum);
        page.setPageCount((int)Math.ceil(count*1.0/page.getPageSize()));
        page.setCount(count);
        return lists;
    }

    @Override
    public CreditCard searchHistoryDetails(String transDate,String cardNum) {
        return accountMapper.getHistoryDetails(transDate,cardNum);
    }
}
