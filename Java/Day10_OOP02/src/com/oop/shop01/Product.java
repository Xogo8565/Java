package com.oop.shop01;

//추상 메서드를 하나라도 가진 클래스는 반드시 추상 클래스가 되야 함.
//추상클래스 -> new 연산자 사용 불가능
public abstract class Product {
    private String product_no;
    private String name;
    private int price;

    public Product () {
    }

    public Product(String product_no, String name, int price) {
        this.product_no = product_no;
        this.name = name;
        this.price = price;
    }

    public String getProduct_no() {
        return product_no;
    }

    public void setProduct_no(String product_no) {
        this.product_no = product_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // 할인율이 적용된 가격을 반환하는 메서드
    // 추상메서드 : 메서드의 내용을 만들지 않고 틀만 만들어 놓은 메서드
    // -> 반드시 자식 메서드에서 재정의 해서 사용해야 하는 메서드

    public abstract double getPromotionPrice();
}
