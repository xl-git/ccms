package com.szit.eurekarepaymentmanage.service.impl;

import com.szit.eurekarepaymentmanage.mapper.RepaymentMapper;
import com.szit.eurekarepaymentmanage.pojo.*;
import com.szit.eurekarepaymentmanage.service.RepaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("repaymentService")
public class RepaymentServiceImpl implements RepaymentService {
    @Autowired
    private RepaymentMapper repaymentMapper;

    /**
     * 通过信用卡id获取分期账单
     * @param id
     * @return
     */
    @Override
    public ChangePeriods getChangePeriodsById(Integer id){
        return repaymentMapper.getChangePeriodsById(id);
    }

    /**
     * 通过用户ID获取信用卡信息
     * @param id
     * @return
     */
    @Override
    public List<CreditCard> getCardById(Integer id,PageIndexer page){
        List<CreditCard> lists=repaymentMapper.getCardById(id,(page.getPageIndex() - 1) * page.getPageSize(),
                page.getPageSize());
        // 计算总页数
        int count = repaymentMapper.getAll(id);

        page.setPageCount((int)Math.ceil(count*1.0/page.getPageSize()));
        page.setCount(count);

        return lists;
    }

    @Override
    public User getUserByUserName(String userName) {
        return repaymentMapper.getUserByUserName(userName);
    }

    @Override
    public CreditCard getCreditCardByCardNum(String cardNum) {
        return repaymentMapper.getCreditCardByCardNum(cardNum);
    }


    /**
     * 通过信用卡编号获取逾期表信息
     * @param id
     * @return
     */
    @Override
    public Overdue getOverdueById(Integer id){
        return  repaymentMapper.getOverdueById(id);
    }

    /**
     * 添加还款记录表信息
     * @param repayment
     * @return
     */
    @Override
    public boolean addRepayment(Repayment repayment){
        boolean flag=true;
        if(repaymentMapper.addRepayment(repayment)!=1){
            flag=false;
        }
        return flag;
    }

    /**
     * 更改信用卡的信息
     * @param creditCard
     * @return
     */
    @Override
    public boolean alterCreditCard(CreditCard creditCard){
        boolean flag=true;
        if(repaymentMapper.alterCreditCard(creditCard)!=1){
            flag=false;
        }
        return flag;
    }

    /**
     * 通过用户id获取借记卡信息
     * @param id
     * @return
     */
    @Override
    public List<DebitCard> getDebitCardById(Integer id){

        return repaymentMapper.getDebitCardById(id);
    }


    /**
     * 通过选择的借记卡账户返回借记卡
     * @return
     */
    @Override
    public DebitCard getDebitCardByDid(String debitCardId){
        return repaymentMapper.getDebitCardByDid(debitCardId);
    }


    /**
     * 修改借记卡金额
     * @param debitCard
     * @return
     */
    public boolean alterDebitCard(DebitCard debitCard){
        boolean flag=true;
        if(repaymentMapper.alterDebitCard(debitCard)!=1){
            flag=false;
        }
        return flag;
    }

    @Override
    public List<Repayment> getAll(Integer userId,PageIndexer page) {
        List<Repayment> lists=repaymentMapper.getAllRepayments((page.getPageIndex() - 1) * page.getPageSize(),
                page.getPageSize(),userId);
        // 计算总页数
        int count = repaymentMapper.getCounts(userId);

        page.setPageCount((int)Math.ceil(count*1.0/page.getPageSize()));
        page.setCount(count);
        System.out.println(lists.get(0));

        return lists;
    }


    public RepaymentMapper getRepaymentMapper() {
        return repaymentMapper;
    }

    public void setRepaymentMapper(RepaymentMapper repaymentMapper) {
        this.repaymentMapper = repaymentMapper;
    }
}
