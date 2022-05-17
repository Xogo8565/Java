package com.board.controller;

import com.board.dao.MemberDAO;
import com.board.dto.MemberDTO;
import com.board.utils.EncryptionUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MemberController", value = "*.member")
public class MemberController extends HttpServlet {
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
        MemberDAO memberDAO = new MemberDAO();
        System.out.println("요청 uri : " + uri);

        if (uri.equals("/toSignUp.member")) {
            response.sendRedirect("/member/signUp.jsp");
        } else if (uri.equals("/idCheckPopup.member")) { // 아이디 중복확인 팝업 페이지 요청
            response.sendRedirect("/member/popup.jsp");
        } else if (uri.equals("/checkId.member")) {
            String id = request.getParameter("id");
            System.out.println(id);
            try {
                boolean rs = memberDAO.checkId(id);
                System.out.println(rs);

                request.setAttribute("rs", rs);

                request.setAttribute("id", id);
                request.getRequestDispatcher("/member/popup.jsp").forward(request, response);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/signUp.member")) {
            String id = request.getParameter("id");
            String pw = request.getParameter("pw");
            String nickname = request.getParameter("nickname");
            String phoneNum = request.getParameter("phoneNum");
            String postCode = request.getParameter("postCode");
            String address_1 = request.getParameter("address_1");
            String address_2 = request.getParameter("address_2");
            String address_3 = request.getParameter("address_3");

            try {
                pw = EncryptionUtils.getSHA512(pw);
                int rs = memberDAO.signUp(new MemberDTO(id, pw, nickname, phoneNum, postCode, address_1, address_2, address_3));
                if (rs > 0) response.sendRedirect("/");

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/login.member")) {
            String id = request.getParameter("id");
            String pw = request.getParameter("pw");
            try {
                pw = EncryptionUtils.getSHA512(pw);
//                if (memberDAO.checkLogin(id, pw)) {
//                    request.setAttribute("rs", true);
//                    //session 저장소를 이용해 login 정보를 저장
//                    HttpSession httpSession = request.getSession();
//                    httpSession.setAttribute("loginSession", id);
//
//                    //session 은 별도로 forward 해주지 않아도 jsp 와 값의 공유가 가능.
//                } else request.setAttribute("rs", false);

                MemberDTO memberDTO = memberDAO.checkLogin(id, pw);
                if (memberDTO!=null) {
                    request.setAttribute("rs", true);
                    //session 저장소를 이용해 login 정보를 저장
                    HttpSession httpSession = request.getSession();
                    httpSession.setAttribute("loginSession", memberDTO);
                    //session 은 별도로 forward 해주지 않아도 jsp 와 값의 공유가 가능.
                } else request.setAttribute("rs", false);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/logout.member")) {
            // 요청을 보낸 클라이언트의 세션 얻어오기
            HttpSession httpSession = request.getSession();
            //System.out.println(httpSession.getAttribute("loginSession"));
            // 1. Session 객체를 초기화하는 방법
//          // 로그아웃의 경우는 invalidate() 를 활용
            httpSession.invalidate();
            response.sendRedirect("/");
            /*
            2. Session 저장소에서 loginSession 값만 삭제
            httpSession.removeAttribute("loginSession");
            response.sendRedirect("/index.jsp");
            */
        } else if(uri.equals("/myPage.member")){
            HttpSession httpSession = request.getSession();
            String id  = ((MemberDTO)httpSession.getAttribute("loginSession")).getId();
            try {
                MemberDTO memberDTO2 = memberDAO.getLoginMemberInfo(id);
                request.setAttribute("memberDTO", memberDTO2);
                request.getRequestDispatcher("/member/myPage.jsp").forward(request,response);

            } catch (Exception e){
                e.printStackTrace();
            }
        } else if(uri.equals("/modify.member")){
            HttpSession httpSession = request.getSession();
            String id  = ((MemberDTO)httpSession.getAttribute("loginSession")).getId();
            String nickname = request.getParameter("nickname");
            String phoneNum = request.getParameter("phoneNum");
            String postCode = request.getParameter("postCode");
            String address_1 = request.getParameter("address_1");
            String address_2 = request.getParameter("address_2");
            String address_3 = request.getParameter("address_3");
            try{
                int rs = memberDAO.updateMemberInfo(new MemberDTO(id, null, nickname, phoneNum, postCode, address_1, address_2, address_3 ));
                if(rs>0) response.sendRedirect("/myPage.member");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(uri.equals("/resign.member")){
            HttpSession httpSession = request.getSession();
            String id  = ((MemberDTO)httpSession.getAttribute("loginSession")).getId();
            try{
                int rs = memberDAO.resign(id);
                httpSession.invalidate();
                if(rs>0) response.sendRedirect("/");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
