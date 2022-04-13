public class Exam03_Stock {
    public static void main(String[] args) {
        //주식 매매 프로그램
        int samsung = 50000;
        int tesla = 50000;
        int kakao = 30000;
        int money = 200000;

        System.out.println("============= 주식 마켓 =============");
        System.out.println("1. 삼성전자 (1주 :" + samsung +")");
        System.out.println("2. 테슬라 (1주:" + tesla +")");
        System.out.println("3. 카카오 (1주 :" + kakao +")");
        System.out.println("잔고 : " + money + "원");
        System.out.println("===================================");

        System.out.println("삼성전자 1주 매수");
//      System.out.println("잔고 : " + 200000-40000 + "원");
//      "잔고 : " + 200000 -> 문자열
//      문자열에서 -40000 실행 불가
        System.out.println("잔고 : " + (money-samsung) + "원");

        System.out.println("테슬라 2주 매수");
        System.out.println("잔고 : " + (money-samsung-tesla*2) + "원");

        System.out.println("카카오 1주 매수");
        System.out.println("잔고 : " + (money-samsung-tesla*2-kakao) + "원");

        System.out.println("테슬라 1주 매도");
        System.out.println("잔고 : " + (money-samsung-tesla*2-kakao+tesla) + "원");
    }
}
