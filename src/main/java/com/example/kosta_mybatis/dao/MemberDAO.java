package com.example.kosta_mybatis.dao;

import com.example.kosta_mybatis.bean.Member;

public interface MemberDAO {
    void insertMember(Member member) throws Exception;
    Member selectMember(String id) throws Exception;
}
