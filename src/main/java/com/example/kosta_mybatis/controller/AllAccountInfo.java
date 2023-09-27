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
import java.util.List;

@WebServlet("/allAccountInfo")
public class AllAccountInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try{
            AccountService accountService = new AccountServiceImpl();
            List<Account> accs = accountService.allAccountInfo();
            req.setAttribute("accs", accs);
            req.getRequestDispatcher("/bank/allAccountInfo.jsp").forward(req, res);
        }catch (Exception e){
            e.printStackTrace();
            req.setAttribute("err", "전체계좌 조회 실패");
            req.getRequestDispatcher("/bank/error.jsp").forward(req, res);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}