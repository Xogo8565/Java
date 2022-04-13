package com.network.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        Scanner sc  = new Scanner(System.in);

        try(Socket socket = new Socket("192.168.20.14",8000);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream())){

            String hi = dis.readUTF();
            System.out.println(hi);

            System.out.print("닉네임을 입력하세요\n>> ");
            String nickname = sc.nextLine();
            dos.writeUTF(nickname);
            dos.flush();

            try{
                while (true){
                    System.out.print("메시지를 입력하세요\n>> ");
                    String clientMsg = sc.nextLine();
                    dos.writeUTF(clientMsg);
                    dos.flush();

                    String serverMsg = dis.readUTF();
                    System.out.println("서버의 메시지 : " + serverMsg);
                }
            }catch (Exception e){
                System.out.println("접속이 원할하지 않습니다.");
                e.printStackTrace();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
