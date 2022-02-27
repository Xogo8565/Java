import java.util.Scanner;

public class Operator_Practice06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("나이 : ");
        int age = sc.nextInt();
        sc.nextLine();

        if(age <= 13){
            System.out.println("어린이");
        } else if (age <19) {
            System.out.println("청소년");
        } else {
            System.out.println("성인");
        }
    }
}
