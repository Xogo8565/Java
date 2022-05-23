package com.board.controller;

import com.board.dao.ReplyDAO;
import com.board.dto.ReplyDTO;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CommentController", value = "*.reply")
public class ReplyController extends HttpServlet {
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
        ReplyDAO replyDAO = new ReplyDAO();
        Gson gson = new Gson();
        System.out.println("요청 uri " + uri);
        if (uri.equals("/insert.reply")) {
            String id = request.getParameter("id");
            String nickname = request.getParameter("nickname");
            String content = request.getParameter("reply");
            int board_no = Integer.parseInt(request.getParameter("board_no"));
            try {
                int rs = replyDAO.insert(new ReplyDTO(0, board_no, content, id, nickname, null));
                if(rs>0) response.getWriter().append("success");
                else response.getWriter().append("fail");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/delete.reply")) {
            int reply_no = Integer.parseInt(request.getParameter("reply_no"));
            try {
                int rs = replyDAO.delete(reply_no);
                if(rs>0) response.getWriter().append("success");
                else response.getWriter().append("fail");

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/modify.reply")) {
            int reply_no = Integer.parseInt(request.getParameter("reply_no"));
            String content = request.getParameter("reply");
            try {
                int rs = replyDAO.update(content, reply_no);
                if(rs>0) response.getWriter().append("success");
                else response.getWriter().append("fail");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/show.reply")) {
            int board_no = Integer.parseInt(request.getParameter("board_no"));
            try {
                ArrayList<ReplyDTO> arrayList = replyDAO.selectAllReply(board_no);
                String strRs = gson.toJson(arrayList);
                response.getWriter().append(strRs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
