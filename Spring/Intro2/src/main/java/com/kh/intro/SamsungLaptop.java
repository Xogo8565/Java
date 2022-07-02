package com.kh.intro;

public class SamsungLaptop extends Laptop {
    private int price;
    public SamsungLaptop() {
        System.out.println("삼성 노트북 인스턴스 생성");
    }

    public SamsungLaptop(int price) {
        this.price = price;
        System.out.println("생성자주입");
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
