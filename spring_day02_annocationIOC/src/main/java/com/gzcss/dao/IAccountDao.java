package com.gzcss.dao;

import com.gzcss.domain.Account;

import java.util.List;

public interface IAccountDao {

    List<Account> findAll();

    Account findById(Integer id);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer id);



}
