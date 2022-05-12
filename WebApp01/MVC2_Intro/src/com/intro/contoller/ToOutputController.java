package com.intro.contoller;

import com.intro.msg.MsgDAO;
import com.intro.msg.MsgDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ToOutputController", value = "/ToOutput")
public class ToOutputController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // controller 에서는 데이터를 dao 를 통해 가져오는 작업
        /*
           response.sendRedirect(url);
           : 클라이언트에게 url 을 요청해라라는 응답값을 줌

           request.setAttribute("key", value);
           : request 에 값을 추가하고 싶을 때 사용
           - key -> 내가 추가해준 값을 꺼낼 수 있게 해주는 고유값 // 중복값을 사용하면 x
           - value -> 실제로 추가해준 값 그 자체

           forward(request, response);
           : 서버가 만들어 둔 request, response 를 그대로 전달하는 작업을 해줌
        **/

        /*
        String temp = "hello";
        request.setAttribute("temp", temp);
        request.setAttribute("number",50);
        // request.getRequestDispatcher(request 를 전달해줄 경로);
        */
        /*
        // 객체 단위의 데이터 전달
        MsgDTO msgDTO = new MsgDTO(1, "tom", "hi");

        request.setAttribute("msgDTO", msgDTO);
        request.getRequestDispatcher("/output.jsp").forward(request, response);

         */
        MsgDAO msgDAO = new MsgDAO();
        try{
            ArrayList<MsgDTO> arrayList = msgDAO.selectAll();
            request.setAttribute("arrayList", arrayList);
            request.getRequestDispatcher("/output.jsp").forward(request, response);

        } catch (Exception e){
            e.printStackTrace();
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
