package com.intro.contoller;

import com.intro.msg.MsgDAO;
import com.intro.msg.MsgDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "InsertController", value = "/Insert")
public class InsertController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String nickname = request.getParameter("nickname");
        String msg = request.getParameter("msg");
        MsgDAO msgDAO = new MsgDAO();
        try {
            int rs = msgDAO.insert(new MsgDTO(0, nickname, msg));
            if(rs>0){
                response.sendRedirect("home.jsp");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
