import java.util.Scanner;

public class Exam02_For {
    public static void main(String[] args) {

        //언제까지 반복문을 돌려야 할 지 모르는 경우
        //1부터 사용자가 입력한 값까지 출력하는 코드를 작성

//        Scanner sc = new Scanner(System.in);
//        System.out.print("숫자를 입력해주세요 >> ");
//        int inputNum = sc.nextInt();
//        sc.nextLine();
//        for(int i = 1; i<=inputNum; i++){
//            System.out.println(i);
//        }

        // 1부터 사용자가 입력한 값까지 출력을 하되, 홀수만 출력
        // #1 출력문 안쪽에서 조건식을 통해 홂수만 걸러 출력
//        Scanner sc = new Scanner(System.in);
//        System.out.print("숫자를 입력해주세요 >> ");
//        int inputNum = sc.nextInt();
//        for(int i = 1; i<= inputNum; i++){
//            if(i % 2 == 1){
//                System.out.println(i);
//            }
//        }

        // #2 i = i+2(i+=2)
        // 증감식을 이용해 i를 2씩 증가시켜서 홀수로 만들기
//        for(int i = 1; i<=inputNum; i+=2){
//            System.out.println(i);
//        }

        // 1~3까지 숫자를 차례대로 출력하는데 2만 빼고출력
//        for(int i =1; i<4; i++){
//            if(i!=2){
//                System.out.println(i);
//            }
//        }
//        for(int i = 1; i < 4; i++){
//            if(i == 2){
//                continue;
//            }
//            System.out.println(i);
//        }
        //continue; -> 현재 진행되고 있는 반복 흐름이 종료
        //continue 를 만나자마자 현재 돌고 있는 바퀴의 끝 지점으로 건너 뛰게 됨
        // break; 와의 차이 -> break 면 1만 출력되고 멈춤(Loop 자체를 멈추게 된다.)


        // 사용자에게 입력값을 받을 것
        // 1부터 입력값까지의 전체 합을 출력

        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력하세요 >> ");
        int inputNum = sc.nextInt();
        sc.nextLine();

        //int sum;
        //***int sum -> 선언만 하지 말고 초기화도 필요함

        int sum = 0;

        // 지역변수 : 반복문/조건문 혹은 메서드(기능)의 { } 안 범위에서만 사용할 수 있는 변수
        // 같은 지역에서 선언된 변수는 얼마든지 같은 영역에서 가져다 사용 가능
        // 작은 지역에서 선언된 변수는 더 큰 지역에서 사용 x
        // 반면 더 큰 지역에서 선언된 변수는 더 작은 지역에서 사용 o

        for(int i = 0; i<=inputNum; i++){

            //sum 을 for 문 내부에서 선언하면 error 발생
            //반면, main 에서 선언된 변수를 for 문 내부에서 호출 시 오류발생하지 않음.
            //밴다이어그램에서 필요조건, 충분조건 생각할 것

            sum += i;
        }
        System.out.println(sum);
    }
}
