package com.szit.eurekauser.service;

import com.szit.eurekauser.pojo.User;

/**
 * 用户业务逻辑层接口
 *  @author  刘成发
 *  @version 1.0 2020.04.05
 */
public interface UserService {
    /**
     * 用户注册
     * @param user 用户实体对象
     * @return 返回注册是否成功
     */
    boolean register(User user);

    /**
     * 用户登录
     * @param user 用户实体对象
     * @return 返回登录是否成功
     */
    boolean userLogin(User user);

    /**
     * 判断手机号是否存在
     * @param telphone 手机号
     * @return
     */
    User searchBytelphone(String telphone);

    /**
     * 判断用户名是否存在
     * @param userName 用户名
     * @return
     */
    boolean searchByUserName(String userName);

    /**
     * 修改用户信息
     * @param user 用户实体对象
     * @return
     */
    boolean update(User user);


}
