package com.network.download01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        //서버에 있는 파일을 클라이언트가 다운로드
        /*
        서바 가동 -> 클라이언트 접속 -> 클라이언트용 소켓 생성
        서버의 HDD 에 있는 파일을 서버 프로그램으로 읽어오기(입력)
        불러들여온 파일을 클라이언트에 전송
         */

        String path = "/Volumes/My Passport/WorkSpace/Day13_Network/NetWork/Server/";
        String fileName = "123.jpeg";

        try(ServerSocket serverSocket = new ServerSocket(8000);
            Socket socket = serverSocket.accept();
            FileInputStream fis = new FileInputStream(path+fileName);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream())){

            byte[] bytes = fis.readAllBytes();
            System.out.println("보낼 파일의 크기 : " + bytes.length);

            //클라이언트에게 파일을 전송
            // 1. 데이터의 크기를 먼저 전송 ( 클라이언트에 바이트 배열의 크기를 인지시키기 위한 과정 )-> 클라이언트가 사이즈를 받아 바이트 배열을 만듦
            // 2. 데이터를 전송 -> 위의 배열에다가 데이터를 받아 줌

            dos.writeInt(bytes.length);//1
            dos.write(bytes); //2
            dos.flush();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
