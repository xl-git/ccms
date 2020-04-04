package com.szit.eurekacustomermanage.service;

import com.szit.eurekacustomermanage.pojo.Card;

import java.util.List;

/**
 * 信用卡业务逻辑层接口
 * @author 肖林
 * @version 1.0 2020-04-04
 */
public interface CardService {
    /**
     * 通过用户编号获取信用卡信息
     * @param uid 用户编号
     * @return 返回用户实体对象泛型集合
     */
    List<Card> getCardsByUid(Integer uid);
}
