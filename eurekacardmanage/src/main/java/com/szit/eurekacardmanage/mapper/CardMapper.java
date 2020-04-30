package com.szit.eurekacardmanage.mapper;

import com.szit.eurekacardmanage.pojo.*;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;

/**
 * 卡片管理数据访问层接口
 * @author 苏泽平
 * @version 1.0 2020-04-22
 */
@Mapper
public interface CardMapper {

    /**
     * 添加信用卡信息
     * @param card
     * @return
     */
    int addCard(@Param("card") CreditCard card);

    /**
     * 添加信用卡申请状态
     * @param openStatus 信用卡申请状态对象
     * @return
     */
    int addOpenStatus(OpenStatus openStatus);


    /**
     * 添加基本信息
     * @param baseInfo
     * @return
     */
    int addBaseInfo(BaseInfo baseInfo);


    /**
     * 添加单位信息
     * @param unitInfo
     * @return
     */
    int addUnitInfo(UnitInfo unitInfo);

    /**
     * 添加联系人信息
     * @param contactInfo
     * @return
     */
    int addContactInfo(ContactInfo contactInfo);


    /**
     * 修改卡片状态id
     * @param cardStatusId
     * @param CardNum
     * @return
     */
    int updateCardStatusIdByCardNum(@Param("creditCard") Integer cardStatusId,@Param("CardNum") String CardNum);

    /**
     * 修改卡片交易密码
     * @param CardNum
     * @param oldPassword
     * @param newPassword
     * @param userId
     * @return
     */
    int updatePayPasswordByCardNum(@Param("CardNum") String CardNum,@Param("oldPassword") String oldPassword,@Param("newPassword") String newPassword,@Param("userId") Integer userId);

    /**
     * 根据卡号获取信用卡信息
     * @param cardNum
     * @return 信用卡对象
     */
    CreditCard searchCardByCardNumAndUserId(@Param("cardNum") String cardNum,@Param("userId") Integer userId);

    /**
     * 通过用户名查询用户信息
     * @param name
     * @return
     */
    User getUserByUserName(@Param("name") String name);
}
