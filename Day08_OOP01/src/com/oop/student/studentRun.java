package com.oop.student;

import java.util.Scanner;

public class studentRun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        student[] students = new student[100];
        int stuNo;
        String stuName;
        int stuAge;
        char stuSex;



        while (true){
            System.out.print("===== 학생 관리 프로그램 =====\n메뉴를 선택하세요. (종료버튼 : q)\n1. 학생 정보 등록\n2. 학생 목록 확인\n3. 학생 정보 수정\n4. 학생 정보 삭제\n>> ");
            String select = sc.nextLine();
            if(select.equals("1")){
                System.out.print("===== 학생 정보 등록 =====\n번호를 입력하세요 >> ");
                stuNo = Integer.parseInt(sc.nextLine());
                System.out.print("이름을 입력하세요 >> ");
                stuName = sc.nextLine();
                System.out.print("나이를 입력하세요 >> ");
                stuAge = Integer.parseInt(sc.nextLine());
                System.out.print("성별을 입력하세요(남/여)>> ");
                stuSex = sc.nextLine().charAt(0);

                for(int i =0; i<students.length; i++){
                    if(students[i]==null) {
                        students[i] = new student(stuNo-1, stuName, stuAge, stuSex);
                        break;
                    }
                }

            } else if (select.equals("2")) {
                System.out.println("===== 학생 목록 확인 =====");
                for(int i =0; i<students.length; i++){
                    if(students[i]!=null){
                        System.out.println(students[i].toString());
                    }
                }

            } else if (select.equals("3")){
                System.out.print("수정할 학생의 번호를 입력하세요 >> ");
                int editNum = Integer.parseInt(sc.nextLine()) - 1;
                for(int i = 0; i<students.length; i++){
                    if(students[editNum]==students[i]&&students[editNum]!=null){
                        System.out.print("이름을 입력하세요 >> ");
                        stuName = sc.nextLine();
                        System.out.print("나이를 입력하세요 >> ");
                        stuAge = Integer.parseInt(sc.nextLine());
                        System.out.print("성별을 입력하세요(남/여)");
                        stuSex = sc.nextLine().charAt(0);
                        students[editNum].setName(stuName);
                        students[editNum].setAge(stuAge);
                        students[editNum].setGender(stuSex);
                    } else if (students[editNum]== null) System.out.println("존재하지 않는 학생입니다.");
                    break;
                }
            } else if(select.equals("4")){
                System.out.print("===== 학생 정보 삭제 =====\n삭제할 학생의 번호를 입력해주세요.");
                int deleteNum = Integer.parseInt(sc.nextLine())-1;
                for(int i =0; i<students.length; i++){
                    if(students[deleteNum]!=null && students[deleteNum]==students[i]){
                        students[deleteNum ]= null;
                        System.out.println("삭제가 완료되었습니다.");
                        break;
                    } else if(students[deleteNum]==null) {
                        System.out.println("존재하지 않는 학생입니다.");
                        break;
                    }
                }
            } else if (select.equals("q")){
                System.out.println("프로그램을 종료합니다.");
                break;
            }

        }
    }
}
