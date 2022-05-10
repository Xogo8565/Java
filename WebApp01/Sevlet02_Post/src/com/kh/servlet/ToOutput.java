package com.kh.servlet;

import com.kh.msg.MsgDAO;
import com.kh.msg.MsgDTO;

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
        MsgDAO msgDAO = MsgDAO.getInstance();
        try {
            ArrayList<MsgDTO> arrayList = msgDAO.selectAll();
            response.setContentType("text/html; charset=utf-8");
            PrintWriter printWriter = response.getWriter();

            printWriter.write("<html><head></head><body><table><thead><tr><th>ID</th><th>Message</th></tr></thead><tbody>");
            for (MsgDTO msgDTO : arrayList) {
                printWriter.write("<tr><td>" + msgDTO.getId() + "</td><td>" + msgDTO.getMsg() + "</td></tr>");
            }
            printWriter.write("<tr><td colspan='2'><form action='delete.proc' method='post'>" +
                    "<input type = 'text' placeholder='id' name ='id'><button type='submit'>delete</button>" +
                    "</form></td></tr>" +
                    "<tr><form action='/update.proc' method ='post'><td colspan='2'>" +
                    "<input type='text' name='id' placeholder='nickname'><textarea name='msg' placeholder='message'></textarea>" +
                    "</td></form></tr>" +
                    "<tr><td colspan = '2'><button type='button' id='backBtn'>back</button></td></tr>" +
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

    }
}
