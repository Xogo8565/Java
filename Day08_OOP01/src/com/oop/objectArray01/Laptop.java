package com.oop.objectArray01;

public class Laptop {
    String brand;
    int price;
    String color;

    public Laptop() {
    }

    public Laptop(String brand, int price, String color){
       this.brand = brand;
       this.price = price;
       this.color = color;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }
    public String printAll(){
        return color+" : "+price+" : "+brand;
    }

}
