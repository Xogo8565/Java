import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class Exam03_While {
    public static void main(String[] args) {
        /*
        while(조건식){
        실행할 코드
        }
        -> for 문과 같은 역할(반복) -> 초기식 x, 증감식 x
        -> 보통 언제까지 코드를 반복해야 할 지 모를 때
        -> 특별한 일이 일어나기 전까지 코드를 계속해서 반복해야 할 때
         */

        //사용자가 q라고 입력할 때까지 계속 1을 출력
        Scanner sc = new Scanner(System.in);
//        for(int i;;i++)
//        System.out.print("입력 >>");
//            String input = sc.nextLine();
//            if(input.equalsIgnoreCase("q")){
//                break;
//            }
//            System.out.println("1");
//        }

        // while 을 사용할 때 특정 조건이 충족되면 set 로 써줘야 하는 분기문

//        while(true){
//            System.out.print("입력 >> ");
//            String input = sc.nextLine();
//            //break; 필수
//            if(input.equalsIgnoreCase("q")){
//                break;
//            }
//            System.out.println("1");
//        }

        /*
        while(false){
         }

         if(false){
         }
         */

        //for 문을 if 문처럼 활용

        int i = 0;
        while(i<2){
            System.out.println("a");
            i++;
        }

    }
}
