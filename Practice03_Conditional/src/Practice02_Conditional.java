import java.util.Scanner;

public class Practice02_Conditional {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 입력하세요. : ");
        int num = sc.nextInt();
        sc.nextLine();
        if(num>=0){
            if(num%2==1){
                System.out.println("홀수다");
            } else {
                System.out.println("짝수다");
            }
        } else {
            System.out.println("양수만 입력해주세요.");
        }


    }
}
