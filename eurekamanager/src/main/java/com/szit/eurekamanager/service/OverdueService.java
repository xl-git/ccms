package com.szit.eurekamanager.service;

import com.szit.eurekamanager.pojo.CreditCard;
import com.szit.eurekamanager.pojo.Overdue;
import com.szit.eurekamanager.pojo.PageIndexer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OverdueService {
    /**
     * 分页查询逾期信息
     * @param cardNum
     * @return
     */
    List<CreditCard> searchOverdueByPage(@Param("cardNum")String cardNum, PageIndexer page);
}
