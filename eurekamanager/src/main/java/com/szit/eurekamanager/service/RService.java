package com.szit.eurekamanager.service;

import com.szit.eurekamanager.pojo.BaseInfo;
import com.szit.eurekamanager.pojo.PageIndexer;
import com.szit.eurekamanager.pojo.Repayment;

import java.util.List;

/**
 * @author
 */
public interface RService {
    /**
     * 获取还款记录表集合
     * @return
     */
    List<Repayment> getRepayments(String cardNum, String identityId, PageIndexer page);

    /**
     * 通过用户id获取基本信息表集合
     * @param id
     * @return
     */
    List<BaseInfo> getBaseInfosByid(Integer id);
}
