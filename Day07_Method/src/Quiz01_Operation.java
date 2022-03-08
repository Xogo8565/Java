public class Quiz01_Operation {
    public static int plus (int x, int y){
        return x+y;
    }

    public static int minus (int x, int y){
        return x-y;
    }

    public static int multiply (int x, int y){
        return x*y;
    }

    public static int division (int x, int y){
        return x/y;
    }

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 5;

        System.out.println(plus(num1,num2));
        System.out.println(minus(num1,num2));
        System.out.println(multiply(num1,num2));
        System.out.println(division(num1,num2));

        /*
        + - * / 를 수행하는 메서드 구성해서 결과값 출력하기
         */
    }
}
