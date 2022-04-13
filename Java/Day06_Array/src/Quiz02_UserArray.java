import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Quiz02_UserArray {
    public static void main(String[] args){
        // 사용자에게 입력받은 정수만큼 int 형 배열의 크기를 할당

        //NumberFormatException : 예외 처리 필요
        // try {}~ catch(){} :
        // try 문 안쪽의 코드에서 에러가 발생했다면 catch 문 안쪽의 코드 실행
        Scanner sc = new Scanner(System.in);
        int inputNum =0;
        try{ // 에러가 발생할 여지가 있는 코드
            System.out.print("숫자를 입력하세요 >> ");
            inputNum = Integer.parseInt(sc.nextLine());
        } catch(NumberFormatException e){//NumberFormatException  : 숫자 형식 예외만 잡아 줌.
            // 에외 발생시 실행할 코드
            System.out.println("잘못된 입력입니다.");
        }
        try{
            int[] intArr = new int[inputNum];
            System.out.println("arr size : " + intArr.length);
            System.out.println(intArr[10]);
        } catch (Exception e){//exception 종류 불문하고 실행
            System.out.println("없는 인덱스 번호입니다.");
        }
    }
}
