import java.util.Scanner;

public class Quiz01_PrintName {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // q를 누르면 종료
        // manager -> 매니저님 오셨어요?
        // else -> ~님 어서 오세요
//        for(int i=0;;i++){
//            System.out.println("** 입장을 종료하려면 q를 입력하세요 **");
//            System.out.print("닉네임을 입력하세요 >> ");
//            String input = sc.nextLine();
//            //equalsIgnoreCase()
//            //toUpperCase(),toLowerCase()
//            if (input.equalsIgnoreCase("q")) {
//                System.out.println("프로그램을 종료합니다");
//                break;
//            } if (input.toUpperCase().equals("MANAGER")) {
//                System.out.println(input+"님 오셨어요?");
//                continue;
//                // continue 활용에 대해 고민해 볼 것. else 로 받는 방법도 있지만 continue 활용하는 방법도 존재함.
//            }
//                System.out.println(i + ": " + input +"님 어서오세요!!");
//        }

        //while 문의 경우
        while(true){
            System.out.println("입장을 종료하려면 q를 입력하세요 **");
            System.out.print("닉네임을 입력하세요 >> ");
            String input = sc.nextLine();

            if(input.equalsIgnoreCase("q")){
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            if (input.equalsIgnoreCase("MANAGER")) {
                System.out.println(input+"님 오셨어요?");
               continue;
            }
                System.out.println( input+"님 어서오세요!!");
        }
    }
}
