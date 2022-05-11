package com.kh.servlet;

import com.kh.student.StudentDAO;
import com.kh.student.StudentDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "searchAll", value = "/searchAll.proc")
public class SearchAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDAO studentDAO = new StudentDAO();

        try{
            ArrayList<StudentDTO> arrayList = studentDAO.selectAll();
            response.setContentType("text/html; charset=utf-8");
            PrintWriter printWriter = response.getWriter();

            printWriter.write("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Title</title>\n" +
                    "    <style>" +
                    "        .container * {\n" +
                    "            box-sizing: border-box;\n" +
                    "            border: 1px solid black;\n" +
                    "            text-align: center;\n" +
                    "            padding: 2px;\n" +
                    "        }\n" +
                    "\n" +
                    "        .container {\n" +
                    "            width: 600px;\n" +
                    "        }\n" +
                    "\n" +
                    "        .head {\n" +
                    "            display: flex;\n" +
                    "            font-weight: bold;\n" +
                    "        }\n" +
                    "\n" +
                    "        .head > div {\n" +
                    "            flex-basis: 100px\n" +
                    "        }\n" +
                    "\n" +
                    "        .result {\n" +
                    "            display: flex\n" +
                    "        }\n" +
                    "\n" +
                    "        .result > div {\n" +
                    "            flex-basis: 100px\n" +
                    "        }\n" +
                    "\n" +
                    "        .title {\n" +
                    "            font-weight: bold;\n" +
                    "            font-size: 1.2em;\n" +
                    "        }\n" +
                    "\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<div class='container'>\n" +
                    "    <div class='resultContainer'>\n" +
                    "        <div class='title'>Student</div>\n" +
                    "        <div class='head'>\n" +
                    "            <div>ID</div>\n" +
                    "            <div>NAME</div>\n" +
                    "            <div>KOR</div>\n" +
                    "            <div>ENG</div>\n" +
                    "            <div>MATH</div>\n" +
                    "            <div>SUM</div>\n" +
                    "        </div>\n");
            for(StudentDTO studentDTO : arrayList){
                int sum = studentDTO.getKor() + studentDTO.getEng() + studentDTO.getMath();
                printWriter.write("<div class='result'><div>"+studentDTO.getNo()+"</div>"+"<div>"+studentDTO.getName()+"</div>"+"<div>"+studentDTO.getKor()+"</div>"+"<div>"+studentDTO.getEng()+"</div>"+"<div>"+studentDTO.getMath()+"</div>"+"<div>"+sum+"</div></div>");
            }

            printWriter.write("    </div>\n" +
                    "    <div class='deleteContainer'>\n" +
                    "        <form action='/delete.proc' method='get'><input type='number' placeholder='Delete by Number' name='no'>\n" +
                    "            <button type='submit'>delete</button>\n" +
                    "        </form>\n" +
                    "    </div>\n" +
                    "    <div class='updateContainer'>\n" +
                    "        <form action='/update.proc' method='post'>\n" +
                    "            <div><input type='number' placeholder='No' name='no'></div>\n" +
                    "            <div><input type='text' placeholder='Name' name='name'></div>\n" +
                    "            <div><input type='number' placeholder='Kor' name='kor'></div>\n" +
                    "            <div><input type='number' placeholder='Eng' name='eng'></div>\n" +
                    "            <div><input type='number' placeholder='Math' name='math'></div>\n" +
                    "            <div>\n" +
                    "                <button type='submit'>update</button>\n" +
                    "            </div>\n" +
                    "        </form>\n" +
                    "    </div>\n" +
                    "    <div>\n" +
                    "        <form action='/search.proc' method=\"get\"><input type='number' placeholder='find by No' name='no'>\n" +
                    "            <button type='submit'>Search</button>\n" +
                    "            <button type='button' id='searchAllBtn'>Search All</button>\n" +
                    "        </form>\n" +
                    "    </div>\n" +
                    "\n" +
                    "    <div>\n" +
                    "        <button type='button' id='backBtn'>back</button>\n" +
                    "    </div>\n" +
                    "\n" +
                    "</div>\n" +
                    "<script>\n" +
                    "    document.getElementById('backBtn').onclick = function () {\n" +
                    "        location.href = '/index.html'\n" +
                    "    }\n" +
                    "    document.getElementById('searchAllBtn').onclick = function () {\n" +
                    "        location.href = '/searchAll.proc';\n" +
                    "    }\n" +
                    "</script>\n" +
                    "\n" +
                    "</body>\n" +
                    "</html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
