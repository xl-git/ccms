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
     * @return 返回信用卡实体对象
     */
    Card getCardByUid(Integer uid);

    /**
     * 通过信用卡基本信息编号获取信用卡信息
     * @param ccid 信用卡基本信息编号
     * @return 返回信用卡实体对象
     */
    Card getCardByCcid(Integer ccid);

    /**
     * 修改Email
     * @param card 信用卡实体类
     * @return 返回是否修改成功
     */
    int updateEmail(Card card);
}
