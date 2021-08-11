package com.kuang.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        //获取session
        HttpSession session = req.getSession();

        //存放数据信息
        session.setAttribute("name","qinjiang");

        //获取sessionID
        String id = session.getId();

        if(session.isNew()){
            resp.getWriter().write("session创建成功，ID:"+id);
        }else {
            resp.getWriter().write("session已经在服务器中存在了，ID:"+id);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
