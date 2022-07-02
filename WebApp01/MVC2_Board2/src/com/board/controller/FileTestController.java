package com.board.controller;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "FileTestController", value = "*.fileTest")
public class FileTestController extends HttpServlet {
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
        System.out.println("uri 요청 :" + uri);
        if (uri.equals("/upload1.fileTest")) {
            System.out.println("파일 요청");
            //String file = request.getParameter("file");
            // file request를 받았을 때는 HttpServletRequest 로 데이터를 받아줄 수 없음
            // DB에 파일을 저장하지 않을 것 -> 서버의 컴퓨터(물리적 경로)에 저장
            // tomcat 이 실행되고 있는 root 경로 -> files 폴더를 만들어 파일을 저장
            // DB에는 파일의 경로값만 저장

            // Controller 는 클라이언트에게 요청받은 파일이 있다면 DB에 저장된 경로값을 꺼내서
            // InputStream을 이용해 해당 파일을 프로그래램으로 불러오고, 그 후 클라이언트에게 응답


            //1. 서버의 root 경로
            String path = request.getServletContext().getRealPath("");
            System.out.println(path);

            //2 서버에 실제 파일이 저장될 경로 값
            String filePath = request.getServletContext().getRealPath("files");
            System.out.println(filePath);

            //File 을 이용한 경로 생성
            File dir = new File(filePath);
            if (!dir.exists()) {
                dir.mkdir();
            }

            //file 크기 지정 : 1MB -> 1024*1024*1
            int max = 1024 * 1024 * 10;
            //MultipartRequest(request, file 경로, max, 인코딩, 파일 이름 중복 처리 방지)
            // 객체를 생성하면 바로 파일의 업로드가 이뤄짐

            try {
                MultipartRequest multipartRequest = new MultipartRequest(request, filePath, max, "utf-8", new DefaultFileRenamePolicy());
                //원본 파일 명
                //파일 다운로드 기능을 구현할 때 만약 첨푸파일의 목록을 띄워준다면, 처음 업로드됐던 파일의 원본명을 띄워주기 위한 용 ㄷ
                System.out.println(multipartRequest.getOriginalFileName("file")); //input 태그 name 값

                // 실제 서버 경로에 업로드 된 파일명
                // 요청된 파일을 실제 서버 경로에서 가져오려는 파일의 경로값의 역할을 해주는 filesystemName 이 필요
                System.out.println(multipartRequest.getFilesystemName("file"));
            } catch (Exception e) {
                {
                    e.printStackTrace();
                }
            }
        } else if (uri.equals("/upload2.fileTest")) {
            //cos.jar 라이브러리를 이용하면 동일한 이름ㅇ르ㅗ 여러개의 파일을 업로드 하는 것이 가능은 하지만 하나의 파일명 밖에 얻어오지 못함
            // 하나의 파일명 밖에 얻어도지 못하기 때문에 여러 개의 파일을 업로드할 거라면 모두 nmae 을 다르게 섲렁해준다
            String filePath = request.getServletContext().getRealPath("files");
            File dir = new File(filePath);
            if (!dir.exists()) dir.mkdir();
            int max = 1024 * 1024 * 10;

            try {
                MultipartRequest multipartRequest = new MultipartRequest(request, filePath, max, "utf-8", new DefaultFileRenamePolicy());
                System.out.println(multipartRequest.getOriginalFileName("file1"));
                System.out.println(multipartRequest.getFilesystemName("file1"));
                System.out.println("\n=====");
                System.out.println(multipartRequest.getOriginalFileName("file2"));
                System.out.println(multipartRequest.getFilesystemName("file2"));


            } catch (Exception e) {
                {
                    e.printStackTrace();
                }
            }
        } else if (uri.equals("/upload3.fileTest")) {
            String filePath = request.getServletContext().getRealPath("files");
            File dir = new File(filePath);

            if (!dir.exists()) {
                dir.mkdir();
            }
            int max = 1024 * 1024 * 10;
            try {
                MultipartRequest multipartRequest = new MultipartRequest(request, filePath, max, "utf-8", new DefaultFileRenamePolicy());
                String ori_file = multipartRequest.getOriginalFileName("file");
                String sys_file = multipartRequest.getFilesystemName("file");
                // 인코딩 타입이 multipart/form-data 일 때는 보내주는 텍스트 데이터를 일반 request 로 받을 수 없음
                String title = multipartRequest.getParameter("title");
                String msg = multipartRequest.getParameter("msg");

                System.out.println("title : " + title + "\nmsg : " + msg + "\nori_file : " + ori_file + "\nsys_file: " + sys_file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/download.fileTest")) {
            // 특정 파일의 다운로드 요청 -> 파일명
            // 실제 파일이 저장되어 있는 서버의 경로 값 (files 폴더 + 파일명)
            // 경로 값을 이용해 InputStream 을 통해 서버 프로그램으로 HDD 에 있는 파일을 읽어들어옴
            // 서버 프로그램과 클라이언트 상이에 OutputStream 을 열어주고 파일을 전송

            String fileName = "스크린샷 2022-05-23 오후 6.11.08.png";
            String path = request.getServletContext().getRealPath("files");
            //File.seperator : 서버 프로그램이 돌고 있는 컴퓨터의 os에 맞추서 폴더 경계의 구분자를 맞춰 줌
            String filePath = path + File.separator + fileName;
            File file = new File(filePath);
            fileName = new String(fileName.getBytes(StandardCharsets.UTF_8), "ISO-8859-1");

            //Response header 설정 -> 지금 들어가는 응답값이 일반적인 html,  jsp가 아닌 다운로드가 이뤄져야 하는 파일이라는 것읆 명시
            response.setHeader("Content-disposition","attachment; filename=\""+fileName+"\"");

            try(DataInputStream dataInputStream = new DataInputStream(new FileInputStream(filePath));
                DataOutputStream dataOutputStream = new DataOutputStream(response.getOutputStream())){
                byte[] bytes = new byte[(int) file.length()];
                dataInputStream.readFully(bytes);
                dataOutputStream.write(bytes);
                dataOutputStream.flush();

            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
