import java.util.Scanner;

public class Exam01_Intro {
    public static void main(String[] args) {
        /*
        랜덤한 수를 생성할 수 있는 도구  ex_ 임시비밀번호 설정 등에 활용

        Math 클래스의 random() 메소드
        0.0 < Math.random() < 1.0
        값을 생성
         */

        // random 한 수 5개 생성
//        for(int i = 0; i<5; i++) {
//            System.out.println(Math.random());
//        }

        //지정한 숫자 범위 내에서 랜덤한 수를 뽑아내고 싶을 때
        //(int)((Math.random()*(Max-Min+1)+Min);

//        for(int i =0; i<=100; i++){
//            char c = (char)((Math.random()*(90-65+1))+65);
//            System.out.println(c);
//        }

        // 아스키 코드 ;
        // double * int -> double(자동) -> char(강제) 형으로 변환
        // 퀴즈 1 ~ 10 사이의 랜덤값을 뽑아내면 0> 사용자가 홀/짝을 입력
        // -> 홀짝 여부에 따라 사용자에게 전달

        Scanner sc =  new Scanner(System.in);
        int minValue = 1;
        int maxValue =10;

        while(true){
            int i = (int)((Math.random()*(maxValue-minValue+1))+minValue);
            System.out.print("******** 홀짝을 맞춰보세요(Q : 종료) ********\n"
                            +"  홀짝을 입력하세요 >> ");
            String numChoice = sc.nextLine();
            if(numChoice.equals("홀")){
                if (i%2==1) {
                    System.out.println("  생성된 숫자 >> " + i +
                                    "\n  정답입니다. 홀수입니다.");
                } else {
                    System.out.println("  생성된 숫자 >> " + i +
                                    "\n  틀렸습니다. 짝수입니다.");
                }
            } else if (numChoice.equals("짝")) {
                if(i%2==1){
                    System.out.println("  생성된 숫자 >> " + i +
                                    "\n  틀렸습니다. 홀수입니다.");
                } else {
                    System.out.println("  생성된 숫자 >> " + i +
                                    "\n  정답입니다. 짝수입니다.");
                }
            } else if (numChoice.equalsIgnoreCase("Q")) {
                System.out.println("  프로그램을 종료합니다");
                break;
            } else {
                System.out.println("  잘못 입력하셨습니다.");
            }

        }

    }
}
