import java.util.Arrays;

public class Exam03_Swap {
    public static void main(String[] args) {
        // 순서바꾸기
//        char[] arr = new char[] {'A','B'};
//        System.out.println(Arrays.toString(arr));
//        char temp = arr[0]; // arr[0] 값을 담을 임시공간
//        arr[0] = arr[1]; // arr[0]과 arr[1] swap
//        arr[1] = temp; // arr[1]에 temp 값 대입
//        System.out.println(Arrays.toString(arr));

        // hello 가 담긴 char 배열 -> olleh 가 담긴 배열로 만들기
        char[] hello = {'h','e','l','l','o'};
        char[] olleh = new char[hello.length];// hello 성열과 동일한 크기의 배열 생성
        for(int i =0; i<hello.length; i++){ // for 문을 활용하여 olleh 배열에 hello 배열 값 역순으로 복사
            olleh[hello.length-1-i] = hello[i];
        }
        for (int i =0; i<hello.length; i++) {
            hello[i] = olleh[i];
        }
        System.out.println(Arrays.toString(hello)); // 출력

        /* 강사님 풀이
        중간 지점이 3
        h<->o
        e<->l
        2번의 값 변회(배열의 길이/2의 몫만큼 바뀐다)-> 반복문의 횟수
        ---------------------------------------------------
        char tmp; // 기존의 값을 담을 임시배열
        for(int i =0; i<hello.length/2; i++){
            tmp = hello[i];
            hello[i] = hello[hello.length-1-i];
            hello[hello.length-1-i] = tmp;
        }
        System.out.println(Arrays.toString(hello));

        */
    }
}
