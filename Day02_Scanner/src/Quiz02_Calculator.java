import java.util.Scanner;

public class Quiz02_Calculator {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("===== 정수 사칙 연산 프로그램 ======");
        System.out.print("첫 번째 정수를 입력하세요 : ");
        int x = sc.nextInt();
        sc.nextLine();
        System.out.print("두 번째 정수를 입력하세요 : ");
        int y = sc.nextInt();
        sc.nextLine();

        System.out.println( x + "+" + y + "=" + (x+y));
        System.out.println( x + "-" + y + "=" + (x-y));
        System.out.println( x + "*" + y + "=" + (x*y));
        System.out.println( x + "/" + y + "=" + (x/y));
    }
}
