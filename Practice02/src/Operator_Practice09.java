import java.util.Scanner;

public class Operator_Practice09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수1 : ");
        int num1 = sc.nextInt();
        sc.nextLine();
        System.out.print("정수2 : ");
        int num2 = sc.nextInt();
        sc.nextLine();
        System.out.print("정수3 : ");
        int num3 = sc.nextInt();
        sc.nextLine();

        if(num3<=num1||num3>num2){
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
