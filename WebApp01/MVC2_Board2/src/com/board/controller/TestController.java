package com.board.controller;

import com.board.dao.BoardDAO;
import com.board.dto.BoardDTO;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TestController", value = "*.test")
public class TestController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);

    }

    protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset = utf-8");
        String uri = request.getRequestURI();
        System.out.println("요청 uri : " + uri);

        if (uri.equals("/test.test")) {
            response.sendRedirect("/test.jsp");
        } else if (uri.equals("/toInput.test")) {
            System.out.println("요청 도착");
        } else if (uri.equals("/sendMsg.test")) {
            String msg = request.getParameter("msg");
            System.out.println(msg);
        } else if (uri.equals("/sendForm.test")) {
            String id = request.getParameter("id");
            String nickname = request.getParameter("nickname");
            System.out.println(id + ":" + nickname);
        } else if (uri.equals("/getData.test")) {
            // ajax로 통신할 때 서버에서 클라이언트로 데이터를 전송하고 싶으면
            // response.getWriter().append(보낼 값); 시용
            String msg = request.getParameter("msg");
            if (msg.equals("hello")) response.getWriter().append("hello World");
            else if (msg.equals("goodbye")) response.getWriter().append("Good Bye");
        } else if (uri.equals("/getDto.test")) {
            BoardDAO boardDAO = new BoardDAO();
            try {
                BoardDTO boardDTO = boardDAO.selectByNo(3);
                /*
                Gson -> 객체나 객체 배열을 ajax 로, json 타입으로 전송하기 위해 사용하는 라이브러리
                json(javascript object notation)
                -> {key : value, key : value}

                toJson() -> jSon 형식의 문자열로 변환
                * */
                Gson gson = new Gson();
                String rs = gson.toJson(boardDTO);
                response.getWriter().append(rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(uri.equals("/getList.test")){
//            BoardDAO boardDAO = new BoardDAO();
//            try{
//                ArrayList<BoardDTO> arrayList = boardDAO.selectAll();
//                Gson gson = new Gson();
//                String rs = gson.toJson(arrayList);
//                response.getWriter().append(rs);
//
//            } catch (Exception e){
//                e.printStackTrace();
//            }
        }
    }
}
