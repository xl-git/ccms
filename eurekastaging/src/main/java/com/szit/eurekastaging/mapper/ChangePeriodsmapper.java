package com.szit.eurekastaging.mapper;

import com.szit.eurekastaging.pojo.ChangePeriods;

import java.util.List;

/**
 * 用户分期数据访问层接口
 * @author 刘志强
 * @version 1.0 2020-4-20
 */
public interface ChangePeriodsmapper {

    /**
     * 分期申请
     * @return
     */
    List<ChangePeriods> ChangePeriodsApplication();
}
