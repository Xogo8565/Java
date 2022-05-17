package com.board.controller;

import com.board.dao.BoardDAO;
import com.board.dao.MemberDAO;
import com.board.dto.BoardDTO;
import com.board.dto.MemberDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "BoardController", value = "*.board")
public class BoardController extends HttpServlet {
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
        response.setContentType("text/html;charset=UTF-8");
        String uri = request.getRequestURI();
        BoardDAO boardDAO = new BoardDAO();
        System.out.println("요청 uri :" + uri);

        if (uri.equals("/toBoard.board")) {
            try{
                ArrayList<BoardDTO> arrayList = boardDAO.selectAll();
                request.setAttribute("arrayList", arrayList);
                request.getRequestDispatcher("/board/board.jsp").forward(request,response);
            } catch (Exception e){
                e.printStackTrace();
            }
        } else if (uri.equals("/toWrite.board")) {
            response.sendRedirect("/board/write.jsp");
        } else if (uri.equals("/write.board")) {
            HttpSession httpSession = request.getSession();
            MemberDTO memberDTO = (MemberDTO) httpSession.getAttribute("loginSession");
            String id = memberDTO.getId();
            String nickname = memberDTO.getNickname();
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            try {
                int rs = boardDAO.newPost(new BoardDTO(0, id, nickname, title, content, 0, null));
                if(rs>0) response.sendRedirect("/toBoard.board");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/detailView.board")){
            int no = Integer.parseInt(request.getParameter("no"));
            try{
                BoardDTO boardDTO = boardDAO.selectByNo(no);
                request.setAttribute("boardDTO",boardDTO);
                request.getRequestDispatcher("/board/detailView.jsp").forward(request,response);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
