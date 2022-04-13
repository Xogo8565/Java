import java.util.Scanner;

public class Practice08_Conditional {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("피연산자 1 입력 : ");
        int num1 = sc.nextInt();
        sc.nextLine();
        System.out.print("피연산자 2 입력 : ");
        int num2 = sc.nextInt();
        sc.nextLine();
        System.out.print("연산자를 입력 : ");
        String opt = sc.nextLine();

        if(num1>=0 && num2>=0){
            if (opt.equals("+")){
                System.out.println(num1+"+"+num2+"="+(num1+num2));
            } else if(opt.equals("-")){
                System.out.println(num1+"-"+num2+"="+(num1-num2));
            } else if(opt.equals("*")){
                System.out.println(num1+"*"+num2+"="+(num1*num2));
            } else if(opt.equals("/")){
                System.out.println(num1+"/"+num2+"="+(num1/num2));
            } else if(opt.equals("%")){
                System.out.println(num1+"%"+num2+"="+(num1%num2));
            } else {
                System.out.println("잘못 입력하셨습니다.");
                System.out.println("프로그램을 종료합니다.");
            }
        }
    }
}
