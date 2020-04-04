package com.szit.eurekacustomermanage.mapper;

import com.szit.eurekacustomermanage.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * 用户数据访问层接口
 * @author 肖林
 * @version 1.0 2020-04-04
 */
@Repository("userMapper")
public interface UserMapper {
    /**
     * 通过用户名或者手机号获取用户信息
     * @param userName 用户名
     * @param telphone 手机号
     * @return 返回用户实体对象
     */
    User getUserByUserNameOrTelphone(String userName, String telphone);
}
