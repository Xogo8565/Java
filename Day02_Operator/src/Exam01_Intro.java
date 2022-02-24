public class Exam01_Intro {
    public static void main(String[] args) {
        /*
        연산자
        1. 산술 연산자 (+, -, *, \/, %) :
         cf) \ : escape
        2. 대입 연산자 (=, +=, -=, %=, *=) :

        3. 비교 연산자 (<, >, <=, >=, ==, !=) :

        4. 증감 연산자 (전위 연산, 후위 연산) :

        5. 논리 연산자 (&&, ||) :

        6. 삼항 연산자 (조건식? 식1 : 식2) :

        */

        int a = 10;
        int b = 4;
        int c = 4;

        //산술 연산자

        System.out.println("===== 산술 연산자 =====");
        System.out.println("a : " +a);
        System.out.println("b : " +b);
        System.out.println("c : " +c);
        System.out.println("a + b : " + (a + b));
        System.out.println("a - b : " + (a - b));
        System.out.println("a * b : " + (a * b));
        System.out.println("a / b : " + a / b);
        System.out.println("a % b : " + a % b);
        System.out.println();

        //비교 연산자
        System.out.println("===== 비교 연산자 =====");
        System.out.println("a : " +a);
        System.out.println("b : " +b);
        System.out.println("c : " +c);
        System.out.println(" a > b : " + (a > b));
        System.out.println(" a < b : " + (a < b));
        System.out.println(" a == b : " + (a == b));
        System.out.println(" a != b : " + (a != b));
        System.out.println(" b <= a : " + (b <= a));
        System.out.println();

        //char값 비교
        char c1 = 'a';//97
        char c2 = 'A';//65

        System.out.println("cf1) char값 비교");
        System.out.println("c1 : " +c1);
        System.out.println("c2 : " +c2);
        System.out.println("c1 == c2 : " + (c1 == c2));
        System.out.println("c1 > c2 : " + (c1 > c2));
        System.out.println();

        /* 참조자료형 String 값에 대한 비교를 할 때는 == 쓰지 x
         기본자료형은 stack 영역에 값 자체가 저장되지만 참조자료형은 stack 영역에 주소값이 저장되므로
         ==을 활용하게 되면 주소값을 비교하게 된다.
         따라서 equals() 기능을 이용해 문자열을 비교 */

        System.out.println("cf2) String 비교");
        String str1 = "abc";
        String str2 = "abc";
        String str3 = "def";
        System.out.println("str1 : " +str1);
        System.out.println("str2 : " +str2);
        System.out.println("str3 : " +str3);
        System.out.println("str1.equals(str2) : " + str1.equals(str2));
        System.out.println("str2.equals(str3) : " + str2.equals(str3));
        System.out.println();

        // 대입연산자

        System.out.println("===== 대입연산자 =====");

        int d = 5;
        System.out.println("d = " + d);
        d += 3;
        System.out.println("d += 3 : " + d); // 8 출력
        d -= 4;
        System.out.println("d -= 4 : " + d); // 4 출력
        d *= 10;
        System.out.println("d *= 1 : " + d); // 40 출력
        System.out.println();

        // 증감 연산자 (전위/후위) : ++(+1), --(-1)
        // 전위연산
        System.out.println("===== 증감연산자(전위) =====");

        int e = 20;
        int f = 20;

        System.out.println("e : " + e );
        System.out.println("++e : " + ++e); // +1을 행한 후 출력
        System.out.println("e : " + e); // 21 출력
        System.out.println("--e : " + --e); // 20 출력
        System.out.println("e : " + e); // 상동
        System.out.println();
        // 후위연산
        System.out.println("===== 증감연산자(후위) =====");
        System.out.println("f : " + f);
        System.out.println("f++ : " + f++); // 20 출력 후 +1 연산
        System.out.println("f : " + f); // 21 출력
        System.out.println("f-- : " + f--); // 21 출력 후 -1 연산
        System.out.println("f : " + f); // 20 출력
        System.out.println();

        System.out.println("++e + 5 : " +(++e + 5)); // 26 출력
        System.out.println("f++ + 5 : " +(f++ + 5)); // 25 출력 후 f 값에 21 저장
        System.out.println("f : " + f );
        System.out.println();

        int x = 10;
        System.out.println("x : " + x);
        int y = x-- + 5 + --x; // x-- : 10 활용 후 9 저장, +5, --x : 8 활용 및 저장 => 10 + 5 + 8
        System.out.println("y =  x-- + 5 + --x");
        System.out.println("y : " + y );
        int z = --x + 5 + x--; // --x : 7 활용 및 저장, +5, 7 활용 및  6 저장 => 7 + 5 + 7
        System.out.println("z = --x + 5 + x--");
        System.out.println("z : " + z );
        System.out.println();

        //논리 연산자
        System.out.println("===== 논리 연산자 =====");
        System.out.println("a : " +a);
        System.out.println("b : " +b);
        System.out.println("c : " +c);
        // and(&&) : 연산자를 기준으로 양쪽의 두 조건이 모두 true여야 결과값이 true
        System.out.println("a>b && a>c : " + (a>b && a>c)); // true
        System.out.println("a>b && b>c : " + (a>b && b>c)); // false
        // or(||) : 연산자를 기준으로 양쪽의 두 조건 중 하나만 true여도 결과값이 true
        System.out.println("a>b || a>c : " + (a>b || a>c)); // true
        //조건 1이 이미 true 이므로 조건 2는 실행 x(shortcut 연산)
        System.out.println("a>b || b>c : " + (a>b || b>c)); // true
        System.out.println();

        //삼항 연산자 (조건식? 식1 : 식2) :
        // if(조건식=true){ 식1 } else { 식2 }
        System.out.println("===== 삼항 연산자 =====");
        System.out.println("a : " +a);
        System.out.println("b : " +b);
        System.out.println("c : " +c);
        System.out.println("( a>b? \"참\" : \"거짓\" ) : " + (a>b? "참" : "거짓" ));
        System.out.println("( a<b? \"참\" : \"거짓\" ) : " + (a<b? "참" : "거짓" ));





    }
}
