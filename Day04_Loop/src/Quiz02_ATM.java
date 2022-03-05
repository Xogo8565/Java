import java.util.Scanner;

public class Quiz02_ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //변수선언 -> while문 밖에서
        int balance = 0;
        int money = 0;

        while(true){
            System.out.println("=== ATM 시뮬레이터 ===");
            System.out.println("1. 잔액조회 ");
            System.out.println("2. 입금하기 ");
            System.out.println("3. 출금하기 ");
            System.out.println("4. 종료하기 ");
            System.out.print(">> ");
            int inputNum = sc.nextInt();
            sc.nextLine();
            //잔액조회
            if(inputNum==1){
                System.out.println("현재 보유 잔액은 " + balance+"원입니다.");
                //입금
            } else if(inputNum==2){
                System.out.println("얼마를 입금하시겠습니까?");
                System.out.print(">>");
                money = sc.nextInt();
                sc.nextLine();
                System.out.println(money + "원이 입금되었습니다.");
                balance += money;
            } else if(inputNum==3){
                //출금
                System.out.println("얼마를 출금하시겠습니까?");
                System.out.print(">>");
                money = sc.nextInt();
                sc.nextLine();
                System.out.println(money + "원이 출금되었습니다.");
                balance -= money;
            } else if (inputNum==4){
                //종료
                System.out.println("거래가 종료되었습니다.");
                break;
            } else {
                System.out.println("잘못입력하셨습니다.");
            }

        }
    }
}
