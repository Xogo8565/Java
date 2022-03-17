package com.oop.shop01;

public class Bread extends Product{
    public Bread(){
    }
    public Bread(String product_no, String name, int price){
        super(product_no, name, price);
    }
    public double getPromotionPrice(){
        return this.getPrice()*0.03;
    }
}
