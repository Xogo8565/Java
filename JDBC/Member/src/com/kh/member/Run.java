package com.kh.member;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        MemberDAO memberDAO = new MemberDAO();

        while (true) {
            System.out.print("\n=== 멤버 서비스 프로그램 ===\n1. 로그인\n2. 회원가입\n3. 회원탈퇴\n4. 프로그램 종료\n>> ");
            int menu = Integer.parseInt(scanner.nextLine());

            if (menu == 1) {
                while (true){
                    System.out.print("ID 입력 >> ");
                    String id = scanner.nextLine();
                    System.out.print("PW 입력 >> ");
                    String pw = scanner.nextLine();
                    MemberDTO memberDTO = new MemberDTO(id, pw, null);

                    try {
                        MemberDTO rs = memberDAO.login(memberDTO);
                        if (rs != null) {
                            System.out.println(rs.getNickname() + "님 환영합니다!\n오늘의 날씨는 흐림, 평균 온도는 12.5도입니다.");
                            break;
                        } else System.out.println("ID 혹은 PW를 잘못 입력하셨습니다.");
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("DB 접속 오류");
                    }
                }
            } else if (menu == 2) {

                System.out.print("회원가입\nID 입력 >> ");
                String id;
                while (true) {
                    id = scanner.nextLine();
                    if (!memberDAO.doesIdExist(id)) break;
                    else System.out.print("이미 존재하는 ID 입니다.\n다시 입력해주세요>> ");
                }
                System.out.print("PW 입력 >> ");
                String pw = scanner.nextLine();
                System.out.print("Nickname 입력 >> ");
                String nickname = scanner.nextLine();
                MemberDTO memberDTO = new MemberDTO(id, pw, nickname);

                try {
                    int rs = memberDAO.addMember(memberDTO);
                    if (rs > 0) System.out.println("회원가입 성공");
                    else System.out.println("회원가입 실패");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("DB 접속오류");
                }

            } else if (menu == 3) {

                System.out.print("탈퇴할 ID 입력 >> ");
                String id = scanner.nextLine();
                System.out.print("탈퇴할 PW 입력 >> ");
                String pw = scanner.nextLine();
                MemberDTO memberDTO = new MemberDTO(id, pw, null);

                try {
                    MemberDTO rs = memberDAO.login(memberDTO);

                    if (rs != null) {
                        System.out.print(rs.getNickname()+"님 정말로 탈퇴하시겠습니까(Y/N)?\n>>");
                        String answer = scanner.nextLine();
                        if (answer.equalsIgnoreCase("Y")) {
                            memberDAO.deleteMember(rs);
                            System.out.println("회원탈퇴 성공");
                        } else if (answer.equalsIgnoreCase("N")) {
                            System.out.println("초기 화면으로 돌아갑니다");
                        }
                    } else System.out.println("ID 혹은 PW를 잘못 입력하셨습니다.");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("DB 접속오류");
                }

            } else if (menu == 4) {
                System.out.println("프로그램 종료");
                break;
            }
        }
    }

}
