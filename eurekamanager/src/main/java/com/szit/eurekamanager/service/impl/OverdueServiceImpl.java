package com.szit.eurekamanager.service.impl;

import com.szit.eurekamanager.mapper.OverdueMapper;
import com.szit.eurekamanager.pojo.CreditCard;
import com.szit.eurekamanager.pojo.PageIndexer;
import com.szit.eurekamanager.service.OverdueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("overdueService")
public class OverdueServiceImpl implements OverdueService {

    @Autowired
    private OverdueMapper overdueMapper;
    @Override
    public List<CreditCard> searchOverdueByPage(String cardNum, PageIndexer page) {
        List<CreditCard> lists = overdueMapper.getOverdueByPage(cardNum, (page.getPageIndex() - 1) * page.getPageSize(), page.getPageSize());

        // 计算总页数
        int count = overdueMapper.getCounts(cardNum);
        page.setPageCount((int)Math.ceil(count*1.0/page.getPageSize()));
        page.setCount(count);
        return lists;
    }
}
