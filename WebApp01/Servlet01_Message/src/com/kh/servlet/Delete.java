package com.kh.servlet;

import com.kh.dao.MessageDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "delete", value = "/delete.proc")
public class Delete extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request 에 대한 인코딩 설정
        request.setCharacterEncoding("utf-8");
        String nickname = request.getParameter("nickname");
        System.out.println("del: " + nickname);
        MessageDAO messageDAO = new MessageDAO();
        try {
            request.setCharacterEncoding("utf-8");
            int rs = messageDAO.deleteMessage(nickname);
            //클라이언트에게 응답값을 보낼 때 인자 값의 url 로
            //즉시 재요청하도록 만듦
            if(rs>0) response.sendRedirect("/toOutput.proc");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
