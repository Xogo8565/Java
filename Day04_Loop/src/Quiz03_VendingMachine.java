import java.util.InputMismatchException;
import java.util.Scanner;

public class Quiz03_VendingMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 4000; //잔액
        int cokeNum = 0; //콜라 주문량
        int ciderNum = 0; // 사이다 주문량
        int maesilTeaNum = 0; //매실차 주문량
        int cokePrice = 1000; //콜라 가격
        int ciderPrice = 800; // 사이다 가격
        int maesilTeaPrice = 1500; // 매실차 가격

        //라벨링 While 문이나 While + Switch 일 때 효과적
        vending : while (true) {
            System.out.println("===== 자판기 시뮬레이터 ======\n" +
                    "음료수를 선택하세요\n" +
                    "1. 콜라(" + cokePrice + ") 2. 사이다(" + ciderPrice + ") 3. 매실차(" + maesilTeaPrice + ") [0. 소지품확인] 10. 자판기 종료");
            try {
                int selectNum = sc.nextInt();
                sc.nextLine();
                //Integer.parseInt(sc.nextLine())으로 받으면 catch 문을 NumberFormatException 로 받아야 한다
                if (selectNum == 1) { //콜라 주문
                    if (balance >= cokePrice) {
                        System.out.println("콜라를 구매했습니다.\n콜라 + 1 \n소지금 -" + cokePrice);
                        cokeNum++;
                        balance -= cokePrice;
                    } else {
                        System.out.println("잔액이 부족합니다.");
                    }
                } else if (selectNum == 2) { //사이다 주문
                    if (balance >= ciderPrice) {
                        System.out.println("사이다를 구매했습니다.\n사이다 + 1 \n소지금 -" + ciderPrice);
                        ciderNum++;
                        balance -= ciderPrice;
                    } else {
                        System.out.println("잔액이 부족합니다.");
                    }
                } else if (selectNum == 3) { //매실차 주문
                    if (balance >= maesilTeaPrice) {
                        System.out.println("매실차를 구매했습니다.\n매실차 + 1 \n소지금 -" + maesilTeaPrice);
                        maesilTeaNum++;
                        balance -= maesilTeaPrice;
                    } else {
                        System.out.println("잔액이 부족합니다.");
                    }
                } else if (selectNum == 0) {
                    System.out.println("===== 소지품 목록 ======\n" +
                            "소지금  : " + balance + "\n" +
                            "콜라 : " + maesilTeaNum + "\n" +
                            "사이다 : " + ciderNum + "\n" +
                            "매실차 : " + maesilTeaNum + "\n" +
                            "=====================");
                } else if (selectNum == 10) {
                    System.out.println(" 프로그램을 종료합니다");
                    break vending;
                } else {
                    System.out.println("입력한 숫자를 다시 확인해주세요");
                }
            } catch (InputMismatchException ime) {
                System.out.println("잘못된 입력입니다.");
                sc = new Scanner(System.in);
            }
        }

    }
}








