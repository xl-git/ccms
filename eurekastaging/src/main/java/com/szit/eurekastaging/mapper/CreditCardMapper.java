package com.szit.eurekastaging.mapper;

import com.szit.eurekastaging.pojo.CardStatus;
import com.szit.eurekastaging.pojo.CreditCard;
import com.szit.eurekastaging.pojo.User;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 用户分期数据访问层接口
 * @author 刘志强
 * @version 1.0 2020-4-20
 */
@Repository("creditCardMapper")
public interface CreditCardMapper {

    /**
     * 通过信用卡表查询是否办卡
     * @param userId
     * @return
     */

    List<CreditCard> getByuserId(@Param("userId") Integer userId,@Param("from") Integer from,@Param("pageSize") Integer pageSize);

    int getAll(@Param("userId") Integer userId);

    /**
     * 通过卡片id查询卡片信息
     * @param id
     * @return
     */
    CreditCard getCardById(@Param("id") Integer id);

}