package com.szit.eurekamanager.service.impl;

import com.szit.eurekamanager.mapper.AdminMapper;
import com.szit.eurekamanager.pojo.*;
import com.szit.eurekamanager.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public boolean adminLogin(Admin admin) {
        boolean isLogin=false;
        Admin returnAdmin=adminMapper.getAdminByadminName(admin.getAdminName());
        if(returnAdmin.getAdminPwd().equals(admin.getAdminPwd())){
            admin.setGrade(returnAdmin.getGrade());
            isLogin=true;
        }
        return isLogin;
    }

    @Override
    public CreditCard searchCard(String cnum) {
        return adminMapper.getCardByCardNum(cnum);
    }

    @Override
    public boolean updatePwd(CreditCard card) {
        boolean isUpdate =false ;
        if(adminMapper.updatePwd(card)==1){
            isUpdate = true;
        }
        return isUpdate;
    }

    @Override
    public boolean updateUnit(UnitInfo unitInfo, CreditCard card) {
        boolean isUpdate =false ;
        if(adminMapper.updateUnit(unitInfo.getUnitAddress(),unitInfo.getUnitIphone(),card.getCardNum())==1){
            isUpdate = true;
        }
        return isUpdate;
    }

    @Override
    public boolean updateBaseInfo(BaseInfo baseInfo, CreditCard card) {
        boolean isUpdate =false ;
        if(adminMapper.updateBaseInfo(baseInfo.getIphoneNum(),baseInfo.getEducation(),
                baseInfo.getHomeAddress(),baseInfo.getFamilyAddress(),card.getCardNum())==1){
            isUpdate = true;
        }
        return isUpdate;
    }

    @Override
    public boolean updateEmail(String email, String cardNum) {
        boolean isUpdate =false ;
        if(adminMapper.updateEmail(email,cardNum)==1){
            isUpdate = true;
        }
        return isUpdate;
    }

    @Override
    public List<CreditCard> searchCardByIdentityCard(String identityCard,PageIndexer page) {
        List<CreditCard> lists = adminMapper.getCardByIdentityCard(identityCard, (page.getPageIndex() - 1) * page.getPageSize(), page.getPageSize());

        // 计算总页数
        int count = adminMapper.getCounts(identityCard);
        page.setPageCount((int)Math.ceil(count*1.0/page.getPageSize()));
        page.setCount(count);
        return lists;
    }

    @Override
    public boolean loseHandle(String cardNum) {
        return adminMapper.loseHandle(cardNum);
    }

    @Override
    public boolean freeze(String cardNum) {
        return adminMapper.freeze(cardNum);
    }

    @Override
    public boolean cancel(String cardNum) {
        return adminMapper.cancel(cardNum);
    }

    @Override
    public boolean relieve(String cardNum) {
        return adminMapper.relieve(cardNum);
    }

    @Override
    public List<Noactivate> ActivateLists(PageIndexer page) {
        List<Noactivate> lists = adminMapper.getActivateLists((page.getPageIndex() - 1) * page.getPageSize(), page.getPageSize());
        // 计算总页数
        int count = adminMapper.getActivateCounts();
        page.setPageCount((int)Math.ceil(count*1.0/page.getPageSize()));
        page.setCount(count);

        return lists;
    }
}
