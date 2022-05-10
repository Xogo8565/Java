package com.kh.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "toInput", value = "/toInput.proc")
public class ToInput extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("toInput Servlet On");
        //sendRedirect(최종적으로 클라이언트가 도달하고 싶은 페이지의 경로);
        response.sendRedirect("/input.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
