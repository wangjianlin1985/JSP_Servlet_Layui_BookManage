package com.dreambamboo.controller;

import com.dreambamboo.entities.BookAdmin;
import com.dreambamboo.entities.Reader;
import com.dreambamboo.service.AccountService;
import com.dreambamboo.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
 * @Author:dreambamboo
 * @Description:用户登录功能类 
 * @Date:2019/1/11 10:39
 * @Param:
 * @return:
 */
public class AccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        String type = req.getParameter("type");
        AccountService accountService = new AccountServiceImpl();
        HttpSession session = req.getSession();
        switch (method){
            case "login":
                String username = req.getParameter("username");
                String password = req.getParameter("password");
                Object object = accountService.login(username,password,type);
                if (object != null){
                    switch (type){
                        case "reader":
                            Reader reader = (Reader) object;
                            session.setAttribute("reader",reader);
                            resp.sendRedirect(req.getContextPath()+"/reader/reader.jsp");
                            break;
                        case "bookadmin":
                            BookAdmin bookAdmin = (BookAdmin) object;
                            session.setAttribute("bookAdmin",bookAdmin);
                            resp.sendRedirect(req.getContextPath()+"/admin.jsp");
                            break;
                    }
                } else {
                    resp.sendRedirect(req.getContextPath()+"/login.jsp");
                }
                break;
            case "logout":
                session.invalidate();
                resp.sendRedirect("login.jsp");
                break;

        }
    }
}
