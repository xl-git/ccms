package com.szit.eurekastaging.service.impl;

import com.szit.eurekastaging.mapper.CreditCardMapper;
import com.szit.eurekastaging.pojo.CreditCard;
import com.szit.eurekastaging.pojo.PageIndexer;
import com.szit.eurekastaging.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("creditCardService")
public class CreditCardServiceImpl implements CreditCardService {
    @Autowired
    private CreditCardMapper creditCardMapper;

    @Override
    public List<CreditCard> getByuserId(Integer userId, PageIndexer page) {
        List<CreditCard> lists=creditCardMapper.getByuserId(userId,(page.getPageIndex() - 1) * page.getPageSize(),
                page.getPageSize());
        // 计算总页数
        int count = creditCardMapper.getAll(userId);

        page.setPageCount((int)Math.ceil(count*1.0/page.getPageSize()));
        page.setCount(count);

        return lists;
    }

    @Override
    public CreditCard getCardById(Integer id) {
        return creditCardMapper.getCardById(id);
    }

    public CreditCardMapper getCreditCardMapper() {
        return creditCardMapper;
    }

    public void setCreditCardMapper(CreditCardMapper creditCardMapper) {
        this.creditCardMapper = creditCardMapper;
    }
}
