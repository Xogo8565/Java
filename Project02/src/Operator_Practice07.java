import java.util.Scanner;

public class Operator_Practice07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("국어 : ");
        int koreanScore = sc.nextInt();
        sc.nextLine();
        System.out.print("영어 : ");
        int englishScore = sc.nextInt();
        sc.nextLine();
        System.out.print("수학 : ");
        int mathScore = sc.nextInt();
        sc.nextLine();
        int totalScore = koreanScore + englishScore +mathScore;
        double averageScore = totalScore/3;
        System.out.println("합계 : " + totalScore);
        System.out.println("평균 : " + averageScore);
        if(koreanScore>=40&&englishScore>=40&&mathScore>=40&&averageScore>=60){
            System.out.println("합격");
        } else {
            System.out.println("불합격");
        }

    }
}
