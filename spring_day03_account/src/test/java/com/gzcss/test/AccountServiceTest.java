package com.gzcss.test;

import com.gzcss.domain.Account;
import com.gzcss.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试：测试我们的配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    private  IAccountService as;

    @Test
    public void Test() {
        /*ApplicationContext ap = new ClassPathXmlApplicationContext("bean.xml");
        as = ap.getBean("accountService",IAccountService.class);*/
        as.transfer("bbb","aaa",100F);

       /* List<Account> allAccount = as.findAllAccount();
        for (Account as : allAccount){
            System.out.println(as);
        }*/
    }
}
