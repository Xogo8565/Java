package com.oop.cls;

public class Run_Laptop2 {
    public static void main(String[] args) {
        // (좌)Stack 영역에 Laptop 자료형 laptop 변수 생성
        // (우)Heap 영역에 객체 생성(인스턴스화) -> 사용자가 정의해 만들어진 클래스는 모두 참조자료형
        Laptop2 laptop = new Laptop2();
        // laptop 의 주소값 출력
//        System.out.println(laptop);
//        // 참조변수. -> 참조변수의 주소값이 있는 Heap 영역으로 들어간다는 의미
//        // 설정 전에는 Default 값이 들어가 있음
//        System.out.println(laptop.brand);
//        System.out.println(laptop.price);

        laptop.setBrand("LG");
        laptop.setColor("White");
        laptop.setPrice(500000);
        laptop.setSize(16.5);

        System.out.println(laptop.getBrand());
        System.out.println(laptop.getColor());
        System.out.println(laptop.getPrice());
        System.out.println(laptop.getPrice());

        laptop.powerOn();
        laptop.powerOff();

//        laptop.brand = "Apple";
//        laptop.color = "Space Grey";
//        laptop.price = 1000000;
//        laptop.size = 13.0;
//
//        System.out.println(laptop.brand);
//        System.out.println(laptop.color);
//        System.out.println(laptop.price);
//        System.out.println(laptop.size);

        // 새로운 인스턴스 생성

        Laptop2 laptop2 = new Laptop2();
        laptop2.setBrand("Apple");
        laptop2.setColor("Space Grey");
        laptop2.setPrice(1000000);
        laptop2.setSize(15.0);
    }
}
