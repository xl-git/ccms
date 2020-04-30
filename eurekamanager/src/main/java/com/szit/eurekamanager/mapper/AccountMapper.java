package com.szit.eurekamanager.mapper;

import com.szit.eurekamanager.pojo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountMapper")
public interface AccountMapper {
    /**
     * 分页列出所有账户
     * @return
     */
    List<CreditCard> getAccountsByPage(@Param("cardNum")String cardNum, @Param("from")Integer from,
                                 @Param("pageSize")Integer pageSize);


    /**
     * 查询分页记录总数,以便求总页数
     * @param cardNum 卡号
     * @return 返回记录总数
     */
    int getCountsByPage(@Param("cardNum") String cardNum);

    /**
     * 查询账户详情
     * @param cardNum 卡号
     * @return
     */
    CreditCard getAccountDetails(String cardNum);

    /**
     * 分页查询历史交易
     * @param cardNum 卡号
     * @return
     */
    List<CreditCard> getHistoryTransactionsByPage(@Param("cardNum") String cardNum,@Param("from")Integer from,
                                                    @Param("pageSize")Integer pageSize);

    /**
     * 查询分页历史交易记录总数,以便求总页数
     * @param cardNum
     * @return
     */
    int getCounts(@Param("cardNum")String cardNum);

    CreditCard getHistoryDetails(@Param("transDate") String transDate,@Param("cardNum")String cardNum);
}
