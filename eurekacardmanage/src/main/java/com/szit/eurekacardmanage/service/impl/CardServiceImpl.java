package com.szit.eurekacardmanage.service.impl;

import com.szit.eurekacardmanage.mapper.CardMapper;
import com.szit.eurekacardmanage.pojo.*;
import com.szit.eurekacardmanage.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 卡片管理业务逻辑层接口实现类
 */
@Service("cardService")
public class CardServiceImpl implements CardService {
    @Autowired
    private CardMapper cardMapper;

    @Override
    public int addCard(CreditCard card) {
        return 0;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public boolean addOpenStatus(User user,int type,ContactInfo contactInfo,UnitInfo unitInfo,BaseInfo baseInfo) {
        boolean flag=false;
        try{
            baseInfo.setUserId(user.getId());
            this.addBaseInfo(baseInfo);
            unitInfo.setUserId(user.getId());
            this.addUnitInfo(unitInfo);
            contactInfo.setUserId(user.getId());
            this.addContactInfo(contactInfo);
            cardMapper.addOpenStatus(new OpenStatus(0,user.getId(),"待审核",new Date(),type,user));
            flag=true;
        }catch (Exception e){
            throw new RuntimeException("添加异常");
        }
        return flag;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public void addBaseInfo(BaseInfo baseInfo) {
        cardMapper.addBaseInfo(baseInfo);
    }

    @Override
    public void addUnitInfo(UnitInfo unitInfo) {
        cardMapper.addUnitInfo(unitInfo);
    }

    @Override
    public void addContactInfo(ContactInfo contactInfo) {
        cardMapper.addContactInfo(contactInfo);
    }

    @Override
    public int updateCardStatusIdByCardNum(CreditCard creditCard,String identityCard) {
        CreditCard creditCard1=this.searchCardByCardNumAndUserId(creditCard.getCardNum(),creditCard.getUserId());
        int flag=0;
        if(creditCard1!=null){
            if(creditCard1.getPayPassword().equals(creditCard.getPayPassword())
                    || identityCard.equals(creditCard1.getBaseInfo().getIdentityCard())){
                flag=this.cardMapper.updateCardStatusIdByCardNum(creditCard.getCardStatusId(),creditCard.getCardNum());
            }
        }
        return flag;
    }

    @Override
    public int updatePayPasswordByCardNum(String cardNum, String oldPassword, String newPassword, Integer userId) {
        int flag=this.cardMapper.updatePayPasswordByCardNum(cardNum,oldPassword, newPassword,userId);
        return flag;
    }

    @Override
    public CreditCard searchCardByCardNumAndUserId(String cardNum, Integer userId) {
        return cardMapper.searchCardByCardNumAndUserId(cardNum,userId);
    }


    @Override
    public User getUserByUserName(String name) {
        return cardMapper.getUserByUserName(name);
    }
}
