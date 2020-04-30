package com.szit.eurekastaging.mapper;

import com.szit.eurekastaging.pojo.User;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户分期数据访问层接口
 * @author 刘志强
 * @version 1.0 2020-4-20
 */
@Repository("userMapper")
public interface UserMapper {

    /**
     * 通过用户名查看用户信息
     * @param userName
     * @return
     */

    User getByuserName(@Param("userName") String userName);
}
