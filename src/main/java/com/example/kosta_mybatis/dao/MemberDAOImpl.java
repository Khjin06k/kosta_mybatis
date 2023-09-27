package com.example.kosta_mybatis.dao;

import com.example.kosta_mybatis.bean.Member;
import com.example.kosta_mybatis.util.MybatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

public class MemberDAOImpl implements MemberDAO {
    SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
    @Override
    public void insertMember(Member member) throws Exception {
        sqlSession.insert("mapper.member.insertMember", member);
        sqlSession.commit();
    }

    @Override
    public Member selectMember(String id) throws Exception {
        return sqlSession.selectOne("mapper.member.selectMember", id);
    }
}
