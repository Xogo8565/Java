import java.util.Scanner;

public class Operator_Practice11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("A 사원의 연봉 : ");
        int salaryA = sc.nextInt();
        System.out.print("B 사원의 연봉 : ");
        int salaryB = sc.nextInt();
        System.out.print("C 사원의 연봉 : ");
        int salaryC = sc.nextInt();

        double incentiveA = 0.4;
        double incentiveB = 0;
        double incentiveC = 0.15;
        double totalA = salaryA + salaryA * incentiveA;
        double totalB= salaryB + salaryB * incentiveB;
        double totalC = salaryC + salaryC * incentiveC;

        System.out.println("A 사원 연봉/연봉 + a : " + salaryA + " / " + totalA);
        if (totalA>=3000){
            System.out.println("3000 이상");
        } else {
            System.out.println("3000 미만");
        }

        System.out.println("B 사원 연봉/연봉 + a : " + salaryB + " / " + totalB);
        if (totalB>=3000){
            System.out.println("3000 이상");
        } else {
            System.out.println("3000 미만");
        }
        System.out.println("C 사원 연봉/연봉 + a : " + salaryC + " / " + totalC);
        if (totalC>=3000){
            System.out.println("3000 이상");
        } else {
            System.out.println("3000 미만");
        }

    }
}
