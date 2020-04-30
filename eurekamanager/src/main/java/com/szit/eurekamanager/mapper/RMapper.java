package com.szit.eurekamanager.mapper;

import com.szit.eurekamanager.pojo.BaseInfo;
import com.szit.eurekamanager.pojo.Repayment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author
 */
@Repository("rMapper")
public interface RMapper {


    /**
     * 获取还款记录表集合
     * @return
     */
    List<Repayment> getRepayments(@Param("cardNum") String cardNum, @Param("identityId") String indentityId, @Param("from") Integer from, @Param("pageSize") Integer pageSize);

    int getAll(@Param("cardNum") String cardNum, @Param("identityId") String indentityId);


    /**
     * 通过用户id获取基本信息表集合
     * @param id
     * @return
     */
    List<BaseInfo> getBaseInfosByid(Integer id);

}