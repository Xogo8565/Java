package com.collection.exam;

import java.util.ArrayList;

public class Exam03 {
    public static void main(String[] args) {

        ArrayList tempArr = new ArrayList<>();
        tempArr.add("apple");

        // 제네릭(Generic) -> ArrayList 도 결국 배열 -> ArrayList 에 저장할 자로형을 명시해주는 것
        //제네릭을 사용하면 저장할 데이터의 타입을 걸러주는 역할을 함

        ArrayList<String> strList = new ArrayList<>();

        strList.add("Apple");
        // strList.add(10); -> String 이 아니므로 오류 발생

        // apple 값에서 a 값만
        char a = ((String)tempArr.get(0)).charAt(0);
        System.out.println("a : " + a);

        //Generic 을 사용하게 되면 강제 형변환 x
        char a2 = strList.get(0).charAt(0);
        System.out.println("a2 : " + a2);

        /* 기본 자료형 ArrayList
        기본 자료형(boolean, byte, shor, int, long, char, doulbe, float)
        -> 클래스가 아님. 자바에서 지정해놓은 특수한 기본 자료형

        Wrapper Class
        -> 기본 자료형들을 감싸고 있는 클래스 -> 기본 자료형을 참조 자료형 처럼 사용하는 게 가능하도록 해줌

       int -> Integer
       double -> Double
       float -> Float
       char -> Character

       Cf) Wrapper Class의 값을 비교할 때는 ==, equals() 모두 사용가능
       오토박싱과 언박싱이 자동으로 이뤄지기 때문
         */

        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(10);
        System.out.println("intList.get(0) : " + intList.get(0));
        ArrayList<Double> doubleList = new ArrayList<>();
        ArrayList<Character> charList = new ArrayList<>();
        ArrayList<Boolean> boolList = new ArrayList<>();

    }
}
