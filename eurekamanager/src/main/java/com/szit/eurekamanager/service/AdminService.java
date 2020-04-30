package com.szit.eurekamanager.service;

import com.szit.eurekamanager.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminService {
    /**
     * 工作人员登录
     * @param admin 工作人员实体对象
     * @return 返回登录是否成功
     */
    boolean adminLogin(Admin admin);

    /**
     * 查询信用卡信息
     * @param cnum 卡号
     * @return 返回是否找到信用卡信息
     */
    CreditCard searchCard(String cnum);

    /**
     * 修改交易密码
     * @param card
     * @return 返回是否修成功
     */
    boolean updatePwd(CreditCard card);

    /**
     * 修改用户单位信息
     * @param card 信用卡实体对象
     * @param unitInfo 用户单位实体对象
     * @return 返回是否修成功
     */
    boolean updateUnit(UnitInfo unitInfo ,CreditCard card);

    /**
     * 修改信用卡基本信息
     * @param baseInfo 信用卡基本信息实体对象
     * @param card 信用卡实体对象
     * @return 返回是否修成功
     */
    boolean updateBaseInfo(BaseInfo baseInfo,CreditCard card);

    /**
     * 修改邮箱信息
     * @param email 邮箱
     * @param cardNum 卡号
     * @return 返回是否修成功
     */
    boolean updateEmail(@Param("email")String email,@Param("cardNum")String cardNum);


    /**
     * 通过身份证号查询信用卡信息
     * @param identityCard 身份证号
     * @return
     */
    List<CreditCard> searchCardByIdentityCard(String identityCard,PageIndexer page);

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
     * 销户
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
    List<Noactivate> ActivateLists(PageIndexer page);
}
