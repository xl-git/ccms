package com.szit.eurekacustomermanage.service.impl;

import com.szit.eurekacustomermanage.mapper.CreditCardMapper;
import com.szit.eurekacustomermanage.pojo.CreditCard;
import com.szit.eurekacustomermanage.pojo.PageIndexer;
import com.szit.eurekacustomermanage.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 信用卡业务逻辑层实现类
 * @author 肖林
 * @version 1.0 2020-04-04
 */
@Service("creditCardService")
public class CreditCardServiceImpl implements CreditCardService {
    @Autowired
    private CreditCardMapper creditCardMapper;

    @Override
    /**
     * 通过用户编号获取信用卡信息
     * @param uid 用户编号
     * @return 返回信用卡实体对象
     */
    public List<CreditCard> getCreditCardsByUserId(Integer userId, PageIndexer page) {
        List<CreditCard> lists=creditCardMapper.getCreditCardsByUserId(userId,(page.getPageIndex() - 1) * page.getPageSize(),
                page.getPageSize());
        // 计算总页数
        int count = creditCardMapper.getAllCreditCards(userId);

        page.setPageCount((int)Math.ceil(count*1.0/page.getPageSize()));
        page.setCount(count);

        return lists;
    }


    public CreditCardMapper getCreditCardMapper() {
        return creditCardMapper;
    }

    public void setCreditCardMapper(CreditCardMapper creditCardMapper) {
        this.creditCardMapper = creditCardMapper;
    }

}
