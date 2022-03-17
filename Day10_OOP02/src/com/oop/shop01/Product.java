package com.oop.shop01;

public class Product {
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

    //0.02% 의 할인율이 적용된 가격을 반환하는 메서드
    public double getPromotionPrice(){
        return 0.02*price;
    }
}
