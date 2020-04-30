package com.szit.eurekamanager.service.impl;

import com.szit.eurekamanager.mapper.ChangePeriodsMapper;
import com.szit.eurekamanager.pojo.CreditCard;
import com.szit.eurekamanager.pojo.PageIndexer;
import com.szit.eurekamanager.service.ChangePeriodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("changePeriodsService")
public class ChangePeriodsServiceImpl implements ChangePeriodsService {
    @Autowired
    private ChangePeriodsMapper changePeriodsMapper;
    @Override
    public List<CreditCard> searchChangePeriodsByPage(String cardNum, PageIndexer page) {
        List<CreditCard> lists = changePeriodsMapper.getChangePeriods(cardNum, (page.getPageIndex() - 1) * page.getPageSize(), page.getPageSize());

        // 计算总页数
        int count = changePeriodsMapper.getCounts(cardNum);
        page.setPageCount((int)Math.ceil(count*1.0/page.getPageSize()));
        page.setCount(count);
        return lists;
    }

    @Override
    public CreditCard searchChangeDetails(String cardNum, String changeDate) {
        return changePeriodsMapper.getChangeDetails(cardNum,changeDate);
    }
}
