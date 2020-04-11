package com.szit.eurekacustomermanage.service;

import com.szit.eurekacustomermanage.pojo.CreditCardInfo;

/**
 * 信用卡基本信息业务逻辑层接口
 * @author 肖林
 * @version 1.0 2020-04-11
 */
public interface CreditCardInfoService {
    /**
     * 通过证件号获取信用卡基本信息
     * @param certificatenum 证件号
     * @return 返回信用卡基本信息实体对象
     */
    CreditCardInfo getCreditCardInfoByCertificateNum(String certificatenum);
}
