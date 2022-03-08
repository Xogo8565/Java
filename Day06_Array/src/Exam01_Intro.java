import java.util.Arrays;

public class Exam01_Intro {
    public static void main(String[] args) {
//        /*
//        배열(Array) : 같은 자료형의 집합
//        -> 같은 자료형 변수들을 모아서 하나의 이름으로 관리
//         */
////        int[] arr = new int[5];
//        /*
//        int[] -> int 형 배열을 의미 -> 참조자료형
//        (1) arr -> 변수명_참조변수
//        스택 영역에 int 형 변수 arr 생성
//
//        (2) new-> Heap 영역에 저장
//            int[5] -> Heap 영역에 5칸짜리 공간(변수)를 생성
//            -> 배열을 생성할 때는 반드시 사이즈를 명시적으로 표기
//
//        (3) = -> Heap 영역에 생성된 객체의 주소값을 stack 영역과 연결
//
//        (4) index 를 통해 배열 내 데이터 호출 가능
//        arr[0]
//        arr[1] ~
//         */
//
//        //배열 생성 후 초기화
//        int[] arr = new int[5];
//        arr[0] = 1;
//        arr[1] = 2;
//        arr[2] = 3;
//        arr[3] = 4;
//        arr[4] = 5;
//        System.out.println("arr" + arr);
//        // 실제 주소값은 아님 -> Heap 영역에 접근이 불가능하기 때문.
//        System.out.println("arr[0]: "+ arr[0]);
//        System.out.println("arr[1]: "+ arr[1]);
//        System.out.println("arr[2]: "+ arr[2]);
//        System.out.println("arr[3]: "+ arr[3]);
//        System.out.println("arr[4]: "+ arr[4]);
//
//        // 배열 생성과 함께 초기화
//        int[] arr2 = new int[] {1, 2, 3, 4, 5};
//        int[] arr3 = {1,2, 3, 4, 5};
//
//        //
//        int[] arr4 = new int[5];
//        System.out.println(arr[0]);
//        //stack 영역에 주소값이 들어있음. + Heap 영역에 초기값이 잡혀있다.
//
//        int a;
//        //System.out.println(a);
//        // 다른 변수와 할용
//
//        double[] arr5 = new double[] {0.5, 1.1, 1.5};
//        String[] arr6 = new String[] {"A", "B", "C"};
//
//        //반복문과 결합
//
//        int[]temp = new int[] {1,2,3,4,5};
//        for(int i =0; i<5; i++){
//            System.out.println("temp["+i+"] :" + temp[i]);
//        }
//        // 배열길이를 모르는 경우
//        System.out.println("temp length : " + temp.length);
//        for(int i=0; i<temp.length; i++){
//            System.out.println("temp["+i+"] :" + temp[i]);
//        }
//
//        //비어있는 배열에 데이터를 순차적으로 저장
//
//        int[] temp2 = new int[5];
//        for(int i =0; i < temp.length; i++){
//            temp2[i] = i+1;
//            System.out.println("temp2["+i+"] : " + temp2[i]);
//        }
//
        //int 형 배열 : 100칸, 0 ~99까지 담아보기
        int[] intArr = new int[100];
        for(int i = 0; i< intArr.length; i++){
            intArr[i] = i;
        }
        System.out.println(Arrays.toString(intArr));

        // int 형 배열 : 100칸, 99 ~ 0까지 담아보기
        int[] intArr2 = new int[100];
        for(int i = 0; i<intArr2.length; i++){
            intArr2[i] = 99-i;
        }
        System.out.println(Arrays.toString(intArr2));


    }
}
