package com.gzcss.dao.Impl;

import com.gzcss.dao.IAccountDao;
import com.gzcss.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class IAccountDaoImpl implements IAccountDao {

    private QueryRunner queryRunner;


    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    @Override
    public List<Account> findAll() {

        try {
         return   queryRunner.query("select * from account",new BeanListHandler<Account>(Account.class));
        }catch (Exception e){
            throw  new RuntimeException(e);
        }

    }

    @Override
    public Account findById(Integer id) {
        try {
            return   queryRunner.query("select * from account where id = ?",new BeanHandler<Account>(Account.class),id);
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            queryRunner.update("insert into account(?,?) values(?,?)",account.getName(),account.getMoney());
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            queryRunner.update("update account set name = ?,money = ? where id = ?",account.getName(),account.getMoney(),account.getId());
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccount(Integer id) {
        try {
            queryRunner.update("delete from account where id = ?",id);
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }
}
