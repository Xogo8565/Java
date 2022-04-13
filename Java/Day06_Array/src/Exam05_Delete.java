import java.util.Arrays;
import java.util.Scanner;

public class Exam05_Delete {
    public static void main(String[] args) {
        //배열 삭제
        // 배열은 처음 만들 때 사이즈 고정
        int[] arr = {1,2,3};
        //초기값인 0을 이용해 의미없는 값으로 만들어 버리기
//        arr[1] = 0;
//
//        for(int i : arr){
//            System.out.println(i);
//        }
//
//
//        String[] strArr = {"abc", "가나다", "50"};
//        strArr[0] = null;
//        for(String s : strArr) {
//            if(s != null){
//                System.out.println(s);
//            }
//        }

        //int 형 배열 안에서 사용자가 입력한 값만 삭제하기
        Scanner sc = new Scanner(System.in);
        int[] intArr = {1,2,3,4,5,6,7,8,9,10};
        int inputNum=0;
        System.out.println(Arrays.toString(intArr));
        System.out.print("삭제값 입력 : ");
        try{
            inputNum = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e){
            System.out.println("잘못된 입력입니다.");
        }

        for(int i =0; i<intArr.length; i++){
            if(intArr[i]== inputNum){
                intArr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(intArr));
    }
}


