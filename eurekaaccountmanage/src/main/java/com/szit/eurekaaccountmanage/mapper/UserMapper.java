package com.szit.eurekaaccountmanage.mapper;

import com.szit.eurekaaccountmanage.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserMapper {

    User getUserByUserName(@Param("userName") String userName);
}

