package com.board.controller;

import com.board.dao.FileDAO;
import com.board.dto.FileDTO;
import com.board.dto.MemberDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "FileController", value = "*.file")
public class FileController extends HttpServlet {
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
        response.setContentType("text/html; charset = utf-8");
        FileDAO fileDAO = new FileDAO();
        System.out.println("요쳥 uri : " +uri);

        if(uri.equals("/download.file")){
            int file_seq = Integer.parseInt(request.getParameter("file_seq"));
            try{
                FileDTO fileDTO = fileDAO.selectByFile_seq(file_seq);
                String fileOriName= fileDTO.getFileOriName();
                String fileSysName = fileDTO.getFileSysName();
                String path = request.getServletContext().getRealPath("files");
                String filePath = path + File.separator + fileSysName;
                File file = new File(filePath);
                fileOriName = new String(fileOriName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
                response.setHeader("Content-disposition", "attachment; filename=\""+fileOriName+"\"");

                try(DataInputStream dataInputStream = new DataInputStream(new FileInputStream(filePath));
                    DataOutputStream dataOutputStream = new DataOutputStream(response.getOutputStream())){

                    byte[] bytes = new byte[(int) file.length()];
                    dataInputStream.readFully(bytes);
                    dataOutputStream.write(bytes);
                    dataOutputStream.flush();

                } catch (Exception e){
                    e.printStackTrace();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
