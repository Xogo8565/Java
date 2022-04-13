public class Exam01_Intro {
    public static int plus(int a, int b){
        int result = a+b;
        return result;
        // return 을 만나는 순간 결과값과 함께 메서드 영역을 벗어나 버림.
    }

    public static void main(String[] args) {
        plus(1,5);
        //호출부
        //사용하고자 하는 메서드명(인자값);
        //매개변수의 자료형과 수, 인자값의 자료형과 수는 반드시 일치해야 함

        /*
          코드 상에 제어문(if,switch, for, while)을 제외하고 코드 옆에 () 소괄호가 오면 무조건 메서드.


          Method : 자바에서 기능을 이야기 함.
          -> 어떤 특정한 작업을 수행하기 위해서 모아놓은 명령문의 집합.
          -> function(함수)
          구성
          - 정의부 : 메서드를 정의하는 영역 / 어떤 기능을 수행하게 될지에 대한 코드가 들어가는 영역
           public 반환자료명 메서드명 (매개변수 ...) {
           처리할 기능코드
           (리턴값);
           }
           - 호출부 : 정의된 메서드를 호출하는 영역 / 즉, 이미 정의된 메서드를 호출해서 그 기능을 쓰겠다 선언하는 영역
           메서드명(인자값...);
   */
    }

}
