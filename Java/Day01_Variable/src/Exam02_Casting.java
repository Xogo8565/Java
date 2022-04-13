public class Exam02_Casting {
    public static void main(String[] args) {
        /* 형변환(Casting) : 데이터의 자료형을 변환하는 것.
        -> 개발자가 데이터의 타입의 범위를 예측하지 못했을 때
        -> 개발자가 원하는 대로 데이터 타입을 사용하기 위해서 강제적으로 형변환을 사용하는 경우도 있음

        1) 자동 형번환(Promition) : 작은 자료형에서 큰 자료형으로 변환이 이루어지는 경우

        2) 강제 형변환(Down casting) : 큰 자료형에서 작은 자료형으로 변환이 이루어지는 경우
        -> 데이터의 손실이 있을 수 있음
         */

        // 1) 자동 형변환

        byte b1 = 127;
        System.out.println("b1 : " + b1);
        short s1 = b1;
        System.out.println("s1 : " + s1);
        int i1 = b1;
        System.out.println("i1 : " + i1);
        long l1 = b1;
        System.out.println("l1 : " + l1);

        // 2) 강제 형변환

        long l2 = 123456789123456789L;
        System.out.println("l2 : " + l2);
        int i2 = (int) l2;
        System.out.println("i2 : " + i2);
        short s2 = (short) l2;
        System.out.println("s2 : " + s2);
        byte b2 = (byte) l2;
        System.out.println("b2 : " + b2);

        // Cf) 정수형을 실수형으로 형변환 하는 경우, 강제 형변환을 하지 않아도 된다.

        int i3 = 50;
        float f3 = i3;
        System.out.println("f3 : " + f3);

        // 실수 -> 정수로 형변환하는 경우, 강제 형변환이 필요하다.

        double d4 = 3.34;
        int i4 = (int) d4;
        System.out.println("i4 : " + i4);

        // char -> 실제로는 내부적으로 문자와 매칭되는 숫자(코드)가 들어있음.
        char c5 = 'a';
        System.out.println("c5 : " + c5);
        int i5 = c5;
        System.out.println("i5 : " + i5);

    }
}
