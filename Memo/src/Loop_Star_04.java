
public class Loop_Star_04 {
    /*  *****
        ****
        ***
        **
        *
     */
    public static void main(String[] args) {
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j <= 6 - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
