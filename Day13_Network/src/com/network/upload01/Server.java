package com.network.upload01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        String path = "/Volumes/My Passport/WorkSpace/Day13_Network/NetWork/Server/";

        try(ServerSocket serverSocket = new ServerSocket(8000);
            Socket socket = serverSocket.accept();
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());){

            String fileName = dis.readUTF();
            int fileSize = dis.readInt();
            byte[] bytes = new byte[fileSize];

            // 파일 받아주기
            dis.readFully(bytes);

            // 서버에 저장
            try(FileOutputStream fos = new FileOutputStream(path+System.currentTimeMillis()+"_"+fileName)){
                fos.write(bytes);
                fos.flush();
            } catch (Exception e){
                e.printStackTrace();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
