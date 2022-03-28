package com.network.instagram;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String path = "/Volumes/My Passport/WorkSpace/Day13_Network/NetWork/Client/";

        try(Socket socket = new Socket("localhost", 8000);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());){

            String welcome = dis.readUTF();
            System.out.println(welcome);

            while(true){

                System.out.print("\n=== 메뉴 선택 ===\n1. 로그인\n2. 회원가입\n3. 프로그램 종료\n>> ");
                String menu = sc.nextLine();
                dos.writeUTF(menu);
                dos.flush();

                if(menu.equals("1")){

                    System.out.print("=== 로그인 ===\nID :");
                    String id = sc.nextLine();
                    System.out.print("PW : ");
                    String pw = sc.nextLine();

                    dos.writeUTF(id);
                    dos.writeUTF(pw);
                    dos.flush();

                    int login = dis.readInt();

                    if(login==0){

                        System.out.println("로그인 성공");

                        String nickname = dis.readUTF();
                        System.out.println(nickname+"님 어서오세요");

                        while (true){

                            System.out.print("\n=== Instagram ===\n1. 피드 등록\n2. 피드 확인\n3. 프로필 등록\n4. 프로필 확인\n5. 프로그램 종료\n>> ");
                            menu = sc.nextLine();

                            dos.writeUTF(menu);
                            dos.flush();

                            if(menu.equals("1")){

                                System.out.print("제목을 입력하세요(10자 이내) >> ");
                                String feedName = sc.nextLine();
                                System.out.print("내용을 입력하세요 >> ");
                                String feedContent = sc.nextLine();

                                dos.writeUTF(feedName);
                                dos.writeUTF(feedContent);
                                dos.flush();

                            }else if (menu.equals("2")){

                                System.out.println("1. 전체 피드 목록\n2. 개별 피드 목록");
                                menu = sc.nextLine();

                                dos.writeUTF(menu);
                                dos.flush();

                                if(menu.equals("1")){

                                    String feedList = dis.readUTF();
                                    System.out.println("=== 전체 피드 목록 ===\n글번호\t닉네임\t작성일\t제목\t내용\n" + feedList);

                                } else if (menu.equals("2")){

                                    System.out.print("확인할 피드의 seq 입력 >>");
                                    int seq = Integer.parseInt(sc.nextLine());

                                    dos.writeInt(seq);
                                    dos.flush();

                                    String selectedFeed =  dis.readUTF();

                                    System.out.println("글번호\t닉네임\t작성일\t제목\t내용\n"+selectedFeed);

                                }

                            } else if (menu.equals("3")){

                                System.out.print("등록하실 파일의 경로를 입력하세요(jpg만 가능) >>");
                                String fileName = sc.nextLine();

                                try(FileInputStream fis = new FileInputStream(path + fileName)){
                                    byte[] bytes = fis.readAllBytes();
                                    int fileSize = bytes.length;

                                    dos.writeInt(fileSize);
                                    dos.write(bytes);


                                } catch (Exception e){
                                    e.printStackTrace();
                                }

                            } else if(menu.equals("4")){

                                System.out.println("내 프로필 다운로드 ");

                                int fileSize = dis.readInt();
                                byte[] bytes = new byte[fileSize];

                                dis.readFully(bytes);

                                try(FileOutputStream fos = new FileOutputStream(path+nickname+".jpg")){

                                    fos.write(bytes);
                                    dos.flush();

                                }catch (Exception e){
                                    e.printStackTrace();
                                }

                            } else if(menu.equals("5")){

                                System.out.println("로그아웃");
                                break;

                            } else System.out.println("잘못된 입력입니다.");
                        }
                    } else System.out.println("아이디 혹은 비밀번호가 일치하지 않습니다.");

                } else if(menu.equals("2")){

                    System.out.print("=== 회원가입 ===\nID : ");
                    String id = sc.nextLine();
                    System.out.print("비밀번호 : ");
                    String pw = sc.nextLine();
                    System.out.print("닉네임 : ");
                    String nickname = sc.nextLine();

                    dos.writeUTF(id);
                    dos.writeUTF(pw);
                    dos.writeUTF(nickname);
                    dos.flush();

                    int signUp = dis.readInt();

                    if(signUp==0) System.out.println("회원가입 성공");
                    else if(signUp==-1) System.out.println("이미 사용중인 ID 입니다.");
                    else System.out.println("이미 사용중인 닉네임입니다.");

                } else if(menu.equals("3")){

                    System.out.println("프로그램을 종료합니다.");
                    break;

                } else System.out.println("잘못 입력하셨습니다.");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
