package com.kh.sevlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "OutputServlet", value = "/OutputServlet")
public class OutputServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("outputServlet 도착");
        String data = request.getParameter("data");
        System.out.println(data);

        //클라이언트가 응답받아야 하는 것은 html 파일
        /* response.getWriter() -> PrintWriter
            -> PrinterWriter.print() -> 인자값으로 html 코드(태그)를 넘겨주면
            등답값으로 받은 브라우저가 print 메서드를 통해 넘어온 태그들을 분석해 실제 페이지로 출력
        * */

        PrintWriter out = response.getWriter();
        out.print("<html><head></head><body>"+data+"</body></html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
