import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        String str = "동해물과\n" + "백두산이\n" + "마르고\n" + "닳도록";
        String[] strings = str.split("\n");

        for(String string : strings){
            System.out.println(string);
        }
    }
}
