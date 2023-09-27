package com.example.kosta_mybatis.service;

import com.example.kosta_mybatis.bean.Account;
import com.example.kosta_mybatis.dao.AccountDAO;
import com.example.kosta_mybatis.dao.AccountDAOImpl;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    private AccountDAO accountDao;

    public AccountServiceImpl(){
        accountDao = new AccountDAOImpl();
    }

    @Override
    public void makeAccount(Account acc) throws Exception {
       accountDao.insertAccount(acc);
    }

    @Override
    public Account accountInfo(String id) throws Exception {
        return accountDao.selectAccount(id);
    }

    @Override
    public void deposit(String id, Integer money) throws Exception {
        // 계좌번호 조회
        Account acc = accountDao.selectAccount(id);
        if(acc == null) throw new Exception("계좌번호 오류");
        acc.deposit(money);
        accountDao.updateBalance(acc);
    }

    @Override
    public void withdraw(String id, Integer money) throws Exception {
    // 계좌번호 조회
        Account acc = accountDao.selectAccount(id);
        if(acc == null) throw new Exception("계좌번호 오류");
        acc.withdraw(money);
        accountDao.updateBalance(acc);
    }

    @Override
    public List<Account> allAccountInfo() throws Exception {
        return accountDao.selectAccountList();
    }
}
