public class P64_05 {
    static void rcopy(int[] a, int[] b){
        int length = a.length <= b.length ? b.length : a.length;
        for(int i =0; i<length; i++){
            b[a.length-i-1] = a[i];
        }
    }
}
