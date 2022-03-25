package com.network.service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Server {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(8000);
             Socket socket = serverSocket.accept();
             DataInputStream dis = new DataInputStream(socket.getInputStream());
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream());){

            String welcomeMsg = "접속하신 것을 환영합니다.";
            dos.writeUTF(welcomeMsg);
            dos.flush();

            while(true){
                String selectNo = dis.readUTF();
                String rs;

                if(selectNo.equals("1")) rs = "오늘의 운세는 대길입니다.";
                else if(selectNo.equals("2")) rs = "오늘의 날씨는 맑음입니다.";
                 else if(selectNo.equals("3")){

                    HashSet<Integer> lotto = getLotto();
                    String lottoList = "";
                    Iterator iterator = lotto.iterator();

                    while (iterator.hasNext()){
                        lottoList+=iterator.next()+" ";
                    }

                    rs = "로또 번호는 "+ lottoList+"입니다.";

                } else if(selectNo.equals("4")){

                    System.out.println("클라이언트의 접속이 끊어졌습니다.");
                    break;

                } else rs = "잘못된 입력입니다.";

                dos.writeUTF(rs);
                dos.flush();

            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }
//    //1. Math.random() 이용
//    public static int[] getLotto (){
//        int[] lotto = new int[6];
//        for(int i =0; i<lotto.length; i++){
//            lotto[i] = (int)(Math.random()*6+1);
//        }
//        return lotto;
//    }
    //2

    public static HashSet<Integer> getLotto(){
        Random random = new Random();
        //random.nextInt(N) 함수~N 미만의 랜덤한 수를 반환해주는 메서드
        HashSet<Integer> lotto = new HashSet<>();
        // 컬렉션 -> 중복되지 않는 값만 저장되는 저장소(HashSet)
        // + 값이 순서대로 저장되지 않음

        for(int i = 0; lotto.size() < 6; i++){
            lotto.add(random.nextInt(44)+1);
        }

        return lotto;

    }
}
