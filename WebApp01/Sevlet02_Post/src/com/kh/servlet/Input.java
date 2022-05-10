package com.kh.servlet;

import com.kh.msg.MsgDAO;
import com.kh.msg.MsgDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "input", value = "/input.proc")
public class Input extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String msg = request.getParameter("msg");
        System.out.println(id + ":" + msg);

        MsgDAO msgDAO = MsgDAO.getInstance();

        try{
            int rs = msgDAO.insert(new MsgDTO(id,msg));
            System.out.println(rs);
            if(rs>0){
                response.sendRedirect("/index.html");
            } else {
                response.sendRedirect("/input.html");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
