package com.szit.eurekacustomermanage.service.impl;

import com.szit.eurekacustomermanage.mapper.BaseInfoMapper;
import com.szit.eurekacustomermanage.pojo.BaseInfo;
import com.szit.eurekacustomermanage.service.BaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 信用卡基本信息业务逻辑层实现类
 * @author 肖林
 * @version 1.0 2020-04-11
 */
@Service("baseInfoService")
public class BaseInfoServiceImpl implements BaseInfoService {
    @Autowired
    private BaseInfoMapper baseInfoMapper;

    @Override
    public BaseInfo getBaseInfoByIdentityCard(String identityCard) {
        return baseInfoMapper.getBaseInfoByIdentityCard(identityCard);
    }

    public BaseInfoMapper getBaseInfoMapper() {
        return baseInfoMapper;
    }

    public void setBaseInfoMapper(BaseInfoMapper baseInfoMapper) {
        this.baseInfoMapper = baseInfoMapper;
    }
}
