package com.oop.cls;

public class Laptop {
    /*
    추상화 : 노트북이 갖고 있는 특성, 기능을 추려내는 작업
    ex_ 노트북
    특성 : 브랜드, 색상, 가격, 사이즈 등
    기능 : 전원 on/off
     */
    // 멤버변수 (멤버필드) 를 특성을 기준으로 작성
    String brand;
    String color;
    int price;
    double size;

    // 기능 -> 메서드(멤버 메서드)
    public void powerOn(){
        System.out.println("전원이 켜졌습니다.");
    }
    public void powerOff(){
        System.out.println("전원이 꺼졌습니다.");
    }
}