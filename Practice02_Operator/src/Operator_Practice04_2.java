import java.util.Scanner;

public class Operator_Practice04_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("인원 수 : ");
        int memNum = Integer.parseInt(sc.nextLine());
        System.out.print("사탕 개수 : ");
        int candyNum = Integer.parseInt(sc.nextLine());

        System.out.println("1인당 사탕 개수 :" + memNum);
        System.out.println("남는 사탕 개수 :" + candyNum);

    }
}
