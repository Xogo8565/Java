package com.network.upload01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        // 클라이언트의 파일을 서버에 업로드
        Scanner sc = new Scanner(System.in);
        String path = "/Volumes/My Passport/WorkSpace/Day13_Network/NetWork/Client/";

        try(Socket socket = new Socket("192.168.20.14", 8000);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());){
            System.out.print("업로드할 파일의 이름을 입력하세요\n>>");
            String fileName = sc.nextLine();
            dos.writeUTF(fileName);
            dos.flush();

            try(FileInputStream fis = new FileInputStream(path+fileName)){

                // HDD 에서 파일 읽어오기
                byte[] bytes =fis.readAllBytes();
                int fileSize = bytes.length;

                //파일 사이즈 보내기
                dos.writeInt(fileSize);

                //파일 보내기
                dos.write(bytes);
                dos.flush();

            }catch (Exception e){
                e.printStackTrace();
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
