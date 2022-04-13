package com.network.member;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try(Socket client = new Socket("192.168.20.14", 8000);
            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());){

            String welcomeMsg = dis.readUTF();
            System.out.println(welcomeMsg);

            while(true) {
                System.out.print("\n===== 메뉴 선택 =====\n1. 로그인\n2. 회원가입\n3. 종료\n>> ");
                String menu = sc.nextLine();

                dos.writeUTF(menu);
                dos.flush();

                if(menu.equals("1")) {//로그인
                    System.out.print("=== 로그인 ===\nID 입력 : ");
                    String id = sc.nextLine();
                    System.out.print("PW 입력 : ");
                    String pw = sc.nextLine();

                    dos.writeUTF(id);
                    dos.writeUTF(pw);
                    dos.flush();

                    // 결과 받기
                    String rs = dis.readUTF();

                    if(rs.equals("0")) {
                        System.out.println("로그인 성공");
                        while(true){
                            System.out.println("\n=====서비스 메뉴=====\n1. 오늘의 운세\n2. 오늘의 날씨\n3. 로또 번호\n4. 로그아웃\n메뉴 선택 >> ");
                            String selectNo = sc.nextLine();
                            dos.writeUTF(selectNo);
                            dos.flush();

                            if(selectNo.equals("4")){
                                System.out.println("로그아웃했습니다.");
                                break;
                            }

                            String service = dis.readUTF();
                            System.out.println(service);

                        }

                    }
                    else System.out.println("아이디 혹은 비밀번호 일치하지 않습니다.");


                } else if(menu.equals("2")){
                    System.out.print("===회원가입===\nID 입력 >> ");
                    String id = sc.nextLine();
                    System.out.print("PW 입력 >> ");
                    String pw = sc.nextLine();

                    dos.writeUTF(id);
                    dos.writeUTF(pw);
                    dos.flush();

                    String rs = dis.readUTF();

                    if(rs.equals("0")) System.out.println("회원가입에 성공했습니다.");
                    else System.out.println("이미 존재하는 회원입니다.");

                }
                else if(menu.equals("3")) {// 종료
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else System.out.println("잘못된 입력입니다");
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
