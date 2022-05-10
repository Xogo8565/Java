package com.kh.servlet;

import com.kh.msg.MsgDAO;

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
        request.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");
        MsgDAO msgDAO = MsgDAO.getInstance();
        try {
            int rs = msgDAO.delete(id);
            if (rs > 0) response.sendRedirect("/toOutput.proc");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
