import java.util.Scanner;

public class Operator_Practice04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("인원 수 : ");
        int memNum = sc.nextInt();
        sc.nextLine();
        System.out.print("사탕 개수 : ");
        int candyNum = sc.nextInt();
        sc.nextLine();

        System.out.println("1인당 사탕 개수 :" + memNum);
        System.out.println("남는 사탕 개수 :" + candyNum);

    }
}
