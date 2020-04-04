package com.szit.eurekacustomermanage.mapper;

import com.szit.eurekacustomermanage.pojo.Card;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 信用卡数据访问层接口
 * @author 肖林
 * @version 1.0 2020-04-04
 */
@Repository("cardMapper")
public interface CardMapper {
    /**
     * 通过用户编号获取信用卡信息
     * @param uid 用户编号
     * @return 返回用户实体对象泛型集合
     */
    List<Card> getCardsByUid(Integer uid);
}
