package com.netflix.run;
import com.netflix.dao.NetflixDAO;
import com.netflix.dto.Basic;
import com.netflix.dto.Membership;
import com.netflix.dto.Premium;
import com.netflix.dto.Standard;
import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        NetflixDAO dao = new NetflixDAO();
        String id;
        String nickname;

        while(true){
            System.out.print("\n===== NETFLIX 회원관리 프로그램 =====\n1. 신규 회원 등록\n2. 회원 목록 출력\n3. 회원 정보 검색\n4. 회원 정보 수정 \n5. 회원 정보 삭제\n6. 시스템 종료\n>> ");
            int selectNo = numberInput();
            if(selectNo==1){
                System.out.print("\n회원 등급 선택\n1. Basic\n2. Standard\n3. Premium\n>> ");
                int memGrade = numberInput();

                while (true){
                    System.out.print("신규회원 ID(7자 이내) : ");
                    id = sc.nextLine();
                    if(dao.isIdAlreadyExist(id)) {
                        System.out.println("중복된 아이디 입니다.");
                    } else break;
                }

                while (true) {
                    System.out.print("신규회원 닉네임(4자 이내) : ");
                    nickname = sc.nextLine();
                    if(dao.isNicknameAlreadyExist(nickname)){
                        System.out.println("중복된 닉네임입니다.");
                    } else break;
                }

                System.out.print("신규회원 가입일(210505 형식으로) :");
                String signUpDate = sc.nextLine();
                System.out.print("신규회원 포인트 : ");
                int point = numberInput();
                if(memGrade == 1) dao.addMember(new Basic(id, nickname,signUpDate,point));
                else if(memGrade == 2) dao.addMember(new Standard(id, nickname,signUpDate,point));
                else if(memGrade == 3) dao.addMember(new Premium(id, nickname,signUpDate,point));
                else System.out.println("\n잘못된 입력입니다.");

            } else if(selectNo==2){
                ArrayList<Membership> memberships = dao.selectAll();
                printAll(memberships);
            } else if(selectNo==3){
                //회원정보 검색
                System.out.print("\n1. ID로 검색\n2. 닉네임으로 검색\n>> ");
                int selectNo2 = numberInput();

                if(selectNo2 == 1){
                    System.out.print("\n겸색할 ID 입력 : ");
                   id = sc.nextLine();

                    if(dao.isIdAlreadyExist(id)){
                        System.out.println("ID\t등급\t닉네임\t가입일\t포인트\n"+dao.findMemberByID(id));
                    } else System.out.println("\n존재하지 않는 아이디입니다.");

                } else if(selectNo2 == 2){
                    System.out.print("\n검색할 닉네임 입력 : ");
                    nickname = sc.nextLine();

                    if(dao.isNicknameAlreadyExist(nickname)){
                        System.out.println("ID\t등급\t닉네임\t가입일\t포인트"+dao.findMemberByNickname(nickname));
                    } else System.out.println("\n존재하지 않는 아이디입니다");

                } else System.out.println("\n잘못된 입력입니다.");

            } else if(selectNo==4){
                //수정
                ArrayList<Membership> memberships = dao.selectAll();
                printAll(memberships);

                System.out.print("\n수정할 ID 입력 : ");
                id = sc.nextLine();

                if(dao.isIdAlreadyExist(id)) {
                    System.out.print("수정할 닉네임 : ");
                    nickname = sc.nextLine();

                    if(dao.isNicknameAlreadyExist(nickname)){
                        System.out.println("\n이미 존재하는 닉네임입니다.");
                    } else {
                        System.out.print("수정할 포인트 : ");
                        int point = numberInput();

                        dao.modifyMember(id, nickname,point);
                        System.out.println("\n변경이 완료되었습니다.");
                    }

                } else System.out.println("\n존재하지 않는 아이디입니다");

            } else if(selectNo==5){
                //삭제
                ArrayList<Membership> memberships = dao.selectAll();
                printAll(memberships);

                id = sc.nextLine();

                if(dao.isIdAlreadyExist(id)) {
                    dao.deleteMember(id);
                    System.out.println("\n삭제가 완료되었습니다.");
                }
                else System.out.println("\nID가 존재하지 않습니다.");
            }
            else if(selectNo==6){
                //종료
                System.out.println("\n프로그램을 종료합니다");
                break;
            } else {
                System.out.println("\n잘못된 입력입니다.");
            }
        }
    }

    public static int numberInput(){
        while (true) {
            try{
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e){
                System.out.print("\n숫자가 아닌 값은 입력할 수 없습니다.\n다시 입력해주세요\n>> ");
                sc = new Scanner(System.in);
//            e.printStackTrace();
            }
        }
    }

    public static void printAll(ArrayList<Membership> memberList){
        System.out.println("ID\t등급\t닉네임\t가입일\t포인트");
        for(Membership membership : memberList){
            System.out.println(membership);
        }
    }
}
