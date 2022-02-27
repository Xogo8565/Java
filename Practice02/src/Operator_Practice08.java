import java.util.Scanner;

public class Operator_Practice08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("주민번호를 입력하세요(- 포함) : ");
        char sex = sc.nextLine().charAt(7);
        if(sex==1) {
            System.out.println("남자");
        } else {
                System.out.println("여자");
        }
    }
}
