package com.szit.eurekarepaymentmanage.mapper;

import com.szit.eurekarepaymentmanage.pojo.*;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 还款数据访问层接口
 * @author 艾邓枫
 * @version 1.0 2020-04-04
 */

@Repository("repaymentMapper")
public interface RepaymentMapper {
    List<Repayment> getAlreadyLimitByCardId(Integer cardid);

    /**
     * 通过用户编号获取信用卡号
     * @param id
     * @return
     */
    List<CreditCard> getCardById(@Param("id") Integer id,@Param("from") Integer from,@Param("pageSize") Integer pageSize);

    int getAll(@Param("id") Integer id);

    User getUserByUserName(String userName);

    CreditCard getCreditCardByCardNum(String cardNum);

    /**
     * 通过信用卡编号获取逾期表信息
     * @param id
     * @return
     */
    Overdue getOverdueById(Integer id);

    /**
     * 通过信用卡id获取分期账单
     * @param id
     * @return
     */
    ChangePeriods getChangePeriodsById(Integer id);

    /**
     * 更改还款记录表
     * @param repayment
     * @return
     */
    int addRepayment(Repayment repayment);

    /**
     * 通过用户id获取借记卡表
     * @param id
     * @return
     */
    List<DebitCard> getDebitCardById(Integer id);

    /**
     * 更改信用卡的信息
     * @param creditCard
     * @return
     */
    int alterCreditCard(CreditCard creditCard);

    /**
     * 通过选择的借记卡账户返回借记卡
     * @return
     */
    DebitCard getDebitCardByDid(String debitCardId);

    /**
     * 修改借记卡金额
     * @param debitCard
     * @return
     */
    int alterDebitCard(DebitCard debitCard);

    List<Repayment> getAllRepayments(@Param("from") Integer from,@Param("pageSize") Integer pageSize,@Param("userId") Integer userId);

    int getCounts(@Param("userId") Integer userId);
}
