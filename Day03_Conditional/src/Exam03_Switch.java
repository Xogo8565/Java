import java.util.Scanner;

public class Exam03_Switch {
    public static void main(String[] args) {
        /*
        switch : 조건문 if와 유사
                 대소관계가 아니라 equal 비교

        switch(값){
            case 조건 : 실행코드
            case 조건 : 실행코드
            case 조건 : 실행코드
        }
        값 -> String, int, char 등
        ** 주의점 :
        break; 필수
        break; 가 없으면 값이 충족되는 순간, 그 다음 case 들은 equal 조건을 충족하건 말건 반드시 수행됨.

         */


        // "사과라는 문자열을 3개의 문자열과 비교하여 코드를 실행
//        switch ("사과") {
//            case "바나나" :
//                System.out.println("바나나");
//                break;
//            case "사과" :
//                System.out.println("사과");
//                break;
//            case "감귤" :
//                System.out.println("감귤");
//                break;
//        }

        // 1을 입력하면 1 출력, 2 입력하면 2 출력, 3 입력하면 3출력 -> switch
        Scanner sc = new Scanner(System.in);
        System.out.println("1,2 3 중에 하나를 입력하시오 : ");
        int opt = sc.nextInt();
        sc.nextLine();

        switch (opt){
            case 1 :
                System.out.println(2);
                break;
            case 2 :
                System.out.println(2);
                break;
            case 3 :
                System.out.println(3);
                break;
            default:
                // default -> if 문의 else 와 비슷한 역할
                // break; 불필요. 추가적인 조건이 올 일이 없기 때문
                System.out.println("잘못 입력했습니다.");

        }
    }
}
