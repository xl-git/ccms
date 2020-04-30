package com.szit.eurekacustomermanage.mapper;

import com.szit.eurekacustomermanage.pojo.OpenStatus;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 申请卡状态数据访问层接口
 * @author 肖林
 * @version 1.0 2020-04-04
 */
@Repository("openStatusMapper")
public interface OpenStatusMapper {
    List<OpenStatus> getOpenStatusByUserId(@Param("userId") Integer userId,@Param("from") Integer from,@Param("pageSize") Integer pageSize);

    int getAllOpenStatus(@Param("userId") Integer userId);
}
