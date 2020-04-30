package com.szit.eurekastaging.service;

import com.szit.eurekastaging.pojo.CreditCard;
import com.szit.eurekastaging.pojo.PageIndexer;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;


/**
 * 用户分期数据访问层接口
 * @author 刘志强
 * @version 1.0 2020-4-20
 */
public interface CreditCardService {

    /**
     * 通过信用卡表查询是否办卡
     * @param userId
     * @return
     */

    List<CreditCard> getByuserId(Integer userId, PageIndexer page);

    /**
     * 通过卡片id查询卡片信息
     * @param id
     * @return
     */
    CreditCard getCardById(Integer id);
}
