import java.util.Scanner;

public class Quiz03_Dictionary {
    public static void main(String[] args) {
        /* 사용자에게
        ===== 원하는 채소의 이름을 입력하세요. =====
        >>

        -> dict() 메서드를 이용해서 사용자가 입력한 채소를 영어 단어로 바꿔서 반환해주는 메서드를 구성(3가지 채소만 할 것)
        ->  사용자한테 "입력한 00은 영어로 00입니다.
        -> else 사전에 등록된 단어가 없습니다.

         */
        Scanner sc = new Scanner(System.in);
        System.out.print("원하는 채소를 입력하세요\n>> ");
        String input = sc.nextLine();
        System.out.println("입력한 "+input+"은 영어로 "+ dict(input) +"입니다.");
    }

    public static String dict(String str) {
        String eng;
            if(str.equals("당근")) eng = "Carrot";
            else if(str.equals("마늘")) eng = "Garlic";
            else if(str.equals("양파")) eng = "Onion";
            else eng = "사전에 등록되지 않은 단어";
            return eng;
    }

}
