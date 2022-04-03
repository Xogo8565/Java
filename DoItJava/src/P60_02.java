import java.util.Arrays;
import java.util.Random;

public class P60_02 {


    public static void main(String[] args) {

        Random random = new Random();
        int[] intArr = new int[6];

        for(int i =0; i< intArr.length; i++){
            intArr[i] = random.nextInt();
        }

        int num;

        for(int i = 0; i< intArr.length/2; i ++) {
            System.out.println("intArr[" + i + "]번과 intArr[" + (5 - i) + "]번을 교환합니다.");
            num = intArr[i];
            intArr[i] = intArr[5 - i];
            intArr[5 - i] = num;
            System.out.println(Arrays.toString(intArr));
        }

        System.out.println("정렬을 마쳤습니다.");


    }
}
