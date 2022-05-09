import java.util.Scanner;

public class Test_Kiosk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 10000;
        int americano = 2000;
        int vanilla = 3000;
        int zamong = 3500;

        Kiosk:while(true){
            System.out.print("==== KH 카페 키요스크 ====" +
                    "\n주문할 메뉴를 선택해주세요." +
                    "\n1. 아메리카노(2,000)" +
                    "\n2. 바닐라라떼(3,000)" +
                    "\n3. 자몽에이드(3,500)" +
                    "\n현재 잔액 : "+ balance +
                    "\n메뉴 선택 >>> " );

            int menu = Integer.parseInt(sc.nextLine());
            if(menu==1){
                if(balance>=americano){
                    balance -= americano;
                    System.out.println("\n아메리카노를 선택했습니다.\n남은 잔액: "+balance+"\n");
                } else {
                    System.out.println("\n잔액이 부족합니다.\n"+"남은 잔액 : "+balance+"원\n");
                }
            } else if(menu==2){
                if(balance>=vanilla){
                    balance -= vanilla;
                    System.out.println("\n바닐라라떼를 선택했습니다.\n남은 잔액: "+balance+"\n");
                } else {
                    System.out.println("\n잔액이 부족합니다.\n"+"남은 잔액 : "+balance+"원\n");
                }
            } else if(menu==3){
                if(balance>=zamong){
                    balance -= zamong;
                    System.out.println("\n자몽에이드를 선택했습니다.\n남은 잔액: "+balance+"\n");
                } else {
                    System.out.println("\n잔액이 부족합니다.\n"+"남은 잔액 : "+balance+"원\n");
                }
            } else {
                System.out.println("없는 메뉴를 선택했습니다. 다시 선택해 주세요\n");
            }
            while(true){
                System.out.print("계속 주문하시려면 Y를 주문을 종료하려면 N을 입력하세요\n>> ");
                char cont = sc.nextLine().charAt(0);
                if (cont =='Y'){
                    System.out.println();
                    break;
                } else if (cont == 'N'){
                    System.out.println("KH 카페를 찾아주셔서 감사합니다. 다음에 또 오세요~!");
                    break Kiosk;
                } else {
                    System.out.println("Y/N 중 하나만 정확히 입력해주세요.\n");
                }
            }
        }
    }
}
