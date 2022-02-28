import java.util.Scanner;

public class Operator_Practice05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름 : ");
        String name = sc.nextLine();
        System.out.print("학년(숫자만) : ");
        int schoolGrade = sc.nextInt();
        sc.nextLine();
        System.out.print("반(숫자만) : ");
        int classNum = sc.nextInt();
        sc.nextLine();
        System.out.print("번(숫자만) : ");
        int studentNum = sc.nextInt();
        sc.nextLine();
        System.out.print("성별(M/F) : ");
        String sex = sc.nextLine();
        System.out.print("성적(소수점 아래 둘째자리까지만) : ");
        double grade = sc.nextDouble();
        //3항연산식을 사용한 경우
        sex = sex.equals("M") ? "남학생" : "여학생";
        // sex : 참조변수, 스택영역에 저장 -> 주소값 저장 -> Heap 영역과 연결
        // Heap 영역에 "M"이라는 문자열 저장되어 있음
        // "남학생" or "여학생" 문자열이 새로 저장된 후, Garbage Collector 가 힙 영역에서 기존 "M" 이라는 값 삭제

        System.out.println(schoolGrade + "학년 "+classNum+"반 "+studentNum+" 번 "+ name + " 남학생의 성적은 " + grade +"이다.");

        //if문 을 사용한 경우
//        if(sex == 'M'){
//            System.out.println(schoolGrade + "학년 "+classNum+"반 "+studentNum+" 번 "+ name + " 남학생의 성적은 " + grade +"이다.");
//        } else {
//            System.out.println(schoolGrade + "학년 "+classNum+"반 "+studentNum+" 번 "+ name + " 여학생의 성적은 " + grade +"이다.");
//        }
    }

}
