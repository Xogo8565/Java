package com.network.download02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        String path = "/Volumes/My Passport/WorkSpace/Day13_Network/NetWork/Server/";


        try(ServerSocket serverSocket = new ServerSocket(8000);
            Socket socket = serverSocket.accept();
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());) {

            System.out.println(socket.getLocalAddress() + "님 접속");

            while (true){
                String select = dis.readUTF();
                if(select.equals("1")) {

                    //#1 fileList 사이즈 넘기기
                    File dir = new File(path);
                    File[] fileList = dir.listFiles();

                    dos.writeInt(fileList.length);
                    dos.flush();

                    //#2 파일 목록 넘기기
                    for (File f : fileList) {
                        //f.getName() -> 해당 파일의 이름을 반환
                        //클라이언트에게 이 이름들을 전송
                        dos.writeUTF(f.getName());
                    }
                    dos.flush();

                    // #3 클라이언트가 요청한 파일명 받기
                    String fileName = dis.readUTF();
                    System.out.println("다운로드 요청 : " + fileName);

                    // #4 서버에서 일치하는 파일 넘기기
                    // #4-1 파일 존재 여부 확인
                    boolean isFileExistInServer = new File(path+fileName).exists();
                    dos.writeBoolean(isFileExistInServer);
                    dos.flush();

                    // 4-2 파일 넘기기
                    String rs = "";
                    if (isFileExistInServer) {
                        try (FileInputStream fis = new FileInputStream(path + fileName);) {

                            byte[] bytes = fis.readAllBytes();
                            int fileSize = bytes.length;

                            dos.writeInt(fileSize);
                            dos.write(bytes);
                            dos.flush();

                            rs = "다운로드 성공";

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else rs = "파일이 존재하지 않습니다.";

                    //#5 결과 출력
                    dos.writeUTF(rs);
                    dos.flush();

                } else if (select.equals("2")) {
                    //업로드
                    String fileName = dis.readUTF();
                    System.out.println("파일 업로드 요청 :" + fileName);

                    boolean isFileExistInClient = dis.readBoolean();

                    String rs = "";

                    if(isFileExistInClient) {
                        int fileSize = dis.readInt();
                        byte[] bytes = new byte[fileSize];

                        dis.readFully(bytes);
                        //서버에 저장

                        try(FileOutputStream fos = new FileOutputStream(path+System.currentTimeMillis()+"_"+fileName)){
                            fos.write(bytes);
                            fos.flush();
                            rs = "파일 업로드 성공";

                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    } else rs = "파일 업로드 실패";

                    dos.writeUTF(rs);
                    dos.flush();


                } else if (select.equals("3")) {
                    System.out.println("클라이언트 접속 종료");
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
