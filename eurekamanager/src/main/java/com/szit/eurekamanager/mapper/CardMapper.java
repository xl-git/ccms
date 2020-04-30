package com.szit.eurekamanager.mapper;

import com.szit.eurekamanager.pojo.CreditCard;
import com.szit.eurekamanager.pojo.OpenStatus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CardMapper {
    /**
     * 卡片添加
     * @param creditCard
     * @return
     */
    int addCard(CreditCard creditCard);


    /**
     * 修改信用卡申请状态
     */
    int updateOpenStatus(@Param("userId") Integer userId, @Param("status") String status);

    /**
     * 清除基本信息
     */

    int deleteBaseinfo(@Param("id") Integer id);

    /**
     * 清除单位信息
     */
    int deleteUnitinfo(@Param("id") Integer id);

    /**
     * 清除联系人信息
     */
    int deleteContactinfo(@Param("id") Integer id);


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
    Integer getMaxUnitInfoId(Integer userId);

    /**
     *  获取最新id
     * @param userId
     * @return
     */
    Integer getMaxContactInfoId(Integer userId);

    /**
     *  获取旧信息id
     * @param userId
     * @return
     */
    int getMinBaseinfoId(@Param("userId") Integer userId);

    /**
     *  获取旧信息id
     * @param userId
     * @return
     */
    int getMinUnitInfoId(@Param("userId") Integer userId);

    /**
     *  获取旧信息id
     * @param userId
     * @return
     */
    int getMinContactInfoId(@Param("userId") Integer userId);


    /**
     * 获取卡片申请信息列表
     * @return 卡片申请信息实体泛型集合
     */
    List<OpenStatus> getOpenStatusList(@Param("fromRow") Integer fromRow, @Param("pageSize") Integer pageSize);

    /**
     * 获取待审核信用卡查询记录数
     * @return
     */
    int getCount();

    /**
     * 查询卡片申请信息
     * @param userId
     * @return
     */
    OpenStatus searchOpenStatus(@Param("userId") Integer userId);

    /**
     * 获取最新办理信用卡卡卡号
     * @return
     */
    CreditCard searchCreditCard();
}
