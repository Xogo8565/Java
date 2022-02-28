import java.util.Scanner;

public class Practice06_Conditional {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("권한을 확인하고 하는 회원 등급 : ");
        String memGrade = sc.nextLine();

        if(memGrade.equals("관리자")){
            System.out.println("회원관리, 게시글 관리, 게시글 작성, 댓글 작성, 게시글 조회");
        } else if(memGrade.equals("회원")){
            System.out.println("게시글 작성, 댓글 작성, 게시글 조회");
        } else if(memGrade.equals("비회원")){
            System.out.println("게시글 조회");
        }else {
            System.out.println("잘못 입력하셨습니다.");
        }

    }
}
