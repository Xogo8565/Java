import java.util.Scanner;

public class Operator_Practice10 {
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        System.out.print("입력 1 : ");
        int num1 = sc.nextInt();
        System.out.print("입력 2 : ");
        int num2 = sc.nextInt();
        System.out.print("입력 3 : ");
        int num3 = sc.nextInt();

        if(num1==num2&&num2==num3){
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
