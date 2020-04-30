package com.szit.eurekaaccountmanage.service;

import com.szit.eurekaaccountmanage.pojo.User;

public interface UserService {

    /**
     * 根据用户名查询用户信息
     * @return 用户实体类对象
     */
    User getUserByUserName(String userName);
}
