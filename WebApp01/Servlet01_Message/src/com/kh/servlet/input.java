package com.kh.servlet;

import com.kh.dao.MessageDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "input", value = "/input.proc")
public class input extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nickname = request.getParameter("nickname");
        String message = request.getParameter("message");
        System.out.println("nickname : " + nickname + "\nmessage : " + message);

        MessageDAO messageDAO = new MessageDAO();

        try {
            int rs = messageDAO.insertMessage(nickname, message);
            if(rs>0) {
                System.out.println("Success");
                response.sendRedirect("/index.html");
            }
            else {
                System.out.println("Fail");
                response.sendRedirect("/input.html");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
