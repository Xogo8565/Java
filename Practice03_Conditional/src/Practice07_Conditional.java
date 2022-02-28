import java.util.Scanner;

public class Practice07_Conditional {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("키를 입력해주세요 : ");
        double height = sc.nextDouble();
        System.out.print("몸무게를 입력해주세요 : ");
        double weight = sc.nextDouble();
        double bmi = weight/(height*height);
        System.out.println("BMI 지수 : " + bmi);
        String status;

        if(bmi>30){
            status = "고도비만";
        } else if(bmi>=25&&bmi<30){
            status = "비만";
        } else if(bmi>=23&&bmi<25){
            status = "과체중";
        } else if(bmi>=18.5&&bmi<23){
            status = "정상체중";
        } else {
            status = "저체중";
        }

        System.out.println(status);
    }
}
