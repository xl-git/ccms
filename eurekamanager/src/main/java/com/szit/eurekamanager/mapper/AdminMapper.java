package com.szit.eurekamanager.mapper;

import com.szit.eurekamanager.pojo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("adminMapper")
public interface AdminMapper {
    /**
     * 通过账号查看工作人员信息
     * @param adminName 账号
     * @return Admin实体对象
     */
    Admin getAdminByadminName(@Param("adminName") String adminName);

    /**
     * 通过卡号查询信用卡信息
     * @param cardNum 卡号
     * @return
     */
    CreditCard getCardByCardNum(String cardNum);

    /**
     * 修改交易密码
     * @param card 卡号
     * @return 返回是否修成功
     */
    int updatePwd(CreditCard card);

    /**
     * 修改用户单位信息
     * @param cardNum 卡号
     * @param unitAddress 用户单位地址
     * @param unitIphone 用户单位电话
     * @return 返回是否修成功
     */
    int updateUnit(String unitAddress,String unitIphone, String cardNum);

    /**
     * 修改信用卡基本信息
     * @param iphoneNum 手机号
     * @param education 教育程度
     * @param homeAddress 现住址
     * @param familyAddress 户籍
     * @param cardNum 卡号
     * @return 返回是否修成功
     */
    int updateBaseInfo(String iphoneNum,String education,String homeAddress, String familyAddress, String cardNum);

    /**
     * 修改邮箱信息
     * @param email 邮箱
     * @param cardNum 卡号
     * @return 返回是否修成功
     */
    int updateEmail(@Param("email")String email,@Param("cardNum")String cardNum);



    /**
     * 通过身份证号查询信用卡信息
     * @param identityCard 身份证号
     * @return
     */
    List<CreditCard> getCardByIdentityCard(String identityCard,Integer from,Integer pageSize);

    int getCounts(String identityCard);

    /**
     * 挂失
     * @param cardNum 卡号
     * @return
     */
    boolean loseHandle(String cardNum);

    /**
     * 冻结
     * @param cardNum 卡号
     * @return
     */
    boolean freeze(String cardNum);

    /**
     * 销卡
     * @param cardNum 卡号
     * @return
     */
    boolean cancel(String cardNum);

    /**
     * 解除挂失
     * @param cardNum 卡号
     * @return
     */
    boolean relieve(String cardNum);

    /**
     * 查询待激活的用户
     * @return
     */
    List<Noactivate> getActivateLists(@Param("from")Integer from,@Param("pageSize")Integer pageSize);

    int getActivateCounts();
}
