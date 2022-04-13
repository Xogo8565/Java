import javax.swing.*;
import java.util.Scanner;

public class Quiz02_Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== 색깔로 알아보는 심리 테스트 ===");
        System.out.println("다음의 색깔 중 1가지를 선택해 주세요");
        System.out.println("빨강  주황  노랑  초록  하양  보라  파랑");

        System.out.print("선택 >>");
        String select = sc.nextLine();

        if(select.equals("빨강")){
            System.out.println("활력이 넘치고 독창성이 뛰어난 사람");
        } else if(select.equals("주황")){
            System.out.println("성실하고 강한 사람");
        } else if(select.equals("노랑")){
            System.out.println("소극적이지만 정신력이 강하고 실행력이 있는 사람");
        } else if(select.equals("파랑")){
            System.out.println("차가워 보이지만 따뜻하고 부드러운 사람");
        } else if(select.equals("하양")){
            System.out.println("부드럽고 예민하며 감성적인 사람");
        } else if(select.equals("보라")){
            System.out.println("밝고 활발한 사람");
        } else if(select.equals("초록")){
            System.out.println("리더십이 강한 사람");
        }

    }
}
