package com.kh.servlet;

import com.kh.student.StudentDAO;
import com.kh.student.StudentDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "input", value = "/input.proc")
public class Input extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDAO studentDAO = new StudentDAO();
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        int kor = Integer.parseInt(request.getParameter("kor"));
        int eng = Integer.parseInt(request.getParameter("eng"));
        int math = Integer.parseInt(request.getParameter("math"));

        try{
            int rs = studentDAO.insert(new StudentDTO(0, name, kor, eng, math));
            if(rs>0) response.sendRedirect("/index.html");
            else response.sendRedirect("/input.html");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
