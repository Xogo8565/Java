public class Exam01_Intro {
    public static void main(String[] args) {
        /*
        반복문 : 조건문처럼 프로그램의 흐름을 제어할 수 있는 문법
        -> 조건식을 충족하는 동안은 해당 범위(블록)의 코드가 반복되서 실행됨.
        -> 반면 조건식을 불충족하는 순간 그 범위를 벗어나 코드의 흐름이 원래대로 아래로 흘러 내려간다.

        for :
        for(초기식; 조건식; 증감식){
         실행할 코드
        }

        while:
        while(조건식){
        실행할코드
        }
         */
//
//        System.out.println(0);
//        System.out.println(1);
//        System.out.println(2);
//
//        // 초기값 : 몇번부터 시작할건지
//        // 조건식 : 언제까지 반복할건지
//        // 증감식 : for 문 안쪽의 코드가 한 번 반복될 때마다 증가시킬 값
//
//        for(int i =0; i<3; i++){
//            System.out.println(i);
//        }
//
//        // 0~4까지 for 문을 이용하여 출력
//        for(int i=0; i<5; i++){
//            System.out.println(i);
//        }

        //1~ 100까지 for 문을 이용해 출력
//        for (int i = 1; i<101; i++){
//            System.out.println(i);
//        }

        // 100 부터 1까지 출력
        for(int i =100; i>0; i--){
            System.out.println(i);
        }



    }
}

