public class P19_02 {
    static int min3(int a, int b, int c){
        int min = a;
        if(min>b) min = b;
        if(min>c) min = c;
        return  min;
    }

    public static void main(String[] args) {
        System.out.println(min3(3,2,10));
        System.out.println(min3(3,4,10));
        System.out.println(min3(12,22,10));
    }
}
