import java.util.Arrays;

public class Array {

    public static void main(String[] args) {
        //2차원 배열의 값들을 1차원배열로 옮기기
        // 2차원 배열 선언
        int[][] arr2 =
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9},
                        {10, 11, 12}
                };
        // 2차원 -> 1차원
        int[] arr = new int[arr2.length*arr2[0].length];
		/*  규칙 정리
		 	arr2[0].length = 3;
		 	arr[0][0] = 3 * 0 + 0;	0
		 	arr[0][1] = 3 * 0 + 1;	1
		 	arr[0][2] = 3 * 0 + 2;	2

		 	arr[1][0] = 3 * 1 + 0;	3
		 	arr[1][1] = 3 * 1 + 1;	4
		 	arr[1][2] = 3 * 1 + 2;	5

		 	arr[2][0] = 3 * 2 + 0;	6
		 	arr[2][1] = 3 * 2 + 1;	7
		 	arr[2][2] = 3 * 2 + 2;	8
		 				:
		 				:
		 				:
		 */

        //1차원 배열에 값 담기
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                arr[arr2[i].length * i + j] = arr2[i][j];
            }
        }
        // 출력
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //1차원 배열 선언
        int arrLength = 0;
        for(int i =0; i<arr2.length; i++){
            for(int j =0; j<arr2[i].length; j++){
                arrLength++;
            }
        }
        int[] arr3 = new int[arrLength];

        //1차원 배열에 값 담기
        for(int i =0; i<arr2.length; i++){
            for(int j =0; j<arr2[i].length; j++){
                arr3[arr2[i].length * i + j] = arr2[i][j];
            }
        }

        System.out.println(Arrays.toString(arr3));



    }

}