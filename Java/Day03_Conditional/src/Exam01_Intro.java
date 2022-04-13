import java.util.Scanner;

public class Exam01_Intro {
    public static void main(String[] args) {
//       /*
//       조건문 : 조건에 따라서 특정 코드를 실행시킬 수도, 시키지 않을 수도 있음
//
//        if(조건식) {
//        조건식이 true 면 실행할 코드
//        } // 조건식이 false 면 { } 안쪽 코드 실행 x, 다만 조건식까지는 true or false 비교가 일어난다(실행 o).
//
//        */
////        if(1 == 1) {
////            System.out.println("True 입니다.");
////        }
////
////        if(1 != 1) {
////            System.out.println("False 입니다.");
////        }
//        // 스캐너를 이용해 사용자에게 정수 1개를 입력받음.
//        // 그리고 만약 입력된 수가 1이라면 "입력된 수는 1입니다" 를 출력
//        Scanner sc = new Scanner(System.in);
////        System.out.print("정수를 입력하세요 >> ");
////        int i = sc.nextInt();
////        sc.nextLine();
////
////        if(i ==1){
////            System.out.println("입력된 수는 1입니다.");
////        }
////        // 조건 추가 : 만약에 입력된 수가 2라면 "입력된 수는 2입니다." 출력
////        if(i==2){
////            System.out.println("입력된 수는 2입니다.");
////        }
//        /*
//        if (조건식 1) {
//        } else if (조건식 2) {
//        }
//        : if 부터 else if 까지 하나의 조건 묶음
//        위쪽부터 검사해 내려오면서 하나라도 조건이 충족하는 순간 조건의 묶음을 나가버린다 -> 조건 검사 종료
//         */
//        // else : 위 조건 모두 충족하지 않으면 실행되는 코드
//
//        if (i ==1){
//            System.out.println("입력된 값은 1입니다.");
//        } else if (i ==2) {
//            System.out.println("입력된 값은 2입니다.");
//        } else {
//            System.out.println("잘못된 입력입니다.");
//        }

        // 문자열 사전 프로그램
        // 사과라고 입력하면 apple 출력
        // 바나나라고 입력하면 banana 출력
        // 포도라고 입력하면 grape 출력
        // 그 외의 다른 단어를 입력하면 "등록된 단어가 없습니다."

        Scanner sc = new Scanner(System.in);
        System.out.println("단어를 입력하세요 :");
        String str = sc.nextLine();
        if (str.equals("사과")) {
            System.out.println("apple");
        } else if(str.equals("바나나")){
            System.out.println("banana");
        } else if(str.equals("포도")){
            System.out.println("grape");
        } else {
            System.out.println("등록된 단어가 없습니다.");
        }

    }

}
