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

        String result;
        int totalScore = korScore+engScore+mathScore;
        int averageScore = totalScore/3;

        if((korScore>=40&&engScore>=40&&mathScore>=40)&&averageScore>=60){
            result = "축하합니다, 합격입니다.";
        } else {
            result = "불합격입니다";
        }

        System.out.println("국어 : " +korScore);
        System.out.println("국어 : " +engScore);
        System.out.println("국어 : " +mathScore);
        System.out.println("합계 : " +totalScore);
        System.out.println("평균 : " +averageScore);
        System.out.println(result);




    }
}
