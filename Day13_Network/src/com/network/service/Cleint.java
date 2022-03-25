package com.network.service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cleint {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try(Socket socket = new Socket("192.168.20.14", 8000);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream())){

            String welcomeMsg = dis.readUTF();
            System.out.println(welcomeMsg);

            //서버를 통해 제공받을 수 있는 서비스 메뉴를 띄워주기
            while(true){
                System.out.println("\n=====서비스 메뉴=====\n1. 오늘의 운세\n2. 오늘의 날씨\n3. 로또 번호\n4. 종료\n메뉴 선택 >> ");
                String selectNo = sc.nextLine();
                dos.writeUTF(selectNo);
                dos.flush();

                if(selectNo.equals("4")){
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

                String rs = dis.readUTF();
                System.out.println(rs);

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
