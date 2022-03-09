import java.util.Scanner;

public class Quiz04_Customer {
    public static void getCustomer (String name){
        System.out.println(name+"님 안녕하세요!\n");
    }
    public static void getCustomer (int number){
        System.out.println("손님 "+ number+"명 입장하였습니다.\n");
    }
    public static void getCustomer (double temperature){
        System.out.println("현재 입장한 손님의 체온은 "+ temperature+"도 입니다");
        if(temperature>37) System.out.println("입장불가 입니다\n");
        else if(temperature<36.5) System.out.println("체온이 너무 낮습니다\n");
        else System.out.println("정상 체온입니다\n");
    }
    public static void getCustomer (boolean eatIn){
        if(eatIn) System.out.println("매장 손닙입니다.\n");
        else System.out.println("포장 손님입니다.\n");
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("=== 손님 맞이 프로그램 ===\n1. 이름을 입력해주세요 >> ");
        String name = sc.nextLine();
        getCustomer(name);
        System.out.print("2. 인원수를 입력해 주세요 >> ");
        int num = Integer.parseInt(sc.nextLine());
        getCustomer(num);
        System.out.print("3. 현재 체온을 입력해 주세요 >> ");
        double tem = Double.parseDouble(sc.nextLine());
        getCustomer(tem);
        System.out.print("4. 매장 식사 여부를 입력해주세요 >> ");
        boolean eatIn = Boolean.parseBoolean(sc.nextLine());
        getCustomer(eatIn);
    }
}
