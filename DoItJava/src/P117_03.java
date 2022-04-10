import java.util.Scanner;

public class P117_03 {
    static int searchIdx(int[] a, int n, int key, int[] idx) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] == key) idx[count++] = i;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("요소 수: ");
        int num = Integer.parseInt(sc.nextLine());
        int[] x = new int[num];
        int[] y = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = Integer.parseInt(sc.nextLine());
        }

        System.out.print("검색할 값 : ");
        int ky = Integer.parseInt(sc.nextLine());

        int count = searchIdx(x, num, ky, y);

        if (count == 0) System.out.println("그 값의 요소가 없습니다.");
        else for (int i = 0; i < count; i++)
            System.out.println("그 값은 " + "x[" + y[i] + "]에 있습니다.");
    }
}