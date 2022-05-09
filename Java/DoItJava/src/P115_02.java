import java.util.Scanner;

public class P115_02 {
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

        System.out.print("   |");;
        for(int i = 0; i < num; i++){
            System.out.printf("%3d",i);
        }
        System.out.println("\n--- + -----------------------");

        int idx = seqSearchSen(x, num, ky);

        String list = "  ";
        for(int i = 0; i < num; i++){
            list += x[i]+ "  ";
        }

        for(int i = 0; i < num; i++){
            for (int j = 0; j < 3*i+4; j += 3){
                System.out.print("   ");
            }
            System.out.println("*");
            System.out.println(i+"  |" + list);
        }

        if (idx == -1){
            System.out.println("그 값의 요소가 없습니다.");
        } else System.out.println(ky + "은 x["+ idx + "]에 있습니다.");

    }
}
