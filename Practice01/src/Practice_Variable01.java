import java.util.Scanner;

public class Practice_Variable01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("성별을 입력하세요(남/여) : ");
        char sex = sc.nextLine().charAt(0);
        System.out.print("나이를 입력하세요 : ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("키를 입력하세요 : ");
        double height = sc.nextDouble();
        sc.nextLine();

        System.out.println("키 " + height + "cm인 " + age + "살 " + sex + "자 " + name+ "님 반갑습니다. ^^");
    }
}
