import java.util.Arrays;

public class Exam04_Copy {
    public static void main(String[] args) {
        // 배열 복사
        // 1) 얕은 복사,  2) 깊은 복사
        /* 1) 얇은 복사 :
        Stack 영역의 arr2 변수에 arr1 주소값이 복사됨. -> 동일한 주소값을 가르키게 된다.
        arr2 참조변수를 통해 값을 변경하면 Heap 영역의 값이 변경되면서, arr 참조변수의 주소값의 데이터도 수정됨.
         */
        int[] arr = {1,2,3};
        System.out.println("arr 주소 : " + arr);
        System.out.println("arr 복사 전 : " + Arrays.toString(arr));
        int[] arr2 = arr;
        arr2[0] = 10; //arr[0] 변화
        System.out.println("arr2 주소 : " + arr2);
        System.out.println("arr 복사 후 : " + Arrays.toString(arr));


        /* 2) 깊은 복사
        실제 배열 안에 들어있는 값만 복사가 이뤄지는 것.
        arr3와 arr4는 별도의 주소값을 갖게 됨.
        arr4의 참조변수를 통해 값을 변경해도, 원본 데이터(arr3)에는 영향이 없다.
         */
        // 2-1) 반복문 활용
        int[] arr3 = {1,2,3};
        int[] arr4 = new int[3];
        System.out.println("arr3 주소 : " + arr3);
        System.out.println("arr3 복사 전 : " + Arrays.toString(arr3));
        for(int i =0; i<3; i++){
            arr4[i] = arr3[i];
        }
        arr4[0]=10;
        System.out.println("arr4 주소 : " + arr4);
        System.out.println("arr3 복사 후 : " + Arrays.toString(arr3));

        //
    }
}
