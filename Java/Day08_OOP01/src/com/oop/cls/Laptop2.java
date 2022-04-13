package com.oop.cls;

public class Laptop2 {
    /*
    추상화 : 노트북이 갖고 있는 특성, 기능을 추려내는 작업
    ex_ 노트북
    특성 : 브랜드, 색상, 가격, 사이즈 등
    기능 : 전원 on/off
     */
    // 멤버변수 (멤버필드) 를 특성을 기준으로 작성
    private String brand;
    private String color;
    private int price;
    private double size;

    public Laptop2(){
    }

    public Laptop2(String brand, String color, int price, double size){
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.size =  size;
    }

    public String getBrand() {return brand;}

    public String getColor() {
        return color;
    }

    public double getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSize(double size) {
        this.size = size;
    }

    // 기능 -> 메서드(멤버 메서드)
    public void powerOn(){
        System.out.println("전원이 켜졌습니다.");
    }
    public void powerOff(){
        System.out.println("전원이 꺼졌습니다.");
    }
}