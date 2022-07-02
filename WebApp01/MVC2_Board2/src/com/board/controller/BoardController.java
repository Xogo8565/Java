package com.board.controller;

import com.board.dao.BoardDAO;
import com.board.dao.FileDAO;
import com.board.dao.ReplyDAO;
import com.board.dto.BoardDTO;
import com.board.dto.FileDTO;
import com.board.dto.MemberDTO;
import com.board.dto.ReplyDTO;
import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
        FileDAO fileDAO = new FileDAO();
        ReplyDAO replyDAO = new ReplyDAO();
        System.out.println("요청 uri :" + uri);

        if (uri.equals("/toBoard.board")) {
            int curPage = Integer.parseInt(request.getParameter("curPage"));

            try {
                HashMap<String, Object> hashMap = boardDAO.getPageNavi(curPage);
                int start = (int) hashMap.get("start");
                int end = (int) hashMap.get("end");

                ArrayList<BoardDTO> arrayList = boardDAO.selectAll(start, end);
                request.setAttribute("arrayList", arrayList);
                request.setAttribute("hashMap", hashMap);
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
            String filePath = request.getServletContext().getRealPath("files");
            File dir = new File(filePath);
            int max = 1024 * 1024 * 10;

            if (!dir.exists()) {
                dir.mkdir();
            }

            try {
                MultipartRequest multipartRequest = new MultipartRequest(request, filePath, max, "utf-8", new DefaultFileRenamePolicy());
                String ori_name = multipartRequest.getOriginalFileName("file");
                String sys_name = multipartRequest.getFilesystemName("file");
                String title = multipartRequest.getParameter("title");
                String content = multipartRequest.getParameter("content");

                int board_no = boardDAO.getBoardSeq();

                int rs = boardDAO.newPost(new BoardDTO(board_no, id, nickname, title, content, 0, null));
                if (rs > 0) {
                    if(sys_name!=null) fileDAO.insert(new FileDTO(0,board_no, ori_name, sys_name));
                    response.sendRedirect("/toBoard.board?curPage=1");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }//
        } else if (uri.equals("/detailView.board")) {
            int no = Integer.parseInt(request.getParameter("no"));
            try {
                //조회수++
                boardDAO.plusViewCount(no);
                BoardDTO boardDTO = boardDAO.selectByNo(no);
                ArrayList<ReplyDTO> arrayList = replyDAO.selectAllReply(no);
                FileDTO fileDTO = fileDAO.selectAll(no);
                request.setAttribute("boardDTO", boardDTO);
                request.setAttribute("arrayList", arrayList);
                request.setAttribute("fileDTO", fileDTO);
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
                if (rs > 0) response.sendRedirect("/toBoard.board?curPage=1");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/search.board")) {
            String search = request.getParameter("search");
            try {
                ArrayList<BoardDTO> arrayList = boardDAO.searchByTitle(search);
                Gson gson = new Gson();
                String rs = gson.toJson(arrayList);
                response.getWriter().append(rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
