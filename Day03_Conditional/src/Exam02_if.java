import java.util.Scanner;

public class Exam02_if {
    public static void main(String[] args) {
        // 좀 더 복잡한 조건문
        // 입력값 -> 사용자가 입력한 값이 50보다 작다면 1을 출력
        // 50 이상이라면 2를 출력
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력하시오 :  ");
        int input = sc.nextInt();
        sc.nextLine();
//        if(input<50){
//            System.out.println("1");
//        } else {
//            System.out.println("2");
//        }
        // 입력된 값이 0~50이면 1을 출력
        // 51~100 이면 2를 출력
//
//        if(input>=0 && input<=50){
//            System.out.println("1");
//        } else if (input>=51 && input<=100){
//            System.out.println("2");
//        } else {
//            System.out.println("잘못 입력하셨습니다.");
//        }
//
        // 입력된 점수에 따라 해당하는 결과 출력
        // 100 : 학업우수상
        // 70~99 : 시험통과
        // 69점 이하 : 재시험 대상
        // - 그 중 30점 이하 : 보충 학습 대상자
        if(input==100){
            System.out.println("학업 우수상");
        } else if(input>=70 && input<=99){
            System.out.println("시험 통과");
        } else if(input<=69) {
            System.out.println("재시험 대상자");
            if (input <= 30) {
                System.out.println("보충 학습 대상자");
            }

        }

        //중첩 if 문
        // 90점 이상 학생이라면 A출력
        // 95점 이상 학생이라면 학업 우수상 주겠다

//        int score= 100;
//        if(score>=90){
//            System.out.println("A");
//            if(score>=95){
//                System.out.println("학업우수상");
//                if(score == 100){
//                    System.out.println("만점");
//                }
//            }
//        }

    }
}
