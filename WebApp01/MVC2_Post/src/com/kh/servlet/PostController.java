package com.kh.servlet;

import com.kh.post.PostDAO;
import com.kh.post.PostDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PostController", value = "*.post")
public class PostController extends HttpServlet {
    /*
    1. 하나의 객체를 대표할 수 있는 서블릿(컨트롤러) 생성
    2. 하나의 객체와 관련된 기능을 요청하기 위해 일관된 url 패턴 생성 ex_ ~.post
    3. 프론트 컨트롤러의 annotation url 값을 *.post 형식으로 -> .post 로 끝나는 모든 요청을 받을 수 있도록
    4. post 와 관련된 모든 요청을 .post 로
    5. doAction() 메서드 생성
    6. doGet() doPost() 가 doAction 메서드를 호출하도록
    7. doAction() 내부에서 요청 url 에 대한 분석
    8. if 문을 통한 기능 분리
    * */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    protected void doAction(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
        String uri = request.getRequestURI();

        if (uri.equals("/ToInput.post")) {
            // input 페이지 요청
            request.setCharacterEncoding("utf-8");
            response.sendRedirect("/input.jsp");
        } else if (uri.equals("/Input.post")) {
            // 메시지 등록
            String id = request.getParameter("id");
            String msg = request.getParameter("msg");

            PostDAO postDAO = new PostDAO();
            try {
                int rs = postDAO.insert(new PostDTO(0, id, msg));
                if (rs > 0) {
                    response.sendRedirect("index.jsp");

                /*
                 forward ->
                 URL 유지 / request, response 객체 공유
                 --> 새로고침하면 요청이 한 번 더 들어가게 됨
                 --> 중복된 데이터의 삭제, 수정, 입력의 발생 가능성 O
                 --> DB 데이터에 변화가 일어나는 작업은 forward(x)


                 redirect ->
                 URL 변화 / request, response 객체가 유지되지 x
                 */
                    // request.getRequestDispatcher("index.jsp").forward(request,response);
                } else response.sendRedirect("input.jsp");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/ToOutput.post")) {
            // 출력
            PostDAO postDAO = new PostDAO();
            try {
                ArrayList<PostDTO> arrayList = postDAO.selectAll();
                response.setContentType("text/html; charset = utf-8");
                request.setAttribute("arrayList", arrayList);
                request.getRequestDispatcher("/output.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/ToModify.post")) {
            // 수정 페이지로
            int no = Integer.parseInt(request.getParameter("no"));
            System.out.println(no);

            // 1. DAO 에게 seq 를 넘겨서 seq 에 해당하는 행의 데이터를 조회
            // 2. 조회해온 데이터를 modify.jsp 에 반환
            PostDAO postDAO = new PostDAO();
            try {
                PostDTO postDTO = postDAO.selectByNo(no);
                if (postDTO != null) {
                    request.setAttribute("postDTO", postDTO);
                    request.getRequestDispatcher("/modify.jsp").forward(request, response);
                } else response.sendRedirect("/ToOutput.post");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/Modify.post")) {
            // 수정
            request.setCharacterEncoding("utf-8");
            int no = Integer.parseInt(request.getParameter("no"));
            String id = request.getParameter("id");
            String msg = request.getParameter("msg");

            PostDAO postDAO = new PostDAO();
            try {
                int rs = postDAO.modify(new PostDTO(no, id, msg));
                if (rs > 0) response.sendRedirect("/ToOutput.post");
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.equals("/Delete.post")) {
            request.setCharacterEncoding("utf-8");
            int no = Integer.parseInt(request.getParameter("no"));

            PostDAO postDAO = new PostDAO();
            try{
                int rs = postDAO.delete(no);
                if(rs > 0){
                    response.sendRedirect("/ToOutput.post");
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
