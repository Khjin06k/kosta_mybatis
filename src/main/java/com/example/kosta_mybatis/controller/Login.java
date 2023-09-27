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

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/bank/login.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String id = req.getParameter("id");
        String password = req.getParameter("password");

        try{
            MemberService memberService = new MemberServiceImpl();
            Member member = memberService.login(id);
            req.setAttribute("user", member);
            req.getRequestDispatcher("/bank/makeAccount.jsp").forward(req, res);
        }catch (Exception e){
            e.printStackTrace();;
            req.setAttribute("err", "아이디 또는 비밀번호가 잘못되었습니다.");
            req.getRequestDispatcher("/bank/error.jsp").forward(req, res);

        }
    }
}