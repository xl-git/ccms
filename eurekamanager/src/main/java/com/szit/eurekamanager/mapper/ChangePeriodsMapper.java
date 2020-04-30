package com.szit.eurekamanager.mapper;

import com.szit.eurekamanager.pojo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("changePeriodsMapper")
public interface ChangePeriodsMapper {
    List<CreditCard> getChangePeriods(@Param("cardNum")String cardNum, @Param("from")Integer from,
                                      @Param("pageSize")Integer pageSize);

    int getCounts(@Param("cardNum")String cardNum);

    CreditCard getChangeDetails(@Param("cardNum") String cardNum,@Param("changeDate")String changeDate);
}
