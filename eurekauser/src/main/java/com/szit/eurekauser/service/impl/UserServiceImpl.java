package com.szit.eurekauser.service.impl;

import com.szit.eurekauser.mapper.UserMapper;
import com.szit.eurekauser.pojo.User;
import com.szit.eurekauser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务逻辑层实现类
 *  @author  刘成发
 *  @version 1.0 2020.04.05
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册
     * @param user 用户实体对象
     * @return 返回是否注册成功
     */
    @Override
    public boolean register(User user) {
        boolean isRegister=true;
        try {
            userMapper.addUser(user);
            isRegister=false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return isRegister;
    }

    /**
     * 用户登录
     * @param user 用户实体对象
     * @return 返回是否登录成功
     */
    @Override
    public boolean userLogin(User user) {
        boolean isLogin=false;
        User returnUser =userMapper.getUserByUserName(user.getUserName());
        if(returnUser!=null){
            if(user.getuPassword().equals(returnUser.getuPassword())) {
                user.setLoginDate(returnUser.getLoginDate());
                isLogin=true;
            }
        }
        return isLogin;
    }

    /**
     * 判断手机号是否存在
     * @param telphone 手机号
     * @return
     */
    @Override
    public User searchBytelphone(String telphone) {
        return userMapper.getUserBytelphone(telphone);
    }

    @Override
    public boolean searchByUserName(String userName) {
        boolean isExistUserName=true;
        User user=userMapper.getUserByUserName(userName);
        if(user==null){
            isExistUserName=false;
        }
        return isExistUserName;
    }

    @Override
    public boolean update(User user) {
        return userMapper.updateUser(user);
    }
}
