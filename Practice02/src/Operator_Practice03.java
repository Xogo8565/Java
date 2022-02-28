import java.util.Scanner;

public class Operator_Practice03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 : ");
        int i = sc.nextInt();
        if (i % 2 ==0){
            System.out.println("짝수다.");
        } else if (i % 2 == 1){
            System.out.println("홀수다");
        }
    }
}
