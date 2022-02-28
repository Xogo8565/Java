import java.util.Scanner;

public class Exam01_Scanner {
    public static void main(String[] args) {
//        /* Scanner : 출력용으로만 쓰던 console 창에 입력도 가능하게 해주는 jdk에 내장된 도구
//        import : 외부로부터 필요한 도구를 가져오는 작업
//         */
        Scanner sc = new Scanner(System.in);
//
//        String str1 = sc.nextLine();
//        System.out.println("strInput : " + str1);
//        /*nextLine()
//        엔터 이전까지의 문자열 반환
//         */
//        String str2 = sc.next();
//        System.out.println("strInput2 : " + str2);
//        /*next()
//         공백을 기준으로 한 단어 또는 한 문자씩 입력받는다. 첫번째 띄어쓰기 or 엔터 이전까지의 값만 인식
//         */
//        int i = sc.nextInt();
//        System.out.println("intInput : " + i);
//
//
//        /*
//        Cf) nextLine() 사용 전에 nextInt()[명시적인 next 메소드], next()를 사용한 경우 \n이 버퍼에 남아 다음 nextLine()을 건너뛰게 된다.
//        이 때, nextLine을 한 번 더 호출하면 남아있는 엔터값이 사라지게 됨.
//         */
//
//        // 사용자에게 이름, 나이, 직업을 입력받아 출력받기
        System.out.println("이름 : ");
        String name = sc.next();
        sc.nextLine();
        System.out.println("나이 : ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("직업 : ");
        String job = sc.nextLine();
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
        System.out.println("직업 : " + job);

         // 버퍼 이슈 해결방법 2. Integer.parseInt(); 활용

        System.out.println("이름 : ");
        String name2 = sc.nextLine();
        System.out.println("나이 : ");
        int age2 = Integer.parseInt(sc.nextLine()); // nextLine으로 입력된 문자열을 int값으로 변환
        System.out.println("직업 : ");
        String job2 = sc.nextLine();
        System.out.println("이름 : " + name2);
        System.out.println("나이 : " + age2);
        System.out.println("직업 : " + job2);

        // Cf) nextLine() : String to boolean
        System.out.println("true or false를 입력하세요");
        boolean condition = Boolean.parseBoolean(sc.nextLine());
        System.out.println("Condition : " + condition);

        // Cf2) nextLine().charAt : String to char
        System.out.println("성별을 입력하세요");
        char ch = sc.nextLine().charAt(0);
        System.out.println("Sex :" + ch);

    }
}
