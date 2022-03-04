package com.gzcss.service.impl;

import com.gzcss.dao.IAccountDao;
import com.gzcss.domain.Account;
import com.gzcss.service.IAccountService;
import com.gzcss.util.TransactionManager;

import java.util.List;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService{

    private IAccountDao accountDao;
    private TransactionManager transactionManager;


    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        try {
            //1、开启事务
            transactionManager.begintransaction();
            //2、执行操作
             List<Account> accounts = accountDao.findAllAccount();
            //3、提交事务
            transactionManager.commit();
            //4、返回结果
            return accounts;

        }catch (Exception e){
            //5、出现异常回滚事务
            return null;

        }finally {
            //6、无论如何使用后都要释放资源
            transactionManager.release();
        }

    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer acccountId) {
        accountDao.deleteAccount(acccountId);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {

        try {
            //1、开启事务
            transactionManager.begintransaction();
            //2、执行操作
            //1、根据用户名称查询转出账户
            Account source = accountDao.findAccountByName(sourceName);
            //2、根据用户名称查询转入账号
            Account targe = accountDao.findAccountByName(targetName);
            //3、转出账户减钱
            source.setMoney(source.getMoney() - money);
            //4、转入账户加钱
            targe.setMoney(targe.getMoney() + money);
            //5、更新转出账户
            accountDao.updateAccount(source);
            int i = 2/0;
            //6、更新转入账户
            accountDao.updateAccount(targe);
            //3、提交事务
            transactionManager.commit();
            //4、返回结果
            System.out.println("事务提交完成");

        }catch (Exception e){
            //5、出现异常回滚事务
            System.out.println("事务异常");
            transactionManager.rollback();
            throw new RuntimeException(e);


        }finally {
            //6、无论如何使用后释放资源
            transactionManager.release();
        }

    }
}
