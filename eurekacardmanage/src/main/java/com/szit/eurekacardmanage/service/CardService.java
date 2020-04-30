package com.szit.eurekacardmanage.service;

import com.szit.eurekacardmanage.pojo.*;

/**
 * 卡片管理业务逻辑层接口
 */
public interface CardService {
    /**
     * 添加信用卡信息
     * @param card
     * @return
     */
    int addCard(CreditCard card);

    /**
     * 添加信用卡申请状态
     * @param
     * @return
     */
    boolean addOpenStatus(User user,int type,ContactInfo contactInfo,UnitInfo unitInfo,BaseInfo baseInfo);


    /**
     * 添加基本信息
     * @param baseInfo
     * @return
     */
    void addBaseInfo(BaseInfo baseInfo);


    /**
     * 添加单位信息
     * @param unitInfo
     * @return
     */
    void addUnitInfo(UnitInfo unitInfo);

    /**
     * 添加联系人信息
     * @param contactInfo
     * @return
     */
    void addContactInfo(ContactInfo contactInfo);


    /**
     * 修改卡片状态id
     * @return
     */
    int updateCardStatusIdByCardNum(CreditCard creditCard,String identityCard);

    /**
     * 修改卡片交易密码
     * @param cardNum
     * @param oldPassword
     * @param newPassword
     * @param userId
     * @return
     */
    int updatePayPasswordByCardNum(String cardNum,String oldPassword, String newPassword,Integer userId);

    /**
     * 根据卡号获取信用卡信息
     * @param cardNum
     * @return 信用卡对象
     */
    CreditCard searchCardByCardNumAndUserId(String cardNum,Integer userId);

    /**
     * 通过用户名查询用户信息
     * @param name
     * @return
     */
    User getUserByUserName(String name);
}
