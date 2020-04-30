package com.szit.eurekaaccountmanage.service.impl;

import com.szit.eurekaaccountmanage.mapper.UserMapper;
import com.szit.eurekaaccountmanage.pojo.User;
import com.szit.eurekaaccountmanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User getUserByUserName(String userName) {
        return userMapper.getUserByUserName(userName);
    }
}
