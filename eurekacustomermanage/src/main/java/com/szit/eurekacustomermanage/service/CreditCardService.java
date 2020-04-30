package com.szit.eurekacustomermanage.service;

import com.szit.eurekacustomermanage.pojo.CreditCard;
import com.szit.eurekacustomermanage.pojo.PageIndexer;

import java.util.List;

/**
 * 信用卡业务逻辑层接口
 * @author 肖林
 * @version 1.0 2020-04-04
 */
public interface CreditCardService {
    /**
     * 通过用户编号获取信用卡信息
     * @param userId 用户编号
     * @return 返回信用卡实体对象
     */
    List<CreditCard> getCreditCardsByUserId(Integer userId, PageIndexer page);



}
