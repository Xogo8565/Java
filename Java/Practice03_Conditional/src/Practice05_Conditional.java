import java.util.Scanner;

public class Practice05_Conditional {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String myId = "myId";
        String myPwd = "123456";
        System.out.print(" 아이디 : ");
        String inputId = sc.nextLine();
        System.out.print(" 비밀번호 : ");
        String inputPwd = sc.nextLine();

        if (inputId.equals(myId)) {
            if( inputPwd.equals(myPwd)){
                System.out.println("로그인 성공");
            } else {
                System.out.println("비밀번호가 틀렸습니다.");
            }
        } else {
            System.out.println("아이디가 틀렸습니다.");
        }

    }
}
