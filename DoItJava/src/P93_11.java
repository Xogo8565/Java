import java.util.Scanner;

class P93_11 {
    int y;
    int m;
    int d;

    static int[][] mdays = { { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 평년
            { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 윤년
    };

    static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }

    P93_11(int y, int m, int d) {
        this.y = y;
        this.m = m;
        this.d = d;
    }

    P93_11 after(int n) {
        P93_11 temp = new P93_11(this.y, this.m, this.d);

        if (n < 0) return (before(-n));

        temp.d += n;

        while (temp.d > mdays[isLeap(temp.y)][temp.m - 1]) {
            temp.d -= mdays[isLeap(temp.y)][temp.m - 1];
            if (++temp.m == 13) {
                temp.y++;
                temp.m = 1;
            }
        }
        return temp;
    }


    P93_11 before(int n) {
        P93_11 temp = new P93_11(this.y, this.m, this.d);

        if (n < 0) return (after(-n));

        temp.d -= n;

        while (temp.d < 1) {
            if (--temp.m == 0) {
                temp.y--;
                temp.m = 12;
            }
            temp.d += mdays[isLeap(temp.y)][temp.m - 1];
        }
        return temp;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("날짜를 입력하세요.\n");
        System.out.print("년：");
        int y = stdIn.nextInt();
        System.out.print("월：");
        int m = stdIn.nextInt();
        System.out.print("일：");
        int d = stdIn.nextInt();
        P93_11 date = new P93_11(y, m, d);

        System.out.print("몇 일 앞/뒤의 날짜를 구할까요?：");
        int n = stdIn.nextInt();

        P93_11 d1 = date.after(n);
        System.out.printf("%d일 뒤의 날짜는 %d년 %d월 %d일입니다.\n", n, d1.y, d1.m, d1.d);

        P93_11 d2 = date.before(n);
        System.out.printf("%d일 앞의 날짜는 %d년 %d월 %d일입니다.\n", n, d2.y, d2.m, d2.d);
    }
}
