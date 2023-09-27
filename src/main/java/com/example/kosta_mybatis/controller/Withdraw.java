package com.example.kosta_mybatis.controller;

import com.example.kosta_mybatis.service.AccountService;
import com.example.kosta_mybatis.service.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/withdraw")
public class Withdraw extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/bank/withdraw.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String id = req.getParameter("id");
        Integer money = Integer.parseInt(req.getParameter("money"));

        try{
            AccountService accountService = new AccountServiceImpl();
            accountService.withdraw(id, money);
            res.sendRedirect("accountInfo");
        }catch (Exception e){
            e.printStackTrace();
            req.setAttribute("err", e.getMessage());
            req.getRequestDispatcher("/bank/error.jsp").forward(req, res);
        }
    }
}