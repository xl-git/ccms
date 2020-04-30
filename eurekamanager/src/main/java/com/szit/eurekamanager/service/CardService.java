package com.szit.eurekamanager.service;

import com.szit.eurekamanager.pojo.CreditCard;
import com.szit.eurekamanager.pojo.OpenStatus;
import com.szit.eurekamanager.pojo.PageIndexer;

import java.util.List;

public interface CardService {
    /**
     * 卡片添加
     * @param creditCard
     * @return
     */
    boolean addCard(CreditCard creditCard);

    /**
     * 清除卡片申请信息
     * @param userId
     * @return
     */
    boolean cleanCard(Integer userId);


    /**
     * 修改信用卡申请状态
     */
    void updateOpenStatus(Integer userId, String status);

    /**
     * 清除基本信息
     */

    void deleteBaseinfo(Integer id);

    /**
     * 清除单位信息
     */
    void deleteUnitinfo(Integer id);

    /**
     * 清除联系人信息
     */
    void deleteContactinfo(Integer id);


    /**
     *  获取最新id
     * @param userId
     * @return
     */
    Integer getMaxBaseinfoId(Integer userId);

    /**
     *  获取最新id
     * @param userId
     * @return
     */
    Integer getUnitInfoId(Integer userId);

    /**
     *  获取最新id
     * @param userId
     * @return
     */
    Integer getContactInfoId(Integer userId);

    /**
     * 获取卡片申请信息列表
     * @return 卡片申请信息实体泛型集合
     */
    List<OpenStatus> getOpenStatusList(PageIndexer pageIndexer);

    /**
     * 根据用户编号查询用户申请信息
     * @param userId
     * @return
     */
    OpenStatus searchOpenStatus(Integer userId);

    /**
     * 获取最新办理信用卡卡卡号
     * @return
     */
    CreditCard searchCreditCard();

    /**
     *  获取旧信息id
     * @param userId
     * @return
     */
    int getMinBaseinfoId(Integer userId);

    /**
     *  获取旧信息id
     * @param userId
     * @return
     */
    int getMinUnitInfoId(Integer userId);

    /**
     *  获取旧信息id
     * @param userId
     * @return
     */
    int getMinContactInfoId(Integer userId);

    void saveAddCard(CreditCard creditCard);
}
