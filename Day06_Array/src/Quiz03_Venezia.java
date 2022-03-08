import java.util.Scanner;

public class Quiz03_Venezia {
    //한컴타자 연습 - 산성비
//게임을 시작한 순간부터 종료된 순간까지 시간을 잼
    public static void main(String[] args) {
        String[] strArr = {"마부위침","흘깃흘깃","싱글벙글","귀모토각","사흘돌이","반근착절","바람언덕","백전백승"};
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("===== 베네치아 게임에 오신 것을 환영합니다 =====\n1. 게임시작\n2. 게임종료\n메뉴를 선택하세요 >> ");
            int menu = Integer.parseInt(sc.nextLine());
            if(menu==1){
                long start = System.currentTimeMillis();
                while (true) {
                    for (String s : strArr) {
                        System.out.print(s + "\t");
                    }
                    System.out.println();
                    System.out.print("입력 >> ");
                    String input = sc.nextLine();

                    boolean quit = true;
                    for (int i = 0; i < strArr.length; i++) {
                        if (input.equals(strArr[i])) strArr[i] = ""; // 입력값을 공란으로
                        if (!strArr[i].equals("")) quit = false; // 종료플래그 설정
                    }
                    if (quit) break;
                }

                long end = System.currentTimeMillis();
                System.out.println("Clear!\n플레이시간 : "+((end-start)/1000)+"초"+"\n===== Goodbye Venezia:) =====");
                break;

            } else if (menu ==2) break;
                else System.out.println("잘못된 조작입니다.\n");

        }
    }
}
