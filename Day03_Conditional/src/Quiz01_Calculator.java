import java.util.Scanner;

public class Quiz01_Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("===== 계산기 프로그램 =====");
        System.out.print("숫자 입력 1 : ");
        int x = sc.nextInt();
        sc.nextLine();
        System.out.print("숫자 입력 2 : ");
        int y = sc.nextInt();
        sc.nextLine();
        System.out.print("연산자 입력(+,-,*,/) : " );
        String selectOpt = sc.nextLine();
        if (selectOpt.equals("+")){
            System.out.println(x+"+"+y+"="+(x+y));
        } else if(selectOpt.equals("-")){
            System.out.println(x+"+"+y+"="+(x-y));
        } else if(selectOpt.equals("*")){
            System.out.println(x+"+"+y+"="+(x*y));
        } else {
            System.out.println(x+"+"+y+"="+(x/y));
        }
    }
}
