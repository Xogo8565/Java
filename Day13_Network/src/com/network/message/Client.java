package com.network.message;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try(Socket client = new Socket("192.168.20.14", 8000);
            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream())){

            String welcomeMsg = dis.readUTF();
            System.out.println(welcomeMsg);

            String welcomeMsg2 = "클라이언트가 접속했습니다";
            dos.writeUTF(welcomeMsg2);
            dos.flush();

            while (true){
                System.out.print("메세지를 입력하세요\n>> ");
                String msg = sc.nextLine();
                dos.writeUTF(msg);
                dos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
