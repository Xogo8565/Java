import java.util.Scanner;

public class Quiz04 {
    public static void main(String[] args) {
        /*
        1~100 사이의 두가지 숫자를 입력받아 연산결과를 출력하는 계산기 만들기
        조건 1 : 두 정수 모두 1~100 사이
        조건 2 : 사칙 연산자 검사
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("===== 정수 사칙연산 프로그램 (1~100 사이 입력) =====");
        System.out.print("첫 번째 정수를 입력해 주세요 >> ");
        int num1 = Integer.parseInt(sc.nextLine());
        // 숫자 1 조건 설정
        if (num1 <= 0  || num1 > 100) {
            System.out.println("잘못된 입력입니다. 프로그램을 종료합니다.");
        } else {
            //숫자 2 조건 설정
            System.out.print("두 번째 정수를 입력하세요 >> ");
            int num2 = Integer.parseInt(sc.nextLine());
            if(num2 <= 0  || num2 > 100){
                System.out.println("잘못된 입력입니다. 프로그램을 종료합니다.");
            } else {
                //연산 작동
                System.out.print("연산자를 입력해주세요 (+, -, *, /, %) >> ");
                String operator = sc.nextLine();
                if(operator.equals("+")){
                    System.out.print("연산 결과 : " + (num1 + num2));
                } else if(operator.equals("-")){
                    System.out.print("연산 결과 : " + (num1 - num2));
                } else if(operator.equals("*")){
                    System.out.print("연산 결과 : " + (num1 * num2));
                } else if (operator.equals("/")){
                    System.out.print("연산 결과 : " + (num1 / num2));
                } else if (operator.equals("%")){
                    System.out.print("연산 결과 : " + (num1 % num2));
                } else {
                    System.out.println("잘못된 입력입니다. 프로그램을 종료합니다.");
                }
            }
        }
    }
}
