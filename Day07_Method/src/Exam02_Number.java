import java.util.Scanner;

public class Exam02_Number {
    public static int smaller(int x, int y){
        int min = x;
        if(y<min) min = y;
        return min;
    }


    public static void main(String[] args) {
        // 두 개의 수를 입력,
        Scanner sc  = new Scanner(System.in);
        System.out.print("숫자 1을 입력하세요 : ");
        int num1 = Integer.parseInt(sc.nextLine());
        System.out.print("숫자 2를 입력하세요 : ");
        int num2 = Integer.parseInt(sc.nextLine());
        System.out.println("둘 중 더 작은 수는 "+smaller(num1, num2)+"입니다.");
    }
}
