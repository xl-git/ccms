package com.szit.eurekastaging.service.impl;

import com.szit.eurekastaging.mapper.UserMapper;
import com.szit.eurekastaging.pojo.User;
import com.szit.eurekastaging.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getByuserName(String userName) {
        return userMapper.getByuserName(userName);
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
