package com.example.kosta_mybatis.dao;

import com.example.kosta_mybatis.bean.Account;
import com.example.kosta_mybatis.util.MybatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AccountDAOImpl implements AccountDAO{

    // DB를 읽어옴
    SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();

    @Override
    public void insertAccount(Account acc) throws Exception {
        // 아래 이름은 Account.xml의 nameSpace와 동일하게 작성해야
        // mapper.Account라는 nameSpace를 가진 것 아래에 있는 insertAccount를 가져온다는 것
        sqlSession.insert("mapper.account.insertAccount", acc);
        sqlSession.commit();
    }

    @Override
    public Account selectAccount(String id) throws Exception {
        return sqlSession.selectOne("mapper.account.selectAccount", id);
    }

    @Override
    public void updateBalance(Account acc) {
        sqlSession.update("mapper.account.updateBalance", acc);
        sqlSession.commit();
    }

    @Override
    public List<Account> selectAccountList() {
        return sqlSession.selectList("mapper.account.selectAccountList");
    }
}
