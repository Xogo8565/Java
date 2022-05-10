package com.kh.servlet;

import com.kh.student.StudentDAO;
import com.kh.student.StudentDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "update", value = "/update.proc")
public class Update extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StudentDAO studentDAO = StudentDAO.getInstance();
        request.setCharacterEncoding("UTF-8");
        int no = Integer.parseInt(request.getParameter("no"));
        String name = request.getParameter("name");
        int kor = Integer.parseInt(request.getParameter("kor"));
        int eng = Integer.parseInt(request.getParameter("eng"));
        int math = Integer.parseInt(request.getParameter("math"));

        try{
            int rs = studentDAO.update(new StudentDTO(no,name,kor,eng,math));
            if(rs>0){
                response.sendRedirect("toPrint.proc");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
