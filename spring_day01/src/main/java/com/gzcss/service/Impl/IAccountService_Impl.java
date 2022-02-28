package com.gzcss.service.Impl;

import com.gzcss.dao.IAccountDao;
import com.gzcss.dao.Impl.IAccountDao_Impl;
import com.gzcss.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IAccountService_Impl implements IAccountService {

    /*private static ApplicationContext applicationConnext = new ClassPathXmlApplicationContext();*/
    private IAccountDao accountDao = new IAccountDao_Impl();
    @Override
    public void SaveAccount() {

        accountDao.userSave();
    }

    public static void test(){
        System.out.println("test static method");
    }

}
