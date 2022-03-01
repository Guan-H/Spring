package com.gzcss.test;

import com.gzcss.config.SpringConfiguration;
import com.gzcss.domain.Account;
import com.gzcss.service.IAccountService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import javax.swing.*;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = SpringConfiguration.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class accountTest {

    @Autowired
    private IAccountService accountService;



    @Test
    public void findAllTest() {
        List<Account> all = accountService.findAll();
        for (Account ac: all) {
            System.out.println(ac);
        }
    }

    @Test
    public void findOne() {
        Account one = accountService.findById(3);
        System.out.println(one);
    }


    @Test
    public void savaTest() {
        Account ac =new Account();
        ac.setName("大石页");
        ac.setMoney(1000F);
        accountService.saveAccount(ac);

    }

    @Test
    public void updateTest() {
        Account ac = new Account();
        ac.setId(3);
        ac.setName("小石页");
        ac.setMoney(2000F);
        accountService.updateAccount(ac);
    }

    @Test
    public void deleteTest() {
        accountService.deleteAccount(3);
    }
}
