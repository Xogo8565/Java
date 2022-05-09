import java.util.Scanner;

public class P21_04 {
    static int med3(int a, int b, int c){
        /* a,b,c 에서 나올 수 있는 경우의 수 :
        (a, b, c) (a, c, b) (b, a, c) (b, c, a) (c, a, b) (c, b, a)
       1) a>b 이면
       c1 b c2 a c3가 가능
       -> 따라서 c가 b 보다 큰지 비교하고 or a보다 작은지 비교한 후 else 로 나머지를 처리

       2) b>a 이면
       c1 a c2 b c3가 가능
       -> a와 c값, b와 c값을 비교한 후 else 로 나머지를 처리

        */
        if(a >= b){
            if(b >= c) //  (a, b, c)
                return b;
            else if (a <= c)
                return a; // (c, a, b)
            else
                return c; // (a, c, b)
        } else if (a > c)
            return a; // (b, a, c)
        else if (b > c)
            return c; //(b, c, a)
        else return b; //(c, b, a)

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("A 입력 : ");
        int a = Integer.parseInt(sc.nextLine());
        System.out.println("B 입력 : ");
        int b = Integer.parseInt(sc.nextLine());
        System.out.println("C 입력 : ");
        int c = Integer.parseInt(sc.nextLine());
        System.out.println(med3(a,b,c));

    }
}
