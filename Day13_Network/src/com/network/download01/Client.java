package com.network.download01;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        String path = "/Volumes/My Passport/WorkSpace/Day13_Network/NetWork/Client/";

        try(Socket socket = new Socket("192.168.20.14",8000);
            DataInputStream dis = new DataInputStream(socket.getInputStream())) {

            /*
            서버가 전송한 파일 받기
            클라이언트의 HDD 에 파일을 저장(출력)
             */

            int size = dis.readInt();
            byte[] bytes = new byte[size]; // Server 측에서 보낸 바이트 배얼 크기의 배열 생성

            dis.readFully(bytes);
            System.out.println("받아 온 파일의 크기 : "+bytes.length);

            try(FileOutputStream fos = new FileOutputStream(path + "img.jpeg");){

                fos.write(bytes);
                fos.flush();

                System.out.println("다운로드 성공");

            }catch (Exception e){
                e.printStackTrace();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
