package com.szit.eurekacustomermanage.mapper;

import com.szit.eurekacustomermanage.pojo.ContactInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 联系人信息数据访问层接口
 * @author 肖林
 * @version 1.0 2020-04-04
 */
@Repository("contactInfoMapper")
public interface ContactInfoMapper {
    ContactInfo getContactInfoByUserId(Integer userId);

    int updateEmail(@Param("email") String email,@Param("userId") Integer userId);
}
