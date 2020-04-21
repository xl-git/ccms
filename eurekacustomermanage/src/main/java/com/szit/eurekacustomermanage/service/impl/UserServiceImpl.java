package com.szit.eurekacustomermanage.service.impl;

import com.szit.eurekacustomermanage.mapper.UserMapper;
import com.szit.eurekacustomermanage.pojo.User;
import com.szit.eurekacustomermanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务逻辑层实现类
 * @author 肖林
 * @version 1.0 2020-04-04
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 通过用户名或者手机号获取用户信息
     * @param userName 用户名
     * @return 返回用户实体对象
     */
    public User getUserByUserName(String userName){
        return userMapper.getUserByUserName(userName);
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
