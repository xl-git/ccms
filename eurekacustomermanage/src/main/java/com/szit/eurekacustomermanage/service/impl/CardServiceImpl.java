package com.szit.eurekacustomermanage.service.impl;

import com.szit.eurekacustomermanage.mapper.CardMapper;
import com.szit.eurekacustomermanage.pojo.Card;
import com.szit.eurekacustomermanage.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 信用卡业务逻辑层实现类
 * @author 肖林
 * @version 1.0 2020-04-04
 */
@Service("cardService")
public class CardServiceImpl implements CardService {
    @Autowired
    private CardMapper cardMapper;

    @Override
    /**
     * 通过用户编号获取信用卡信息
     * @param uid 用户编号
     * @return 返回信用卡实体对象
     */
    public Card getCardByUid(Integer uid) {
        return cardMapper.getCardByUid(uid);
    }

    /**
     * 通过信用卡基本信息编号获取信用卡信息
     * @param ccid 信用卡基本信息编号
     * @return 返回信用卡实体对象
     */
    @Override
    public Card getCardByCcid(Integer ccid) {
        return cardMapper.getCardByCcid(ccid);
    }

    /**
     * 修改Email
     * @param card 信用卡实体类
     * @return 返回是否修改成功
     */
    @Override
    public int updateEmail(Card card) {
        return cardMapper.updateEmail(card);
    }

    public CardMapper getCardMapper() {
        return cardMapper;
    }

    public void setCardMapper(CardMapper cardMapper) {
        this.cardMapper = cardMapper;
    }
}
