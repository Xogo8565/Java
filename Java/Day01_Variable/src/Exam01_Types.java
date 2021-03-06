public class Exam01_Types {
    public static void main(String[] args) {

        //변수 선언 / 값대입
        int a = 10; //정수
        System.out.println(a);

        int b;
        // System.out.println(b); -> 초기화 x
        b = 20;
        System.out.println(b);

        b = 30;
        System.out.println("두번째 b :" + b);

        //변수명의 첫 글자는 숫자로 시작하면 x
        //int 40var = 40;
        // 특수문자로도 시작 x
        //int %var = 40;
        //변수 이름에 길이의 제한은 없지만, 보통은 짧게/의미있게 짓는다.
        //int soaisufjopasjfkljaskldfjqpifjasio = 40;
        //변수 안에 들어있는 데이터의 성질에 맞게 이름을 정한다.
        //int word = 40;

        int numInt = 40;
        System.out.println(numInt);

        // boolean  :참(True) or 거짓(False)을 저장하는 자료형
        boolean t = true;
        boolean f = false;
        System.out.println("t : " + t);
        System.out.println("f : " + f);

        //char : 문자를 저장하는 자료형 ('' 싱글 쿼테이션을 이용)
        char c1 = 'a';
        char c2 = '가';
        char c3 = '5';
        System.out.println("c1 : " + c1);
        System.out.println("c2 : " + c2);
        System.out.println("c3 : " + c3);

        //숫자를 저장하는 자료형
        //정수형
        byte b1 = -128; // 1byte
        byte b2 = 127;
//        byte b3 = (byte)128; 오버플로우 발생
//        byte b4 = (byte)129;
        System.out.println("b1 : " + b1);
        System.out.println("b2 : " + b2);
//        System.out.println("b3 : " + b3);
//        System.out.println("b4 : " + b4);
        //데이터 타입에 맞는 데이터만 대입 가능
        //byte b3 = '가';

        short s1 = -32768; // 2byte
        short s2 = 32767;
        System.out.println("s1 : " +s1);
        System.out.println("s2 : " +s2);

        // int : 정수의 대표 타입, 4byte
        System.out.println(100); // 100 -> int 형

        // long : 데이터의 끝에 L을 붙여줘서 long 형임을 명시할 것,8byte
        long l1 = 321321321;
        System.out.println("l1 : " + l1);
//      long l2 = 3213213221321;
//     * 321~ : int 형으로 인식, int 형이 저장할 수 있는 숫자의 범위를 벗어났기 때문에 오류 발생
        long l2 = 3213213221321L;
        System.out.println("l2 : " + l2);
        // 뒤에 l을 붙여주면 오류가 사라진다.
//      System.out.println("l2 : " + l2);

        // 실수형
        // float : 데이터의 끝에 f를 붙여줘서 float 형임을 명시할 것, 4 byte
        // 실수 : 대표 타입이 double -> float 으로 저장 불가.
        float f1 = 3.14f;
        System.out.println("f1 : " + f1);
        // double : 실수의 대표 타입,8byte
        double d1 = 3.14;
        System.out.println("d1 : " +d1);

        // 8개의 데이터 타입 -> 자바 가장 기본 데이터타입(Primitive type) / 기본 자료형
        
        // String 형 : 참조자료형, Stack 영역에 변수 할당 + 데이터를 갖고 있는 주소값(실제 데이터 x)을 저장. Heap 영역(String pool)에 데이터 저장.
        String str = "가나다";
        System.out.println(str);
       

    }
}

