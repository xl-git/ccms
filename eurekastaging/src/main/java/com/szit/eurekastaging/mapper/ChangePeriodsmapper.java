package com.szit.eurekastaging.mapper;

import com.szit.eurekastaging.pojo.ChangePeriods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


@Mapper
public interface ChangePeriodsMapper {
    /**
     * 添加分期信息
     * @param changePeriods
     * @return
     */
    int addChangePeriods(@Param("changePeriods") ChangePeriods changePeriods);

    /**
     * 当前申请查询
     * @param changeDate
     * @return
     */
    List<ChangePeriods> getChangePeriodsBychangeDate(Date changeDate);

    /**
     * 历史申请查询
     * @param userId
     * @return
     */
    List<ChangePeriods> getChangePeriodsBycardId(@Param("userId")Integer userId,
                                                 @Param("lowdate")Date lowdate,
                                                 @Param("highdate")Date highdate,
                                                    @Param("from")Integer from,
                                                 @Param("pageSize")Integer pageSize);
    int getCounts(@Param("userId")Integer userId,
                  @Param("lowdate")Date lowdate,
                  @Param("highdate")Date highdate);

}
