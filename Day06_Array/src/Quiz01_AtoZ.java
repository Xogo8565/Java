import java.util.Arrays;

public class Quiz01_AtoZ {
    public static void main(String[] args) {
        // char 형 배열; 26칸짜리 만들어서 알파벳 A부터 Z까지 저장
        char[] chArr = new char[26];
        for(int i = 0; i<chArr.length; i++) {
            chArr[i] = (char)(65 + i);
        }
        System.out.println(Arrays.toString(chArr));

        // foreach : 향상된 for 문
        // 배열의 첫 index 부터 마지막까지 순차적으로 반복
        // 일반적인 for 문의 경우 조건식을 통해 언제까지 반복해줄지를 지정하는 게 가능
        // 자료형 i : (배열/컬렉션)의 참조변수
        for (char i : chArr) {
            System.out.print(i+" ");
        }
    }
}
