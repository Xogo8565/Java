import java.util.Scanner;

public class Exam02_Number {
    //두 정수를 입력받아 -> smaller()라는 메서드를 이용해 두 정수 중 더 작은 수를 반환 받음
    // 그 수를 출력
//    public static int smaller(int x, int y){
//        int min = x;
//        if(y<min) min = y;
//        return min;
//    }

    //x, y를 입력받아
    // getRandom() 메서드를 이용해 최댓값과 최솟값 아이의 난수를 반환받기
    public static int getRandom(int x, int y){
        int randomNum;
        return randomNum = (int)(Math.random()*(x-y+1)+y);
    }

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
//        System.out.print("숫자 1을 입력하세요 : ");
//        int num1 = Integer.parseInt(sc.nextLine());
//        System.out.print("숫자 2를 입력하세요 : ");
//        int num2 = Integer.parseInt(sc.nextLine());
//        System.out.println("둘 중 더 작은 수는 "+smaller(num1, num2)+"입니다.");
        System.out.print("최댓값을 입력하세요 : ");
        int num1 = Integer.parseInt(sc.nextLine());
        System.out.print("최솟값를 입력하세요 : ");
        int num2 = Integer.parseInt(sc.nextLine());
        System.out.println("난수 생성 : " + getRandom(num1,num2));

    }
}
