package com.kh.servlet;

import com.kh.dao.MessageDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "update", value = "/update.proc")
public class Update extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nickname = request.getParameter("nickname");
        String msg = request.getParameter("msg");

        System.out.println(nickname + " : " + msg);
        MessageDAO messageDAO = new MessageDAO();

        try {
            int rs = messageDAO.updateMessage(nickname, msg);
            if(rs>0) response.sendRedirect("/toOutput.proc");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
