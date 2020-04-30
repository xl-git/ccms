package com.szit.eurekacustomermanage.service.impl;

import com.szit.eurekacustomermanage.mapper.ContactInfoMapper;
import com.szit.eurekacustomermanage.pojo.ContactInfo;
import com.szit.eurekacustomermanage.service.ContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 联系人信息业务逻辑层接口实现类
 * @author 肖林
 * @version 1.0 2020-04-04
 */
@Service("contactInfoService")
public class ContactInfoServiceImpl implements ContactInfoService {
    @Autowired
    private ContactInfoMapper contactInfoMapper;

    @Override
    public ContactInfo getContactInfoByUserId(Integer userId) {
        return contactInfoMapper.getContactInfoByUserId(userId);
    }

    @Override
    public boolean updateEmail(String email, Integer userId) {
        boolean isUpdate=true;
        if(contactInfoMapper.updateEmail(email,userId)!=1){
            isUpdate=false;
        }
        return isUpdate;
    }

    public ContactInfoMapper getContactInfoMapper() {
        return contactInfoMapper;
    }

    public void setContactInfoMapper(ContactInfoMapper contactInfoMapper) {
        this.contactInfoMapper = contactInfoMapper;
    }
}
