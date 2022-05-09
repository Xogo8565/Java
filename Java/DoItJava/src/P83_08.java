import java.util.Scanner;

public class P83_08 {
    static int [][] mdays = {
            {31,28,31,30,31,30,31,31,30,31,30,31},
            {31,29,31,30,31,30,31,31,30,31,30,31}
    };

    static int isLeap(int year){
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ) ? 1 : 0;
    }

    static int dayOfYear(int y, int m,  int d) {
        while(-- m != 0){
            d += mdays[isLeap(y)][m-1];
        }
        return d;
    }

    static int leftDayOfYear(int year, int month, int day) {
        return isLeap(year)==0? 365 : 366 - dayOfYear(year,month,day);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int retry;

        System.out.println("그 해의 경과 일수를 구합니다");
        System.out.print("년 : ");
        int year = Integer.parseInt(sc.nextLine());
        System.out.print("월 : ");
        int month = Integer.parseInt(sc.nextLine());
        System.out.print("일 : ");
        int day = Integer.parseInt(sc.nextLine());

        System.out.printf("그 해의 %d일 째입니다.\n",dayOfYear(year,month,day));

        System.out.println("남은 일 수는 " +leftDayOfYear(year,month,day)+"입니다.");

    }
}
