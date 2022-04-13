package student;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO studentDao = StudentDAO.getInstance();
        while (true) {
            System.out.print("\n== 학생 관리 프로그램 ==\n1. 학생 등록 \n2. 학생 정보 수정\n3. 학생 정보 삭제\n4. 학생 정보 조회\n5. 프로그램 종료\n>> ");
            int menu = Integer.parseInt(sc.nextLine());
            if (menu == 1) { // 등록
                System.out.print("\n학생 등록\n학생명을 입력하세요\n>> ");
                String name = sc.nextLine();
                System.out.print("휴대전화 번호를 입력하세요\n>> ");
                String phone = sc.nextLine();
                System.out.print("생일을 입력하세요\n>> ");
                Date birth_date = DateConvert(sc.nextLine());

                StudentDTO dto = new StudentDTO(0, name, phone, birth_date);

                try {
                    int rs = studentDao.insert(dto);
                    if (rs > 0) System.out.println("학생 정보 등록 성공");
                    else System.out.println("학생 정보 등록 실패");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("DB 접속 오류");
                }

            } else if (menu == 2) { // 수정
                System.out.print("\n학생 정보 수정\n정보를 수정할 학생 번호를 입력하세요\n>> ");
                int no = Integer.parseInt(sc.nextLine());
                System.out.print("학생명을 입력하세요\n>> ");
                String name = sc.nextLine();
                System.out.print("휴대전화 번호를 입력하세요\n>> ");
                String phone = sc.nextLine();
                System.out.print("생일을 입력하세요\n>> ");
                String dateStr = sc.nextLine();
                Date birth_date = DateConvert(sc.nextLine());

                StudentDTO dto = new StudentDTO(no, name, phone, birth_date);

                try {
                    int rs = studentDao.update(dto);
                    if (rs > 0) System.out.println("학생 정보 수정 성공");
                    else System.out.println("학생 정보 수정 실패");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("DB 접속 오류");
                }
            } else if (menu == 3) {
                System.out.print("\n학생 정보 삭제\n정보를 삭제할 학생 번호를 입력하세요\n>> ");
                int no = Integer.parseInt(sc.nextLine());
                try {
                    int rs = studentDao.delete(no);
                    if (rs > 0) System.out.println("학생 정보 삭제 성공");
                    else System.out.println("학생 정보 삭제 실패");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("DB 접속 오류");
                }

            } else if (menu == 4) {
                System.out.print("\n학생 정보 조회\n1. 전체 학생 조회\n2. 선택 학생 조회\n>> ");
                menu = Integer.parseInt(sc.nextLine());
                if (menu == 1) {
                    try {
                        ArrayList<StudentDTO> arrayList = studentDao.selectAll();
                        for (StudentDTO studentDTO : arrayList) {
                            System.out.println(studentDTO.toString());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("DB 접속 실패");
                    }
                } else if (menu == 2) {
                    System.out.print("조회하실 학생의 번호를 입력하세요\n>> ");
                    int no = Integer.parseInt(sc.nextLine());
                    try {
                        StudentDTO studentDTO = studentDao.select(no);
                        if (studentDTO != null) System.out.println(studentDTO);
                        else System.out.println("존재하지 않는 학생입니다.");
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("DB 접속 실패");
                    }
                }

            } else if (menu == 5) {
                System.out.println("프로그램 종료");
                break;
            }
        }
    }

    public static Date DateConvert(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{//parse -> java.util.Date 타입 반환
            //getTime -> java.sql.Date 타입으로 반환
            return new Date(sdf.parse(dateStr).getTime());
        } catch (Exception e){
            e.printStackTrace();
        } return null;
    }
}
