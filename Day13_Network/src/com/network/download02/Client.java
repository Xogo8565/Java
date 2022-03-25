package com.network.download02;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String path = "/Volumes/My Passport/WorkSpace/Day13_Network/NetWork/Client/";

        try(Socket client = new Socket("192.168.20.14", 8000);
            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream())){

            while (true) {
                System.out.print("\n=== 파일 다운로드 프로그램 ===\n1. 파일 다운로드\n2. 파일 업로드\n3. 프로그램 종료\n메뉴 선택 >> ");
                String select = sc.nextLine();
                dos.writeUTF(select);
                dos.flush();

                if (select.equals("1")){
                    //#1 file[]의 사이즈 넘겨받기
                    int cnt = dis.readInt();
                    System.out.println("=== 파일 목록 ===");

                    //#2 파일의 목록 출력
                    for(int i = 0; i < cnt; i++){
                        System.out.println(dis.readUTF());
                    }

                    //#3 서버에 파일명 넘기
                    System.out.print("다운로드할 파일명 입력 >> ");
                    String fileName = sc.nextLine();

                    dos.writeUTF(fileName);
                    dos.flush();

                    //#4 파일 받기
                    boolean isFileExistInServer = dis.readBoolean();

                    if(isFileExistInServer){
                        int fileSize = dis.readInt();
                        byte[] bytes = new byte[fileSize];

                        dis.readFully(bytes);
                        System.out.println("받아 온 파일의 크기 : " + bytes.length);

                        try (FileOutputStream fos = new FileOutputStream(path+fileName)){

                            fos.write(bytes);
                            fos.flush();

                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }

                    //#5 결과 출력
                    System.out.println(dis.readUTF());

                } else  if(select.equals("2")){
                    // 업로드
                    File dir = new File(path);
                    File[] fileList = dir.listFiles();

                    System.out.println("=== 파일 목록 ===");
                    for(File file : fileList){
                        System.out.println(file.getName());
                    }

                    System.out.println("업로드할 파일 명 입력 >>");
                    String fileName = sc.nextLine();
                    dos.writeUTF(fileName);
                    dos.flush();

                    boolean isFileExistInClient = new File(path+fileName).exists();
                    dos.writeBoolean(isFileExistInClient);

                    if(isFileExistInClient){
                        try(FileInputStream fis = new FileInputStream(path+fileName)){

                            byte[] bytes =fis.readAllBytes();

                            int fileSize = bytes.length;
                            dos.writeInt(fileSize);

                            dos.write(bytes);
                            dos.flush();

                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }

                    System.out.println(dis.readUTF());

                }else if(select.equals("3")){
                    break;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
