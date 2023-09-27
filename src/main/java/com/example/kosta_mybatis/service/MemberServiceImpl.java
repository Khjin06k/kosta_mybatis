package com.example.kosta_mybatis.service;

import com.example.kosta_mybatis.bean.Member;
import com.example.kosta_mybatis.dao.MemberDAO;
import com.example.kosta_mybatis.dao.MemberDAOImpl;

public class MemberServiceImpl implements MemberService {
    private MemberDAO memberDAO;

    public MemberServiceImpl(){
        memberDAO = new MemberDAOImpl();
    }

    @Override
    public void join(Member member) throws Exception {
        memberDAO.insertMember(member);
    }

    @Override
    public Member login(String id) throws Exception {
        return memberDAO.selectMember(id);
    }
}
