import java.util.Scanner;

public class Operator_Practice01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 : ");
        int i = sc.nextInt();
        if (i > 0){
            System.out.println("양수다.");
        } else if (i == 0){
            System.out.println("0이다");
        } else{
            System.out.println("양수가 아니다.");
        }

    }
}
