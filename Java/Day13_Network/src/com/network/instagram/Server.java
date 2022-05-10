package com.network.instagram;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        String path = "/Volumes/My Passport/WorkSpace/Day13_Network/NetWork/Server/";

        AccountDAO accountDAO = new AccountDAO();
        FeedDAO feedDAO = new FeedDAO();

        try(ServerSocket serverSocket = new ServerSocket(8000);
            Socket socket = serverSocket.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());){

            String welcome = "접속하신 것을 환영합니다.";

            dos.writeUTF(welcome);
            dos.flush();

            while(true){

                String menu = dis.readUTF();
                if(menu.equals("1")){

                    String id = dis.readUTF();
                    String pw = dis.readUTF();
                    System.out.println("로그인 요청");
                    System.out.println("ID : " +id+"\nPW : " +pw);

                    int login = accountDAO.Login(id, pw);

                    dos.writeInt(login);
                    dos.flush();

                    if(login==0){

                        AccountDTO accountDTO = accountDAO.getAccount(id, pw);
                        String nickname = accountDTO.nickname;

                        dos.writeUTF(nickname);
                        dos.flush();

                        while (true){

                            menu = dis.readUTF();

                            if(menu.equals("1")){

                                System.out.println("피드 등록 요청");
                                String feedName = dis.readUTF();
                                String feedContent = dis.readUTF();
                                System.out.println("FeedName : " + feedName +"\nFeedContent : " + feedContent +"\nNickname : " + nickname);
                                feedDAO.newFeed(feedName,feedContent,nickname);

                            } else if (menu.equals("2")){

                                menu = dis.readUTF();

                                if(menu.equals("1")){
                                    System.out.println("전체 피드 확인 요청");

                                    String allFeed = feedDAO.showAllFeed();
                                    dos.writeUTF(allFeed);
                                    dos.flush();

                                } else if (menu.equals("2")){

                                    int seq = dis.readInt();
                                    System.out.println(seq+"번 피드 확인 요청");

                                    String selectedFeed = feedDAO.showSelectFeed(seq);

                                    dos.writeUTF(selectedFeed);
                                    dos.flush();

                                }

                            } else if (menu.equals("3")){

                                System.out.println(nickname+"님 프로필 등록 요청");

                                int fileSize = dis.readInt();
                                byte[] bytes = new byte[fileSize];
                                dis.readFully(bytes);

                                try(FileOutputStream fos = new FileOutputStream(path+nickname + ".jpg")){

                                    fos.write(bytes);
                                    fos.flush();

                                }catch (Exception e){
                                    e.printStackTrace();
                                }

                                System.out.println(nickname+"프로필 등록 완료");


                            } else if(menu.equals("4")){

                                System.out.println(nickname + "님 프로필 확인 요청");

                                try(FileInputStream fis = new FileInputStream(path+nickname + ".jpg")) {

                                    byte[] bytes = fis.readAllBytes();
                                    int fileSize = bytes.length;

                                    dos.writeInt(fileSize);
                                    dos.flush();

                                    dos.write(bytes);

                                } catch (Exception e){
                                    e.printStackTrace();
                                }

                                System.out.println(nickname+"프로필 확인 완료");

                            } else if(menu.equals("5")){
                                System.out.println(nickname+"님 로그아웃");
                                break;
                            }

                        }

                    }

                } else if(menu.equals("2")){

                    String id = dis.readUTF();
                    String pw = dis.readUTF();
                    String nickname = dis.readUTF();

                    System.out.println("회원가입 요청");
                    System.out.println("ID : " +id+"\nPW : " +pw + "\nNickname : " +nickname);

                    int signUp = accountDAO.signUp(id,pw,nickname);

                    dos.writeInt(signUp);

                } else if(menu.equals("3")){

                    System.out.println("클라이언트의 접속 종료");
                    break;

                }

            }
            
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
