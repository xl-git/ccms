package com.szit.eurekamanager.service.impl;

import com.szit.eurekamanager.mapper.RMapper;
import com.szit.eurekamanager.pojo.BaseInfo;
import com.szit.eurekamanager.pojo.PageIndexer;
import com.szit.eurekamanager.pojo.Repayment;
import com.szit.eurekamanager.service.RService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 */
@Service("rService")
public class RServiceImpl implements RService {
    @Autowired
    private RMapper rMapper;

    /**
     * 获取还款记录表集合
     * @return
     */
    @Override
    public List<Repayment> getRepayments(String cardNum, String identityId, PageIndexer page){
        System.out.println(cardNum+"\t"+identityId+"\t"+page.getPageIndex());
        List<Repayment> lists=rMapper.getRepayments(cardNum,identityId,(page.getPageIndex() - 1) * page.getPageSize(),
                page.getPageSize());
        // 计算总页数
        int count = rMapper.getAll(cardNum,identityId);

        page.setPageCount((int)Math.ceil(count*1.0/page.getPageSize()));
        page.setCount(count);
        System.out.println("总记录数："+count+"\t总页数："+page.getPageCount());

        return lists;
    }

    /**
     * 通过用户id获取基本信息表集合
     * @param id
     * @return
     */
    public List<BaseInfo> getBaseInfosByid(Integer id){
        return rMapper.getBaseInfosByid(id);
    }
}
