package com.szit.eurekamanager.service.impl;

import com.szit.eurekamanager.mapper.CardMapper;
import com.szit.eurekamanager.pojo.CreditCard;
import com.szit.eurekamanager.pojo.OpenStatus;
import com.szit.eurekamanager.pojo.PageIndexer;
import com.szit.eurekamanager.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 卡片申请处理业务逻辑层
 */
@Service("cardService")
public class CardServiceImpl implements CardService {
    @Autowired
    CardMapper cardMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    //@Transactional(propagation= Propagation.REQUIRED)
    public boolean addCard(CreditCard creditCard) {
        boolean flag=false;
     //   try {
            this.updateOpenStatus(creditCard.getUserId(),"成功");
            this.deleteBaseinfo(this.getMaxBaseinfoId(creditCard.getUserId()));
            this.deleteUnitinfo(this.getUnitInfoId(creditCard.getUserId()));
            this.deleteContactinfo(this.getContactInfoId(creditCard.getUserId()));
            Long cardNum=Long.valueOf(this.searchCreditCard().getCardNum())+1;
            creditCard.setCardNum(cardNum.toString());
            switch (creditCard.getCardType()){
                case 1:
                    creditCard.setCreditLimit(5000.0);
                    creditCard.setUseableLimit(5000.0);
                    break;
                case 2:
                    creditCard.setCreditLimit(10000.0);
                    creditCard.setUseableLimit(10000.0);
                    break;
                case 3:
                    creditCard.setCreditLimit(15000.0);
                    creditCard.setUseableLimit(15000.0);
                    break;
            }
            cardMapper.addCard(creditCard);
            flag=true;
//        }catch (Exception e){
//            throw new RuntimeException("提交异常");
//        }
        return flag;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    //@Transactional(propagation= Propagation.REQUIRED)
    public boolean cleanCard(Integer userId) {
        boolean flag=false;
        System.out.println("service userid:"+userId);
//        try{
            this.updateOpenStatus(userId,"失败");
            this.deleteBaseinfo(this.getMinBaseinfoId(userId));
            this.deleteUnitinfo(this.getMinUnitInfoId(userId));
            this.deleteContactinfo(this.getMinContactInfoId(userId));
            flag=true;
//        }catch (Exception e){
//            throw new RuntimeException("提交异常");
//        }
        return flag;
    }


    @Override
    public void updateOpenStatus(Integer userId, String status) {
        System.out.println("update:"+userId+"--"+status);
        this.cardMapper.updateOpenStatus(userId,status);
    }

    @Override
    public void deleteBaseinfo(Integer id) {
        this.cardMapper.deleteBaseinfo(id);
    }

    @Override
    public void deleteUnitinfo(Integer id) {
        this.cardMapper.deleteUnitinfo( id);
    }

    @Override
    public void deleteContactinfo( Integer id) {
        this.cardMapper.deleteContactinfo(id);
    }

    @Override
    public Integer getMaxBaseinfoId(Integer userId) {
        System.out.println("uid:"+userId);
        return cardMapper.getMaxBaseinfoId(userId);
    }

    @Override
    public Integer getUnitInfoId(Integer userId) {
        return cardMapper.getMaxUnitInfoId(userId);
    }

    @Override
    public Integer getContactInfoId(Integer userId) {
        return cardMapper.getMaxContactInfoId(userId);
    }

    @Override
    public List<OpenStatus> getOpenStatusList(PageIndexer pageIndexer) {
        pageIndexer.setCount((int)Math.ceil(cardMapper.getCount()*1.0/pageIndexer.getPageSize()));
        List<OpenStatus> openStatuses=cardMapper.getOpenStatusList((pageIndexer.getPageIndex()-1)*pageIndexer.getPageSize()
                ,pageIndexer.getPageSize());
        return openStatuses;
    }

    public void saveAddCard(CreditCard creditCard){
        cardMapper.addCard(creditCard);
    }

    @Override
    public OpenStatus searchOpenStatus(Integer userId) {
        return cardMapper.searchOpenStatus(userId);
    }

    @Override
    public CreditCard searchCreditCard() {
        return cardMapper.searchCreditCard();
    }

    @Override
    public int getMinBaseinfoId(Integer userId) {
        return cardMapper.getMinBaseinfoId(userId);
    }

    @Override
    public int getMinUnitInfoId(Integer userId) {
        return cardMapper.getMinUnitInfoId(userId);
    }

    @Override
    public int getMinContactInfoId(Integer userId) {
        return cardMapper.getMinContactInfoId(userId);
    }
}
