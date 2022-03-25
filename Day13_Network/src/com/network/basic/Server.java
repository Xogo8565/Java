package com.network.basic;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        // 1. 서버용 소켓 생성
        // ServerSocket : 클라이언트 수만큼 소켓을 생성해주는 인스턴스

        try(ServerSocket server = new ServerSocket(8000);
            // 2. 클라이언트의 요청을 수락할 클라이언트 전용 소켓(socket)을 생성
            // 클라이언트의 실제 접속이 감지 됐을 때까지 대기하다 실제 접속이 이뤄졌을 때 소켓이 생성
            Socket socket = server.accept();){

            System.out.println("새로운 클라이언트가 접속했습니다.");
            //Client 의 IP 주소 표시
            System.out.println("접속한 IP : " + socket.getLocalAddress());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
