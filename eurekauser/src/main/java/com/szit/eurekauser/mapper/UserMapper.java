package com.szit.eurekauser.mapper;

import com.szit.eurekauser.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * 用户数据访问层接口
 *  @author  刘成发
 *  @version 1.0 2020.04.05
 */
@Repository("userMapper")
public interface UserMapper {

    /**
     * 通过手机号查询用户信息
     * @param telphone 手机号
     * @return 返回用户实体对象
     */
    User getUserBytelphone(String telphone);

    /**
     * 通过用户名查询用户信息
     * @param userName 用户名
     * @return 返回用户实体对象
     */
    User getUserByUserName(String userName);

    /**
     * 添加用户信息
     * @param user 用户实体对象
     * @return 返回是否添加成功
     */
    boolean addUser(User user);

    /**
     * 修改用户信息
     * @param user 用户实体对象
     * @return 返回是否添加成功
     */
    boolean updateUser(User user);

}
