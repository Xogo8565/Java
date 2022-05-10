package com.kh.servlet;

import com.kh.student.StudentDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "delete", value = "/delete.proc")
public class Delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int no = Integer.parseInt(request.getParameter("no"));
        StudentDAO studentDAO = StudentDAO.getInstance();
        try{
            int rs = studentDAO.delete(no);
            if(rs>0) response.sendRedirect("/toPrint.proc");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
