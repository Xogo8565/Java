package com.movie.controller;

import com.movie.a.ApiExplorer;
import com.movie.dto.MovieDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ApiController", value = "*.api")
public class ApiController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request,response);
    }
    protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/http; charset = utf-8");
        ApiExplorer apiExplorer = new ApiExplorer();

        if(uri.equals("/get.api")){
            int totalCnt = 87704; // 영화 total count
            int num = (int) Math.ceil(totalCnt/10); // 반복 횟수

            try{
                for(int i =0; i<num; i++){
                    ArrayList<MovieDTO> arrayList = apiExplorer.run(i);
                    for(MovieDTO movieDTO : arrayList){
                        System.out.println("감독 : "+movieDTO.getPeopleNm()+"\n");
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
