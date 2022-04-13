package com.collection.exam;

import java.util.ArrayList;

public class Exam01 {
    public static void main(String[] args) {
        // ArrayList : 똑똑한 동적 배역

         // 1. 생성
        String[] arr = new String[5];
        ArrayList list = new ArrayList<>();
        // 중간에 꺽쇠괄호가 나온다 + 사이즈를 기재해주지 않음.

        // 2. 값 추가
        arr[0] = "Apple"; // 배열의 인덱스를 황용해 값 추가
        list.add("Apple"); // add 라는 메서드를 활용해 0번 인덱스부터 순차적으로 값 추가

        // 3. 출력
        System.out.println("arr[0] : "+ arr[0]); //인덱스를 이용해 값 출력
        System.out.println("list.get(0) : "+ list.get(0)); // 인덱스를 get 메서드의 인자값으로 넘겨 값 출력

        // 값 추가
        arr[1] = "Banana";
        arr[2] = "Kiwi";
        arr[3] = "Mango";
        list.add("Banana");
        list.add("Kiwi");
        list.add("Mango");

        // 배열 길이 값 출력
        System.out.println("arr Length : "+ arr.length);
        System.out.println("List Length :"+list.size());

        //4. 값 삭제
        arr[1] = null;
        System.out.println("arr[1] : " + arr[1]);
        System.out.println("arr.length : " + arr.length);

        System.out.println("=== 삭제 전 ===");
        System.out.println("list.get(1) : " + list.get(1));
        System.out.println("list.size() : " + list.size());

        System.out.println("=== 삭제 후 ===");
        list.remove(1);
        System.out.println("list.get(1) : " + list.get(1));
        System.out.println("list.size() : " + list.size());

        for(int i = 0;i < list.size(); i++){
            System.out.print(list.get(i));
        }
        System.out.println(list.toString());
    }
}
