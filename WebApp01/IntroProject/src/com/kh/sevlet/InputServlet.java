package com.kh.sevlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InputServlet", value = "/InputServlet")
public class InputServlet extends HttpServlet {

    // client 가 get 방식으로 요청하면 doGet() 작동
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request -> 클라이언트가 보낸 데이터를 꺼내는 작업
        //request.getParameter(name값/key값) : name / key에 해당하는 value를 String 으로 변환
        String msg = request.getParameter("msg");
        System.out.println("doGet : " +msg);
    }

    // client 가 post 방식으로 요청하면 do() 작동
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = request.getParameter("msg");
        System.out.println("doPost : "+msg);
    }
}
