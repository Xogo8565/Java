import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
                System.out.print("숫자를 입력하세요 >> ");
            try {
                int num = sc.nextInt();
                System.out.println(num);
            } catch (InputMismatchException ime) {
                sc = new Scanner(System.in);
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
