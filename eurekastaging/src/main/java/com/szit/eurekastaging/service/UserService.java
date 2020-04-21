package com.szit.eurekastaging.service;

import com.szit.eurekastaging.pojo.User;

/**
 * 用户业务访问层接口
 * @author 刘志强
 * @version 1.0 2020-04-20
 */
public interface UserService {

    /**
     * 通过用户名或者手机号获取用户信息
     * @param userName 用户名
     * @param telphone 手机号
     * @return 返回用户实体对象
     */
    User getUserByUserNameOrTelphone(String userName, String telphone);
}
