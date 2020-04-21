package com.szit.eurekastaging.service.impl;

import com.szit.eurekastaging.mapper.UserMapper;
import com.szit.eurekastaging.pojo.User;
import com.szit.eurekastaging.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper usermapper;

    /**
     * 通过用户名或者手机号获取用户信息
     * @param userName 用户名
     * @param telphone 手机号
     * @return 返回用户实体对象
     */

    public User getUserByUserNameOrTelphone(String userName, String telphone) {
        return usermapper.getUserByUserNameOrTelphone(userName,telphone);
    }

    public UserMapper getUsermapper() {
        return usermapper;
    }

    public void setUsermapper(UserMapper usermapper) {
        this.usermapper = usermapper;
    }



}
