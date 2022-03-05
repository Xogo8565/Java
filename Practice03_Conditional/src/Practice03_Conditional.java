import java.util.Scanner;

public class Practice03_Conditional {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("국어 점수 : ");
        int korScore = sc.nextInt();
        sc.nextLine();
        System.out.print("영어 점수 : ");
        int engScore = sc.nextInt();
        sc.nextLine();
        System.out.print("수학 점수 : ");
        int mathScore = sc.nextInt();
        sc.nextLine();

        int totalScore = korScore + engScore + mathScore;
        double averageScore = totalScore/3d;

        if((korScore >= 40 && engScore >= 40 && mathScore >= 40) && averageScore >= 60){
            System.out.println("국어 : " + korScore);
            System.out.println("영어 : " + engScore);
            System.out.println("수학 : " + mathScore);
            System.out.println("합계 : " + totalScore);
            System.out.printf("평균 : %.2f\n", averageScore);
            System.out.println("축하합니다, 불합격입니다.");
        } else {
            System.out.println("불합격입니다.");
        }






    }
}
