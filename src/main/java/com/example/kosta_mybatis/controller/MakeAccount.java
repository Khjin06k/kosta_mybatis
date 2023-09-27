package com.example.kosta_mybatis.controller;

import com.example.kosta_mybatis.bean.Account;
import com.example.kosta_mybatis.service.AccountService;
import com.example.kosta_mybatis.service.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/makeAccount")
public class MakeAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/bank/makeAccount.jsp").forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        Integer balance = Integer.parseInt(req.getParameter("money"));
        String type = req.getParameter("type");
        String grade = req.getParameter("grade");

        Account acc = new Account(id, name, balance, type, grade);
        try{
            AccountService accountService = new AccountServiceImpl();
            accountService.makeAccount(acc);
            req.setAttribute("acc", acc);
            req.getRequestDispatcher("/bank/accountInfo.jsp").forward(req, res);
        }catch (Exception e){
            e.printStackTrace();
            req.setAttribute("err", "계좌 개설 실패");
            req.getRequestDispatcher("/bank/error.jsp").forward(req, res);
        }

    }
}