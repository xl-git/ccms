package com.szit.eurekastaging.service.impl;

import com.szit.eurekastaging.mapper.ChangePeriodsMapper;
import com.szit.eurekastaging.pojo.ChangePeriods;
import com.szit.eurekastaging.pojo.PageIndexer;
import com.szit.eurekastaging.service.ChangePeriodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("changePeriodsService")
public class ChangePeriodsServiceImpl implements ChangePeriodsService {
    @Autowired
    private ChangePeriodsMapper changePeriodsMapper;

    @Override
    public int addChangePeriods(ChangePeriods changePeriods) {
        switch (changePeriods.getPeriodsId()){
            case 1 :
                changePeriods.setRate(0.0195);
                break;
            case 2:
                changePeriods.setRate(0.036);
                break;
            case 3:
                changePeriods.setRate(0.072);
                break;
        }
        changePeriods.setChangeStatus(1);
        changePeriods.setChangeDate(new Date());
        int flag=changePeriodsMapper.addChangePeriods(changePeriods);
        return flag;
    }

    @Override
    public List<ChangePeriods> getChangePeriodsBychangeDate(Date changeDate) {
        return changePeriodsMapper.getChangePeriodsBychangeDate(changeDate);
    }


    public List<ChangePeriods> getChangePeriodsBycardId(Integer userId, Date lowdate, Date highdate, PageIndexer page) {
        List<ChangePeriods> lists=changePeriodsMapper.getChangePeriodsBycardId(userId,lowdate,highdate,(page.getPageIndex() - 1) * page.getPageSize(),page.getPageSize());
        // 计算总页数
        int count = changePeriodsMapper.getCounts(userId,lowdate,highdate);

        page.setPageCount((int)Math.ceil(count*1.0/page.getPageSize()));
        page.setCount(count);

        return lists;
    }


}
