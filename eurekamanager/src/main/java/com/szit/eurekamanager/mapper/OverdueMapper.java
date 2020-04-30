package com.szit.eurekamanager.mapper;

import com.szit.eurekamanager.pojo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("overdueMapper")
public interface OverdueMapper {
    /**
     * 分页查询逾期信息
     * @param cardNum
     * @return
     */
    List<CreditCard> getOverdueByPage(@Param("cardNum")String cardNum, @Param("from")Integer from,
                                      @Param("pageSize")Integer pageSize);

    /**
     * 查询分页记录总数,以便求总页数
     * @param cardNum
     * @return
     */
    int getCounts(@Param("cardNum")String cardNum);
}
