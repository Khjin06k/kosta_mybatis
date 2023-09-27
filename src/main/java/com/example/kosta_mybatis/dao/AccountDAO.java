package com.example.kosta_mybatis.dao;

import com.example.kosta_mybatis.bean.Account;

import java.util.List;

// 상속을 받아 구현을 하는 상태로 만들기 때문에 인터페이스 형태로 가져감 (조금 더 확장성 있게 사용)
public interface AccountDAO {
    void insertAccount(Account acc) throws Exception;
    Account selectAccount(String id) throws Exception;
    void updateBalance(Account acc) throws Exception;
    List<Account> selectAccountList() throws Exception;
}
