package com.netflix.run;
import com.netflix.dao.NetflixDAO;
import com.netflix.dto.Basic;
import com.netflix.dto.Premium;
import com.netflix.dto.Standard;
import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NetflixDAO dao = new NetflixDAO();

        while(true){
            System.out.print("\n===== NETFLIX 회원관리 프로그램 =====\n1. 신규 회원 등록\n2. 회원 목록 출력\n3. 회원 정보 검색\n4. 회원 정보 수정 \n5. 회원 정보 삭제\n6. 시스템 종료\n>> ");
            int selectNo = dao.numberConvert(sc.nextLine());
            if(selectNo==1){
                System.out.print("\n회원 등급 선택\n1. Basic\n2. Standard\n3. Premium\n>> ");
                int memGrade = dao.numberConvert(sc.nextLine());
                System.out.print("신규회원 ID(7자 이내) : ");
                String id = sc.nextLine();
                System.out.print("신규회원 닉네임(4자 이내) : ");
                String nickName = sc.nextLine();

                if(dao.isIdAlreadyExist(id)) System.out.println("이미 존재하는 아이디입니다.");
                else if(dao.isNickNameAlreadyExist(nickName)) System.out.println("이미 존재하는 닉네임입니다.");
                else {
                    System.out.print("신규회원 가입일(210505 형식으로) :");
                    String signUpDate = sc.nextLine();
                    System.out.print("신규회원 포인트 : ");
                    int point = dao.numberConvert(sc.nextLine());
                    if(memGrade == 1 && point != -1) dao.addMember(new Basic(id,nickName,signUpDate,point));
                    else if(memGrade == 2 && point != -1) dao.addMember(new Standard(id,nickName,signUpDate,point));
                    else if(memGrade == 3 && point != -1) dao.addMember(new Premium(id,nickName,signUpDate,point));
                    else System.out.println("잘못 입력하셨습니다.");
                }
            } else if(selectNo==2){
                ArrayList memberList = dao.selectAll();
                System.out.println("ID\t등급\t닉네임\t가입일\t포인트");
                for(int i = 0; i<memberList.size();i++){
                    System.out.println(memberList.get(i));
                }

            } else if(selectNo==3){
                //회원정보 검색
                System.out.print("\n1. ID로 검색\n2. 닉네임으로 검색\n>> ");
                int selectNo2 = dao.numberConvert(sc.nextLine());

                if(selectNo2 == 1){
                    System.out.print("겸색할 ID 입력 : ");
                    String id = sc.nextLine();

                    if(dao.isIdAlreadyExist(id)){
                        System.out.println("ID\t등급\t닉네임\t가입일\t포인트");
                        System.out.println(dao.findMemberByID(id));;
                    } else System.out.println("존재하지 않는 아이디입니다.");

                } else if(selectNo2 == 2){
                    System.out.print("검색할 닉네임 입력 : ");
                    String nickName = sc.nextLine();

                    if(dao.isNickNameAlreadyExist(nickName)){
                        System.out.println("ID\t등급\t닉네임\t가입일\t포인트");
                        System.out.println(dao.findMemberBynickName(nickName));;
                    } else System.out.println("존재하지 않는 아이디입니다");

                } else System.out.println("잘못 입력하셨습니다.");

            } else if(selectNo==4){
                //수정
                System.out.print("수정할 ID 입력 : ");
                String id = sc.nextLine();
                if(dao.isIdAlreadyExist(id)) {
                    System.out.print("수정할 닉네임 : ");
                    String nickName = sc.nextLine();

                    if(dao.isNickNameAlreadyExist(nickName)){
                        System.out.println("이미 존재하는 닉네임입니다.");
                    } else {
                        System.out.print("수정할 포인트 : ");
                        int point = dao.numberConvert(sc.nextLine());
                        if(point!=-1){
                            dao.modifyMember(id,nickName,point);
                            System.out.println("변경이 완료되었습니다.");
                        }
                    }

                } else System.out.println("존재하지 않는 아이디입니다");

            } else if(selectNo==5){
                //삭제
                System.out.print("\n삭제할 ID 입력 : ");
                String id = sc.nextLine();

                if(dao.isIdAlreadyExist(id)) {
                    dao.deleteMember(id);
                    System.out.println("삭제가 완료되었습니다.");
                }
                else System.out.println("ID가 존재하지 않습니다.");
            }
            else if(selectNo==6){
                //종료
                System.out.println("프로그램을 종료합니다");
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
