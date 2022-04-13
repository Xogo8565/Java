import java.util.Scanner;

public class Practice_Variable03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(" 가로 : ");
        double i = sc.nextDouble();
        System.out.print(" 세로 : ");
        double j = sc.nextDouble();
        System.out.println(" 면적 :" + (i*j));
        System.out.println(" 둘레 : "+ ((i+j)*2));
    }
}
