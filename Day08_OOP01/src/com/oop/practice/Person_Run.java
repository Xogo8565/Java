package com.oop.practice;

import java.util.Scanner;

public class Person_Run {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Person p = new Person();
        System.out.println("=== 회원 정보 입력 ===\n1. 고유번호를 입력하세요 (4가지 숫자) >>> ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("2. 이름을 입력하세요 >> ");
        String name = sc.nextLine();
        System.out.println("3. 연락처를 입력하세요 >> ");
        String contact = sc.nextLine();

        //#3 값 저장

        p.setId(id);
        p.setName(name);
        p.setContact(contact);

        //#4 출력

        System.out.println("#4 Test");
        System.out.println(p.getId()+"\n"+p.getName()+"\n"+p.getContact());

        //#5 변경

        p.setName("Larry");
        p.setContact("01012344321");

        //#6
        System.out.println("#6 Test");
        System.out.println(p.printAll());

    }
}
