package com.szit.eurekacustomermanage.service.impl;

import com.szit.eurekacustomermanage.mapper.OpenStatusMapper;
import com.szit.eurekacustomermanage.pojo.OpenStatus;
import com.szit.eurekacustomermanage.pojo.PageIndexer;
import com.szit.eurekacustomermanage.service.OpenStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 申请卡状态业务逻辑层接口实现类
 * @author 肖林
 * @version 1.0 2020-04-04
 */
@Service("openStatusService")
public class OpenStatusServiceImpl implements OpenStatusService {
    @Autowired
    private OpenStatusMapper openStatusMapper;

    @Override
    public List<OpenStatus> getOpenStatusByUserId(Integer userId, PageIndexer page) {
        List<OpenStatus> lists=openStatusMapper.getOpenStatusByUserId(userId,(page.getPageIndex() - 1) * page.getPageSize(),
                page.getPageSize());
        // 计算总页数
        int count = openStatusMapper.getAllOpenStatus(userId);

        page.setPageCount((int)Math.ceil(count*1.0/page.getPageSize()));
        page.setCount(count);

        return lists;
    }

    public OpenStatusMapper getOpenStatusMapper() {
        return openStatusMapper;
    }

    public void setOpenStatusMapper(OpenStatusMapper openStatusMapper) {
        this.openStatusMapper = openStatusMapper;
    }
}
