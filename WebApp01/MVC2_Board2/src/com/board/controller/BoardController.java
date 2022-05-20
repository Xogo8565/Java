package com.board.controller;

import com.board.dao.BoardDAO;
import com.board.dao.MemberDAO;
import com.board.dao.ReplyDAO;
import com.board.dto.BoardDTO;
import com.board.dto.MemberDTO;
import com.board.dto.ReplyDTO;
import com.google.gson.Gson;

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
        ReplyDAO replyDAO = new ReplyDAO();
        System.out.println("요청 uri :" + uri);

        if (uri.equals("/toBoard.board")) {
            try {
                ArrayList<BoardDTO> arrayList = boardDAO.selectAll();
                request.setAttribute("arrayList", arrayList);
                request.getRequestDispatcher("/board/board.jsp").forward(request, response);
            } catch (Exception e) {
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
                if (rs > 0) response.sendRedirect("/toBoard.board");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/detailView.board")) {
            int no = Integer.parseInt(request.getParameter("no"));
            try {
                //조회수++
                boardDAO.plusViewCount(no);
                BoardDTO boardDTO = boardDAO.selectByNo(no);
                ArrayList<ReplyDTO> arrayList = replyDAO.selectAllReply(no);
                request.setAttribute("boardDTO", boardDTO);
                request.setAttribute("arrayList", arrayList);
                request.getRequestDispatcher("/board/detailView.jsp").forward(request, response);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/toModify.board")) {
            int no = Integer.parseInt(request.getParameter("no"));
            try {
                BoardDTO boardDTO = boardDAO.selectByNo(no);
                request.setAttribute("boardDTO", boardDTO);
                request.getRequestDispatcher("/board/modify.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/modify.board")) {
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            int no = Integer.parseInt(request.getParameter("no"));
            try {
                int rs = boardDAO.modifyPost(new BoardDTO(no, null, null, title, content, 0, null));
                if (rs > 0) response.sendRedirect("/detailView.board?no=" + no);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/delete.board")) {
            int no = Integer.parseInt(request.getParameter("no"));
            try {
                int rs = boardDAO.deletePost(no);
                if (rs > 0) response.sendRedirect("/toBoard.board");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(uri.equals("/search.board")){
            String search = request.getParameter("search");
            try{
                ArrayList<BoardDTO> arrayList = boardDAO.searchByTitle(search);
                Gson gson = new Gson();
                String rs = gson.toJson(arrayList);
                response.getWriter().append(rs);

            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
