package com.gzcss.test;

import com.gzcss.domain.Account;
import com.gzcss.service.IAccountService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class accountTest {



    private ClassPathXmlApplicationContext as ;
    private IAccountService accountService;

    @Before
    public void init(){
        as = new ClassPathXmlApplicationContext("bean.xml");
        accountService = as.getBean("accountService", IAccountService.class);
    };

    @After
    public void close(){
        as.close();
    };


    @Test
    public void findAllTest() {

        List<Account> all = accountService.findAll();
        for (Account ac: all) {
            System.out.println(ac);
        }
    }

    @Test
    public void findOne() {
       accountService.findById(3);
    }


    @Test
    public void savaTest() {
        Account ac =new Account();
        ac.setName("大石页");
        ac.setMoney(1000.10);
        accountService.saveAccount(ac);

    }

    @Test
    public void updateTest() {
        Account ac = new Account();
        ac.setId(3);
        ac.setName("小石页");
        ac.setMoney(2000.20);
        accountService.updateAccount(ac);
    }

    @Test
    public void deleteTest() {
        accountService.deleteAccount(3);
    }
}
