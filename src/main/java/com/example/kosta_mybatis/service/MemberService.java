package com.example.kosta_mybatis.service;

import com.example.kosta_mybatis.bean.Member;

public interface MemberService {
    void join(Member member) throws Exception;

    Member login(String id) throws Exception;
}
