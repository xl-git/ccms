package com.szit.eurekacustomermanage.service;

import com.szit.eurekacustomermanage.pojo.User;

/**
 * 用户业务逻辑层接口
 * @author 肖林
 * @version 1.0 2020-04-04
 */
public interface UserService {
    /**
     * 通过用户名或者手机号获取用户信息
     * @param userName 用户名
     * @return 返回用户实体对象
     */
    User getUserByUserName(String userName);
}
