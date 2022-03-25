package com.network.message;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        // 서버 가동 -> 클라이언트 접속 -> 서버에서 클라이언트에게 "접속을 환영합니다" 전송
        try(ServerSocket serverSocket = new ServerSocket(8000);
            Socket socket = serverSocket.accept();
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream())){

            //서버에서 보냈으면 클라이언트에서 반드시 받아주고
            //클라이언트에서 보냈으면 서버에서 받아주는 과정이 반드시 필요 -> 순서와 짝이 맞아야 함

            String welcomeMsg = "접속하신 것을 환영합니다.";
            dos.writeUTF(welcomeMsg);
            dos.flush();

            System.out.println(dis.readUTF());

            while (true){
                String msg = dis.readUTF();
                System.out.println(socket.getLocalAddress()+": "+msg);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
