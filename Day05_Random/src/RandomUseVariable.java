public class RandomUseVariable {
    public static void main(String[] args) {
        //위에서 변수를 선언하고 아래에서 사용하려면 주의가 필요하다.
        //ex)
        int maxValue = 10;
        int minValue = 1;
        String rs;
        int i = (int)(Math.random()*(maxValue-minValue+1)+minValue);

       // #1
//        if(i%2==1){
//        rs = "짝";
//        } else if (i%2==0) {
//        rs = "홀";
//        }
//        System.out.println(rs);
//        ---> Run 버튼을 누르기 전까진 i 값에 무엇이 할당될지 알 수 없음. Error 가 발생할 수 있다.


        //#2
        if(i%2==0){
        rs = "짝";
        } else {
        rs = "홀";
        }
        System.out.println(rs);
        //  ---> else 키워드로 강제성 부여하면 Error 가 없다.

        //#3

        rs = null;
        // 변수를 먼저 초기화 하고 사용하는 방법도 존재.

        if(i%2==1) {
        rs = "짝";
        } else if (i%2==0) {
        rs = "홀";
        }
        System.out.println(rs);
    }
}

