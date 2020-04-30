package com.szit.eurekacustomermanage.service;

import com.szit.eurekacustomermanage.pojo.BaseInfo;

/**
 * 信用卡基本信息业务逻辑层接口
 * @author 肖林
 * @version 1.0 2020-04-11
 */
public interface BaseInfoService {
    BaseInfo getBaseInfoByIdentityCard(String identityCard);
}
