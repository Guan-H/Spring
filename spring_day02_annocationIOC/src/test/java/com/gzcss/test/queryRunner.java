package com.gzcss.test;

import com.gzcss.config.SpringConfiguration;
import com.gzcss.domain.Account;
import com.gzcss.service.IAccountService;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class queryRunner {

    private ApplicationContext as ;
    private IAccountService accountService;

    @Before
    public void init(){
        //as = new ClassPathXmlApplicationContext("bean.xml");
        as = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        accountService = as.getBean("accountService", IAccountService.class);
    };


    @Test
    public void testQueryrunner(){
        QueryRunner queryRunner = as.getBean("queryRunner",QueryRunner.class);
        QueryRunner queryRunner1 = as.getBean("queryRunner",QueryRunner.class);
        System.out.println(queryRunner1 == queryRunner);
    }

    @Test
    public void findAllTest() {
        List<Account> all = accountService.findAll();
        for (Account ac: all) {
            System.out.println(ac);
        }
    }

    public void savaTest() {
        Account ac =new Account();
        ac.setName("大石页");
        ac.setMoney(1000F);
        accountService.saveAccount(ac);

    }

}
