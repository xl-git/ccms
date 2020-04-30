package com.szit.eurekamanager.service;

import com.szit.eurekamanager.pojo.CreditCard;
import com.szit.eurekamanager.pojo.PageIndexer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ChangePeriodsService {

    /**
     * 分页查询分期信息
     * @param cardNum
     * @return
     */
    List<CreditCard> searchChangePeriodsByPage(@Param("cardNum")String cardNum, PageIndexer page);

    CreditCard searchChangeDetails(String cardNum,String changeDate);
}
