package com.szit.eurekacustomermanage.mapper;

import com.szit.eurekacustomermanage.pojo.CreditCard;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 信用卡数据访问层接口
 * @author 肖林
 * @version 1.0 2020-04-04
 */
@Repository("creditCardMapper")
public interface CreditCardMapper {
    /**
     * 通过用户编号获取信用卡信息
     * @param userId 用户编号
     * @return 返回信用卡实体对象
     */
    List<CreditCard> getCreditCardsByUserId(@Param("userId") Integer userId,@Param("from") Integer from,@Param("pageSize") Integer pageSize);

    int getAllCreditCards(@Param("userId") Integer userId);
}
