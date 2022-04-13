public class Exam02_Intro {
	public static void main(String[] args) {
		// 자바에서 "" : 문자열
		// '' : 문자
////	System.out.println(''); ''-> 공백 사용 불가
//		System.out.println(""); // "" -> 공백 사용 가능
//		System.out.println("a");
//		System.out.println('가');
////	System.out.println('가나다'); 가나다 -> 문자열이므로 오류 발생
//		System.out.println("50");
//		System.out.println(50);
//		System.out.println(0.48);
//		System.out.println(-5.35); //int, double -> "" x여도 가능

		//실습 1 : 인사말, 본인의 이름, 영어이름, 나이, 체온 측정
		System.out.println("안녕하세요?");
		System.out.println("저의 이름은 장석수입니다. 영어 이름은 JangSeoksu입니다.");
		System.out.print("제 나이는 ");
		System.out.print(28);
		System.out.print("살입니다.");
		System.out.print("\n오늘의 체온 측정 결과는 ");
		System.out.print(36.6);
		System.out.println("도입니다.");
		System.out.println("");


		// + : 문자열 연결 / 덧셈
		System.out.println("안녕하세요?");
		System.out.println("저의 이름은 장석수입니다. 영어 이름은 JangSeoksu입니다.");
		System.out.println("제 나이는 " + 28 + "살입니다." );
		System.out.println("오늘의 체온 측정 결과는 " + 36.6 +"도 입니다.");
		System.out.println();

		// 문자와 숫자를 연결할 때 주의해야 하는 점
		// 순서에 따라 문자와 숫자가 연결되어 문자로 합쳐질 수도, 숫자와 숫자가 더해져 덧셈이 될 수도 있음.
		System.out.println("a"+"b"+5+10);
		System.out.println(5+10+"a"+"b");

	}
}
