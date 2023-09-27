package com.example.kosta_mybatis.service;

import com.example.kosta_mybatis.bean.Account;

import java.util.List;

public interface AccountService {
    void makeAccount(Account acc) throws Exception;
    Account accountInfo(String id) throws Exception;
    void deposit(String id, Integer money)throws Exception;
    void withdraw(String id, Integer money)throws Exception;
    List<Account> allAccountInfo() throws Exception;
}
