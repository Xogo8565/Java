import java.util.Scanner;

public class Practice_Variable02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("첫 번째 정수 : ");
        int i = sc.nextInt();
        sc.nextLine();
        System.out.print("두 번째 정수 : ");
        int j = sc.nextInt();
        sc.nextLine();

        System.out.println("덧셈 결과 : " +(i+j));
        System.out.println("뺄셈 결과 : " +(i-j));
        System.out.println("곱셈 결과 : " +(i*j));
        System.out.println("나눗셈 결과 : " +(i/j));
    }
}
