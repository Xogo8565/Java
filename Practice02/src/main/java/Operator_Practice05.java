import java.util.Scanner;

public class Operator_Practice05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름 : ");
        String name = sc.nextLine();
        System.out.print("학년(숫자만) : ");
        int schoolGrade = sc.nextInt();
        sc.nextLine();
        System.out.print("반(숫자만) : ");
        int classNum = sc.nextInt();
        sc.nextLine();
        System.out.print("번(숫자만) : ");
        int studentNum = sc.nextInt();
        sc.nextLine();
        System.out.print("성별(M/F) : ");
        char sex = sc.nextLine().charAt(0);
        System.out.print("성적(소수점 아래 둘째자리까지만) : ");
        double grade = sc.nextDouble();

        if(sex == 'M'){
            System.out.println(schoolGrade + "학년 "+classNum+"반 "+studentNum+" 번 "+ name + " 남학생의 성적은 " + grade +"이다.");
        } else {
            System.out.println(schoolGrade + "학년 "+classNum+"반 "+studentNum+" 번 "+ name + " 여학생의 성적은 " + grade +"이다.");
        }
    }

}
