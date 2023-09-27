package com.example.kosta_mybatis.controller;

import com.example.kosta_mybatis.bean.Member;
import com.example.kosta_mybatis.service.MemberService;
import com.example.kosta_mybatis.service.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/join")
public class Join extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/bank/join.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String address = req.getParameter("address");

        Member member = new Member(id, name, password, email, address);

        try{
            MemberService memberService = new MemberServiceImpl();
            memberService.join(member);
            req.setAttribute("member", member);
            req.getRequestDispatcher("/bank/login.jsp").forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("err", "회원가입이 불가능합니다.");
            req.getRequestDispatcher("/bank/error.jsp").forward(req, res);
        }
    }
}