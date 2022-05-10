package com.kh.servlet;

import com.kh.msg.MsgDAO;
import com.kh.msg.MsgDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "update", value = "/update.proc")
public class update extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String msg = request.getParameter("msg");

        MsgDAO msgDAO = MsgDAO.getInstance();

        try {
            int rs = msgDAO.update(new MsgDTO(id, msg));
            if (rs > 0) response.sendRedirect("toOutput.proc");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
