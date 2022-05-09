import java.util.Scanner;

public class p70_07 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int no;
        int cd;
        int dno;
        char[] cno = new char[36];

        System.out.println("10진수를 기수변환합니다.");
        System.out.print("변환하는 음이 아닌 정수 : ");
        no = Integer.parseInt(sc.nextLine());
        System.out.print("어떤 진수로 변환할까요? (2~36) : ");
        cd = Integer.parseInt(sc.nextLine());

        dno = CardConv(no, cd, cno);

        System.out.print( cd + "진수로는 ");
        for(int i= dno -1; i>= 0; i--){
            System.out.print(cno[i]);
        }
        System.out.println("입니다.");
    }

    static int CardConv(int x, int r, char[] d){
        int digits = 0;

        String dchar = "0123456789ABDCEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.printf("%2d|%6d\n",r,x);
        do {
            System.out.println("  + -------");
            d[digits++] = dchar.charAt(x % r);
            x /= r;

            if (x != 0) {
                System.out.printf("%2d|%6d ... %c\n", r, x, d[digits - 1]);
            } else System.out.printf("\t%6d ... %c\n", x, d[digits - 1]);
        }    while (x != 0);

        return digits;
    }

}
