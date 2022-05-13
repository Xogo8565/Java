package com.board.controller;

import com.board.dao.MemberDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MemberController", value = "*.member")
public class MemberController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request,response);
    }
    protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String uri = request.getRequestURI();
        MemberDAO memberDAO = new MemberDAO();

        if(uri.equals("/toSignUp.member")){
            response.sendRedirect("/member/signUp.jsp");
        } else if (uri.equals("/idCheckPopup.member")) { // 아이디 중복확인 팝업 페이지 요청
            response.sendRedirect("/member/popup.jsp");
        } else if (uri.equals("/checkId.member")) {
            String id = request.getParameter("id");
            System.out.println(id);
            try {
                boolean rs = memberDAO.checkId(id);
                System.out.println(rs);

                if(rs) request.setAttribute("rs", rs);
                else request.setAttribute("rs", rs);

                request.setAttribute("id", id);
                request.getRequestDispatcher("/member/popup.jsp").forward(request,response);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
