package com.szit.eurekacustomermanage.mapper;

import com.szit.eurekacustomermanage.pojo.BaseInfo;
import org.springframework.stereotype.Repository;

/**
 * 信用卡基本信息数据访问层接口
 * @author 肖林
 * @version 1.0 2020-04-11
 */
@Repository("baseInfoMapper")
public interface BaseInfoMapper {
    BaseInfo getBaseInfoByIdentityCard(String identityCard);
}
