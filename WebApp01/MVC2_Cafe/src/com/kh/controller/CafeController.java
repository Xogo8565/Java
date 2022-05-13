package com.kh.controller;

import com.kh.cafe.CafeDAO;
import com.kh.cafe.CafeDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "cafeController", value = "*.cafe")
public class CafeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);

    }

    protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        CafeDAO cafeDAO = new CafeDAO();

        if (uri.equals("/toInput.cafe")) {
            response.sendRedirect("/input.jsp");
        } else if (uri.equals("/input.cafe")) {
            String product_name = request.getParameter("product_name");
            int product_price = Integer.parseInt(request.getParameter("product_price"));

            try {
                int rs = cafeDAO.insert(new CafeDTO(0, product_name, product_price));

                if (rs > 0) response.sendRedirect("/index.jsp");
                else response.sendRedirect("/toInput.cafe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/toOutput.cafe")) {
            try {
                ArrayList<CafeDTO> arrayList = cafeDAO.selectAll();
                request.setAttribute("arrayList", arrayList);
                request.getRequestDispatcher("/output.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/delete.cafe")) {
            int product_no = Integer.parseInt(request.getParameter("product_no"));
            try {
                int rs = cafeDAO.delete(product_no);
                response.sendRedirect("/toOutput.cafe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/toModify.cafe")) {
            int product_no = Integer.parseInt(request.getParameter("product_no"));
            try{
                CafeDTO cafeDTO = cafeDAO.selectByNo(product_no);
                request.setAttribute("cafeDTO", cafeDTO);
                request.getRequestDispatcher("modify.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/modify.cafe")) {
            int product_no = Integer.parseInt(request.getParameter("product_no"));
            String product_name = request.getParameter("product_name");
            int product_price = Integer.parseInt(request.getParameter("product_price"));
            try {
                int rs = cafeDAO.modify(new CafeDTO(product_no, product_name, product_price));
                response.sendRedirect("toOutput.cafe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/search.cafe")) {
            try {
                String product_name = request.getParameter("product_name");
                CafeDTO cafeDTO = cafeDAO.select(product_name);
                request.setAttribute("cafeDTO", cafeDTO);
                request.getRequestDispatcher("/output2.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
