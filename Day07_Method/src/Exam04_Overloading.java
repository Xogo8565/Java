public class Exam04_Overloading {
    /*
    overloading : 메서드가 정의됐을 때 -> 하나의 기능이 있음
    -> 기존에 메서드가 가지고 있는 기능에 추가적인 인자값이나 자료헝의 변화를 줘서
    기본적인 메서드의 형태를 다양화 할 수 있는 문법

    메서드의 이름은 같으나 매개변수의 개수 또는 타입이 다른 경우 오버로드된 메서드
     */
    public static int plus(int num1, int num2) {
        return num1 + num2;
    }
    public static int plus(int num1, int num2, int num3){
        return num1 + num2 + num3;
    }  // 메서드 명은 같지만, 매개변수의 개수가 다른 경우
    public static int plus(double num1, double num2){
        return (int)(num1 + num1);
    } // 메서드 명은 같지만, 매개변수의 타입이 다른 경우
    public static int plus (char ch1, char ch2, char ch3){
        return ch1+ch2+ch3;
    } // 메서드 명은 같지만, 매개변수의 개수와 자료형이 다른 경우
    public static int plus(){
        return 5+10;
    } // Overloading (O)

    //System.out.println() -> 대표적인 오버로딩의 예

    //Overloading 이 성립이 안되는 경우
//    public static void plus(int num1, int num2){
//        int num = num1 + num2;
//    } -> 반환타입이 달라지게 되면 다른 메서드로 인식하게 됨.
    // 오버로딩의 경우 기존 메서드의 확장으로 인식.
    // *** 매개변수의 타입과 개수가 동일하면서 리턴타입만 다르면 오버로딩 성립 x
    // + 하나의 클래스에선 중복된 이름을 가진 다른 메서드를 가질 수 없으므로 Error 발생

    public static void plus(float num1, float num2){
        float rs = num1+num2;
    } // 리턴자료형이 달라지고 + 매개변수의 형태도 달라지게 되면, 다른 메서드로써 같은 이름을 사용하는 게 가능 + Overloading 은 아님


    public static void main(String[] args) {
        //두 개의 정수를 더하는 메서드
        System.out.println(plus(10,5));
        //세 개의 정수를 더하는 메서드
        System.out.println(plus(10,5,10));
        //두 개의 실수를 더하는 메서드
        System.out.println(plus(3.5,1.5));
        //세 개의 char 데이터를 더하는 메서드
        System.out.println(plus('a','b','c'));

    }
}