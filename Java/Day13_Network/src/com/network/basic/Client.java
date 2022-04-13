package com.network.basic;

import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        //클라이언트 소켓 생성 시 두 가지 인자값 필요
        //1. 서버의 IP 주소(본인의 IP 주소일 경우 Localhost 로도 가능) 2. 서버에서 열어준 포트번호

        try(Socket client = new Socket("192.168.20.14", 8000);){

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
