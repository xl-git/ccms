package com.szit.eurekacustomermanage.service;

import com.szit.eurekacustomermanage.pojo.OpenStatus;
import com.szit.eurekacustomermanage.pojo.PageIndexer;

import java.util.List;

/**
 * 申请卡状态业务逻辑层接口
 * @author 肖林
 * @version 1.0 2020-04-04
 */
public interface OpenStatusService {
    List<OpenStatus> getOpenStatusByUserId(Integer userId, PageIndexer page);
}
