package com.szit.eurekastaging.service;

import com.szit.eurekastaging.pojo.ChangePeriods;
import com.szit.eurekastaging.pojo.PageIndexer;


import java.util.Date;
import java.util.List;

public interface ChangePeriodsService {

    /**
     * 添加分期信息
     * @param changePeriods
     * @return
     */
    int addChangePeriods(ChangePeriods changePeriods);

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
    List<ChangePeriods> getChangePeriodsBycardId(Integer userId, Date lowdate, Date highdate, PageIndexer page);

}
