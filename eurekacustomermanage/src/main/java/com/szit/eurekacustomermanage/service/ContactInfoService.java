package com.szit.eurekacustomermanage.service;

import com.szit.eurekacustomermanage.pojo.ContactInfo;

/**
 * 联系人信息业务逻辑层接口
 * @author 肖林
 * @version 1.0 2020-04-04
 */
public interface ContactInfoService {
    ContactInfo getContactInfoByUserId(Integer userId);

    boolean updateEmail(String email, Integer userId);
}
