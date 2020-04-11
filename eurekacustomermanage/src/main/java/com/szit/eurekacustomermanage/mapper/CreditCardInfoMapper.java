package com.szit.eurekacustomermanage.mapper;

import com.szit.eurekacustomermanage.pojo.CreditCardInfo;
import org.springframework.stereotype.Repository;

/**
 * 信用卡基本信息数据访问层接口
 * @author 肖林
 * @version 1.0 2020-04-11
 */
@Repository("creditCardInfoMapper")
public interface CreditCardInfoMapper {
    /**
     * 通过证件号获取信用卡基本信息
     * @param certificatenum 证件号
     * @return 返回信用卡基本信息实体对象
     */
    CreditCardInfo getCreditCardInfoByCertificateNum(String certificatenum);
}
