package com.szit.eurekarepaymentmanage.service;


import com.szit.eurekarepaymentmanage.pojo.*;

import java.util.List;

/**
 * 还款业务逻辑层接口
 * @author 艾邓枫
 * @version 1.0 2020-04-04
 */
public interface RepaymentService {
    /**
     * 通过信用卡id获取分期账单
     * @param id
     * @return
     */
    ChangePeriods getChangePeriodsById(Integer id);

    /**
     * 通过用户用户ID获取信用卡信息
     * @return
     */
    List<CreditCard> getCardById(Integer id,PageIndexer page);

    User getUserByUserName(String userName);

    CreditCard getCreditCardByCardNum(String cardNum);

    /**
     * 通过信用卡编号获取逾期表信息
     * @param id
     * @return
     */
    Overdue getOverdueById(Integer id);

    boolean addRepayment(Repayment repayment);

    List<DebitCard> getDebitCardById(Integer id);

    /**
     * 通过选择的借记卡账户返回借记卡
     * @return
     */
    DebitCard getDebitCardByDid(String  debitCardId);

    /**
     * 更改信用卡的信息
     * @param creditCard
     * @return
     */
    boolean alterCreditCard(CreditCard creditCard);

    /**
     * 修改借记卡金额
     * @param debitCard
     * @return
     */
    boolean alterDebitCard(DebitCard debitCard);

    List<Repayment> getAll(Integer userId,PageIndexer page);
}
