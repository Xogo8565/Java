public class P70_06 {
    static int cardConv(int x, int r, char[] d){
        int digits = 0;

        String dchar = "0123456789ABDCEFGHIJKLMNOPQRSTUVWXYZ";

        do {
            d[digits++] = dchar.charAt(x%r);
            x /= r;

        } while (x != 0);

        for(int i = 0; i < digits; i++){
            char ch = d[i];
            d[i] = d[digits - i - 1];
            d[digits - i - 1] = ch;
        }

        return digits;
    }
}
