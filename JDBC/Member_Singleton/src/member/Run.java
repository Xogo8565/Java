package member;

import Diary.DiaryDAO;
import Diary.DiaryDTO;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        MemberDAO memberDAO = MemberDAO.getInstance();
        DiaryDAO diaryDAO = DiaryDAO.getInstance();

        while (true) {
            System.out.print("\n=== 멤버 서비스 프로그램 ===\n1. 로그인\n2. 회원가입\n3. 회원탈퇴\n4. 프로그램 종료\n>> ");
            int menu = Integer.parseInt(scanner.nextLine());

            if (menu == 1) {

                System.out.print("ID 입력 >> ");
                String id = scanner.nextLine();
                System.out.print("PW 입력 >> ");
                String pw = scanner.nextLine();
                MemberDTO memberDTO = new MemberDTO(id, pw, null);

                try {
                    MemberDTO rs = memberDAO.login(memberDTO);
                    if (rs != null) {
                        System.out.println(rs.getNickname() + "님 환영합니다!");
                        while (true){
                            System.out.print("\n===서비스메뉴===\n1. 일기 쓰기\n２. 일기 조회\n3. 로그아웃\n>> ");
                            menu = Integer.parseInt(scanner.nextLine());

                            if (menu == 1) {
                                System.out.print("날짜 입력(yyyy-MM-dd 형식) >> ");
                                Date date = dateConvert(scanner.nextLine());
                                System.out.print("제목 입력 >> ");
                                String title = scanner.nextLine();
                                System.out.print("내용 입력 >> ");
                                String content = scanner.nextLine();

                                int diaryRs = diaryDAO.newDiary(new DiaryDTO(0, date, title, content));
                                if (diaryRs > 0) System.out.println("다이어리 저장 성공");
                                else System.out.println("다이어리 저장 실패");

                            } else if (menu == 2) {
                                System.out.print("\n1. 다이어리 no로 조회\n2. 다이어리 전체 조회\n>>");
                                menu = Integer.parseInt(scanner.nextLine());
                                if (menu == 1) {
                                    System.out.print("조회하실 다이어리 no를 입력하세요\n>>");
                                    int no = Integer.parseInt(scanner.nextLine());
                                    DiaryDTO diaryDTO = diaryDAO.select(no);
                                    if(diaryDTO!=null) System.out.println(diaryDTO.toString());
                                    else System.out.println("존재하지 않는 다이어리입니다.");

                                } else if (menu == 2) {
                                    ArrayList<DiaryDTO> arrayList = diaryDAO.selectAll();
                                    System.out.println("번호\t날짜\t\t\t제목\t\t내용");
                                    for (DiaryDTO diaryDTO : arrayList) {
                                        System.out.println(diaryDTO.toString());
                                    }
                                }
                            } else if (menu == 3) {
                                System.out.println("로그아웃합니다.");
                                break;
                            }
                        }
                    } else System.out.println("ID 혹은 PW를 잘못 입력하셨습니다.");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("DB 접속 오류");
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
                        System.out.print(rs.getNickname() + "님 정말로 탈퇴하시겠습니까(Y/N)?\n>>");
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

    public static Date dateConvert(String string) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return new Date(simpleDateFormat.parse(string).getTime());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
