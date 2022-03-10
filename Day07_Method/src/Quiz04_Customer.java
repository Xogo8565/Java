import java.util.Scanner;

public class Quiz04_Customer {
    //메서드를 작성할 땐 되도록 메인 메서드에서 출력할 수 있도록 작성할 것.
    //메서드는 String 값을 반환하고 메인 메소드에서는 해당 메서드를 이용해서 String 값을 받는 것이 코드를 관리하기가 용이.
    //Why? System.out.println()은 콘솔창에 출력을 요청하 메서드이므로 브라우저나 어플에서는 작동하지 않는다.

    public static String getCustomer (String name){
        return name + "님 안녕하세요!\n";
    }
    public static String getCustomer (int number){

        return "손님 "+ number+"명 입장하였습니다.\n";
    }
    public static String getCustomer (double temperature){
        String temCheck = "현재 입장한 손님의 체온은 "+ temperature+"도 입니다.\n";
        if(temperature>37) return temCheck + "입장불가 입니다\n";
        else if(temperature<36.5) return temCheck + "체온이 너무 낮습니다\n";
        else return temCheck + "정상 체온입니다\n";
    }
    public static String getCustomer (boolean eatIn){
        if(eatIn) return "매장 손님입니다.\n";
        else return "포장 손님입니다.\n";
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("=== 손님 맞이 프로그램 ===\n1. 이름을 입력해주세요 >> ");
        String name = sc.nextLine();
        System.out.println( getCustomer(name));
        System.out.print("2. 인원수를 입력해 주세요 >> ");
        int num = Integer.parseInt(sc.nextLine());
        System.out.println(getCustomer(num));
        System.out.print("3. 현재 체온을 입력해 주세요 >> ");
        double tem = Double.parseDouble(sc.nextLine());
        System.out.println(getCustomer(tem));
        System.out.print("4. 매장 식사 여부를 입력해주세요 >> ");
        boolean eatIn = Boolean.parseBoolean(sc.nextLine());
        System.out.println(getCustomer(eatIn));
    }
}
