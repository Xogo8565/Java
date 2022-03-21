package com.collection.exam;

import java.util.ArrayList;

public class Exam02 {
    public static void main(String[] args) {
        String[] arr = new String[3];
        arr[0] = "Apple";
        // arrr[1] = 10; //typeMismatching

        ArrayList list = new ArrayList<>();
        list.add("Apple");
        list.add(10); // 에러 발생 x
        list.add(36.5);
        list.add(true);

        // 배열 : 같은 자료형의 데이터를 묶어놓은 합
        // ArrayList -> 배열이지만 다양한 자료형의 값을 담을 수 있음(Object 형 배열이기 때문에).
        // object (Java 의 모든 클래스들은 Object 를 상속 받음)
        // 다형성 : 다양한 클래스(자식)들의 성질을 가질 수 있는 것

        //Object 형이기 대문에 String 형으로 바로 변경 불가

        char temp1 = ((String)list.get(0)).charAt(0);
        System.out.println("temp : " + temp1);
        int temp2 = ((int)list.get(1));
        double temp3 = ((double)list.get(2));
        boolean temp4 = ((boolean)list.get(3));

    }
}
