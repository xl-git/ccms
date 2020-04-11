package com.szit.eurekacustomermanage.service.impl;

import com.szit.eurekacustomermanage.mapper.CreditCardInfoMapper;
import com.szit.eurekacustomermanage.pojo.CreditCardInfo;
import com.szit.eurekacustomermanage.service.CreditCardInfoService;
import org.springframework.stereotype.Service;

/**
 * 信用卡基本信息业务逻辑层实现类
 * @author 肖林
 * @version 1.0 2020-04-11
 */
@Service("creditCardInfoService")
public class CreditCardInfoServiceImpl implements CreditCardInfoService {
    private CreditCardInfoMapper creditCardInfoMapper;
    /**
     * 通过证件号获取信用卡基本信息
     * @param certificatenum 证件号
     * @return 返回信用卡基本信息实体对象
     */
    @Override
    public CreditCardInfo getCreditCardInfoByCertificateNum(String certificatenum) {
        return creditCardInfoMapper.getCreditCardInfoByCertificateNum(certificatenum);
    }

    public CreditCardInfoMapper getCreditCardInfoMapper() {
        return creditCardInfoMapper;
    }

    public void setCreditCardInfoMapper(CreditCardInfoMapper creditCardInfoMapper) {
        this.creditCardInfoMapper = creditCardInfoMapper;
    }
}
