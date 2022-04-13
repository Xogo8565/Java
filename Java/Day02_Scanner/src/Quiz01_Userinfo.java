import java.util.Scanner;

public class Quiz01_Userinfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("인사말을 입력하세요");
        System.out.print(">> ");
        String hello = sc.nextLine();
        System.out.println("이름을 입력하세요");
        System.out.print(">> ");
        String name = sc.nextLine();
        System.out.println("영문이름을 입력하세요");
        System.out.print(">> ");
        String engName = sc.nextLine();
        System.out.println("나이를 입력하세요");
        System.out.print(">> ");
        int age = Integer.parseInt(sc.nextLine());
//        int age = sc.nextInt();
//        sc.nextLine();
        System.out.println("체온측정결과를 입력하세요");
        System.out.print(">> ");
        double degree = Double.parseDouble(sc.nextLine());
//        double degree = sc.nextDouble();
//        sc.nextLine();

        System.out.println(hello);
        System.out.println("저의 이름은 " + name + "입니다." + "영어 이름은 " + engName+ " 입니다.");
        System.out.println("제 나이는 " + age + "살 입니다");
        System.out.println("오늘의 체온 측졍 결과는 " + degree + "도 입니다");
    }
}
