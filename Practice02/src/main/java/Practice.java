import java.util.InputMismatchException;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int schoolGrade = 0;
        int classNum = 0;
        int studentNum = 0;
        char sex;
        double grade = 0;


        while(true){
            System.out.print("이름 : ");
            String name = sc.nextLine();
            while (true){
                System.out.print("학년 : ");
                try {
                    schoolGrade = sc.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    while (true){
                        System.out.println("잘못 입력하셨습니다.");
                        sc = new Scanner(System.in);
                        break;
                    }
                }
            }
            while (true){
                System.out.print("반 : ");
                try {
                    classNum = sc.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    while (true){
                        System.out.println("잘못 입력하셨습니다.");
                        sc = new Scanner(System.in);
                        break;
                    }
                }
            }
            while (true){
                System.out.print("번 : ");
                try {
                    studentNum = sc.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    while (true){
                        System.out.println("잘못 입력하셨습니다.");
                        sc = new Scanner(System.in);
                        break;
                    }
                }
            }
            while(true){
                System.out.print("성별(M/F) : ");
                sex = sc.next().charAt(0);
                sc.nextLine();
                sex = Character.toUpperCase(sex);
                if(sex=='M'){
                    sex = 'M';
                    break;
                } else if(sex =='F'){
                    sex = 'F';
                    break;
                } else {
                    System.out.println("잘못 입력하셨습니다.");
                    sc = new Scanner(System.in);
                }
            }

            while (true){
                System.out.print("성적 : ");
                try {
                    grade = sc.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    while (true){
                        System.out.println("잘못 입력하셨습니다.");
                        sc = new Scanner(System.in);
                        break;
                    }
                }
            }

            if(sex == 'M'){
                System.out.printf(schoolGrade + "학년 "+classNum+"반 "+studentNum+"번 "+ name + " 남학생의 성적은 " +"%.2f"+"이다.\n",grade);
            } else {
                System.out.printf(schoolGrade + "학년 "+classNum+"반 "+studentNum+"번 "+ name + " 여학생의 성적은 " +"%.2f"+"이다.\n",grade);
            }

            System.out.println("계속하시겠습니까?(Y/N) : ");
            char selection = sc.next().charAt(0);
            sc.nextLine();
            selection = Character.toUpperCase(selection);

           if (selection == 'N'){
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (selection == 'Y'){
            } else {
               System.out.println("잘못 입력하셨습니다.");
               System.out.println("계속하시겠습니까?(Y/N) : ");
               selection = sc.nextLine().charAt(0);
           }
        }

    }

}
