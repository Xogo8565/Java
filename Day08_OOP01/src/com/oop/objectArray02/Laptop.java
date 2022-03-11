package com.oop.objectArray02;

public class Laptop {
    String brand;
    int price;
    String color;

    Laptop(){

    }
    Laptop(String brand, int price, String color){
        this.brand = brand;
        this.price = price;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String printAll(){
        return brand + " : " + price + " : " + color;
    }

}
