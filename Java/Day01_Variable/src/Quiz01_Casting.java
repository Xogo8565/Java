public class Quiz01_Casting {
    public static void main(String[] args) {
        // 퀴즈 1 : 주어진 값을 모두 int 형으로 변환한 후 모두 더한 값을 출력
        char a = '2';
        double b = 5.6;
        long c = 1250000L;
        int d = 10000;

        int rs;

        //#1

        int a1 = a;
        int a2 = (int)b;
        int a3 = (int)c; // 값의 범위를 초과하지 않으므로 데이터 손실이 발생하지 않는다.

        rs = a1 + a2 + a3 + d;
        System.out.println("rs : " + rs);

        //#2

        rs = a + (int)b + (int)c + d;
        System.out.println("rs : " + rs);

        //#3

        rs = (int)(a + b + c + d); // rs -> double 형으로 저장되기때문에 int형으로 casting 필요
        System.out.println("rs : " + rs);

    }
}
