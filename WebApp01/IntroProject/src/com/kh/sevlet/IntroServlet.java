package com.kh.sevlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "IntroServlet", value = "/IntroServlet")
// 클라이언트가 요청 url을 보내면 Was 그 url 값을 본인이 가지고 있는 서블릿(/IntroServlet)과 비교.
// 서블릿의 어노테이션 안쪽의 String 값과 클라이언트가 요청한 url 값 비교
// Request, Response 객체를 생성해서 url 값과 일치하는 servlet에 전달
public class IntroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("서블릿 도착.");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
