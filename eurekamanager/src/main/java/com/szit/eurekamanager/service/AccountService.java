package com.szit.eurekamanager.service;

import com.szit.eurekamanager.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AccountService {
    /**
     * 分页获取用户信息
     * @param cardNum 按卡号查询
     * @param page 分页实体对象
     * @return 返回账户实体对象泛型集合
     */
    List<CreditCard> listByPage(String cardNum, PageIndexer page);

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
    List<CreditCard> listHistoryTransactionsByPage(String cardNum, PageIndexer page);

    CreditCard searchHistoryDetails(String transDate,String cardNum);
}
