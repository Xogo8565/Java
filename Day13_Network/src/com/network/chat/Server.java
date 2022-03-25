package com.network.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    /*
    서버 가동 -> 클라이언트 접속
    1. 클라이언트에게 환영 인사 전송
    2. 클라이언트가 닉네임 입력 - > 전송
    3. 서버에서 "~님이 접속하셨습니다" 출력
    4. 클라이언트에서 메세지 전송
    5. 서버에서 메세지를 받아 "~님의 메시지 : " + 메시지 내용 출력
    6. 서버가 클라이언트에게 메세지 전송
    7. 클라이언트에서 메세지 받아 출력

    4~7 번 과정을 반복
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try(ServerSocket serverSocket = new ServerSocket(8000);
        Socket socket = serverSocket.accept();
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream())){

            String hi = "채팅 프로그램에 오신 것을 환영합니다.";
            dos.writeUTF(hi);
            dos.flush();

            String nickname = dis.readUTF();
            System.out.println(nickname+"님 접속~!");
            try{
                while(true){
                    String clientMsg = dis.readUTF();
                    System.out.println(nickname+"님의 메시지 : " + clientMsg);

                    System.out.println("메시지를 입력하세요\n>> ");
                    String serverMsg = sc.nextLine();
                    dos.writeUTF(serverMsg);
                    dos.flush();
                }
            } catch (Exception e){
                System.out.println("서버를 재부팅 하세요");
                e.printStackTrace();
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
