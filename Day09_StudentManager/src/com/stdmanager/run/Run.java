package com.stdmanager.run;
import com.stdmanager.dao.StudentDAO;
import com.stdmanager.dto.StudentDTO;

import java.util.Scanner;

public class Run {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            StudentDAO dao = new StudentDAO();

            int stuNo;
            String stuName;
            int stuAge;
            char stuGender;

            while (true){
                System.out.print("===== 학생 관리 프로그램 =====\n메뉴를 선택하세요. (종료버튼 : q)\n1. 학생 정보 등록\n2. 학생 목록 확인\n3. 학생 정보 수정\n4. 학생 정보 삭제\n>> ");
                String select = sc.nextLine();

                if(select.equals("1")){
                    System.out.print("===== 학생 정보 등록 =====\n번호를 입력하세요 >> ");
                    stuNo = Integer.parseInt(sc.nextLine())-1;
                    System.out.print("이름을 입력하세요 >> ");
                    stuName = sc.nextLine();
                    System.out.print("나이를 입력하세요 >> ");
                    stuAge = Integer.parseInt(sc.nextLine());
                    System.out.print("성별을 입력하세요(남/여)>> ");
                    stuGender = sc.nextLine().charAt(0);

                   StudentDTO std = new StudentDTO(stuNo, stuName, stuAge, stuGender);
                   dao.insert(std);

                } else if (select.equals("2")) {
                    StudentDTO[] list = dao.selectAll();

                    for(StudentDTO std : list){
                        if(std != null){
                            System.out.println(std);
                        }
                    }

                } else if (select.equals("3")){
                    System.out.print("수정할 학생의 번호를 입력하세요 >> ");
                    int editNum = Integer.parseInt(sc.nextLine()) - 1;
                    // 사용자가 입력한 번호가 존재하는ㅂ ㅓㄴ호인지 확인하는 메서드
                    System.out.print("이름을 입력하세요 >> ");
                    stuName = sc.nextLine();
                    System.out.print("나이를 입력하세요 >> ");
                    //Integer.parseInt -> 숫자가 아닌 입력값에 대한 처리 메서드
                    // => 사용자의 입력과 관련된 메서드이기 때문에 static 메서드로 run 클래스에 만들어야 함
                    stuAge = Integer.parseInt(sc.nextLine());
                    System.out.print("성별을 입력하세요(남/여)");
                    stuGender = sc.nextLine().charAt(0);

                    dao.modify(new StudentDTO(editNum, stuName, stuAge, stuGender));

                } else if(select.equals("4")){
                    System.out.print("===== 학생 정보 삭제 =====\n삭제할 학생의 번호를 입력해주세요.");
                    int deleteNum = Integer.parseInt(sc.nextLine())-1;

                    dao.delete(deleteNum);

                } else if (select.equals("q")){
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

            }
        }

}
