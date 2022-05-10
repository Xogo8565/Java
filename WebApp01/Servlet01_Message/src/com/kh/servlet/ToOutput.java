package com.kh.servlet;

import com.kh.dao.MessageDAO;
import com.kh.dao.MessageDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "toOutput", value = "/toOutput.proc")
public class ToOutput extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //DAO를 통해서 DB에 접속해서 tbl_msg 의 모든 행을 조회
        MessageDAO messageDAO = new MessageDAO();
        try {
            ArrayList<MessageDTO> arrayList = messageDAO.selectAllMessage();
            for (MessageDTO messageDTO : arrayList) {
                System.out.println(messageDTO.toString());
            }
            //문서 타입, 인코딩 타입
            response.setContentType("text/html; charset=utf-8");
            // html table로 데이터를 뿌려주는 작업
            PrintWriter printWriter = response.getWriter();
            printWriter.write(
                    "<html><head>" +
                            "<style>" + "" +
                            "*{ border : 1px solid black; }" +
                            "table{ text-align : center )" +
                            "</style>" +
                            "</head>" +
                            "<body>" +
                            "<table>" +
                            "<thead>" +
                            "<tr><th>nickname</th><th>message</th></tr>" +
                            "</thead>" +
                            "<tbody>");
            for (MessageDTO messageDTO : arrayList) {
                printWriter.write("<tr><td>" + messageDTO.getNickname() + "</td><td>" + messageDTO.getMessage() + "</td></tr>");
            }
            printWriter.write(
                    "<tr>" +
                    "<form action='/delete.proc' method='post'>" +
                    "<td colspan='2'>" +
                    "<input type='text' name = 'nickname' placeholder='nickname'><button type='submit'>Delete</button>" +
                    "</td>" +
                    "</form>" +
                    "</tr>" +
                    "<tr><form action='update.proc' method='post'><td colspan='2'>" +
                    "<input type='text' name='nickname' placeholder='nickname'>" +
                    "<textarea placeholder='update message' name = 'msg'></textarea>" +
                    "<button type='submit'>수정</button>" +
                    "</td></form></tr>" +
                    "<tr>" +
                    "<td colspan='2'><button id='backBtn' type = 'button'>back</button></td>" +
                    "</tr>"+
                    "</tbody></table>" +
                    "<script>" +
                            "document.getElementById('backBtn').onclick = function (){" +
                            "location.href = '/index.html';" +
                            "}" +
                    "</script>" +
                    "</body></html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
