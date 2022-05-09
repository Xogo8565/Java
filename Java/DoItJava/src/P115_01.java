import java.util.Scanner;

public class P115_01 {
    static int seqSearchSen(int[] a, int n, int key){
        for (int i = 0; i < n; i ++){
            if (a[i] == key) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("요소 수: ");
        int num = Integer.parseInt(sc.nextLine());
        int[] x = new int[num+1];

        for(int i = 0; i < num; i ++){
            System.out.print("x[" + i + "] : ");
            x[i] = Integer.parseInt(sc.nextLine());
        }

        System.out.print("검색할 값 : ");
        int ky = Integer.parseInt(sc.nextLine());

        int idx = seqSearchSen(x, num, ky);

        if (idx == -1){
            System.out.println("그 값의 요소가 없습니다.");
        } else System.out.println(ky + "은 x["+ idx + "에 있습니다.");


    }
}
