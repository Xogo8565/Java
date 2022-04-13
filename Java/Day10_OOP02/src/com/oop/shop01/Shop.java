package com.oop.shop01;

public class Shop { //재고 관리
    //갸게 이름, openTime, closeTime, IceCream
    private String name;
    private String openTime;
    private String closeTime;
    private Product[] product;
    private int index = 0;

    //this. 를 붙이지 않으면 멤버필드가 아닌 배개변수 name 이 호출된다.
    public Shop(String name, String openTime, String closeTime, Product[] product) {
        this.name = name;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.product = product;
    }

    public Shop() {}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public Product[] getProduct() { return product; }

    public void setProduct(Product[] product) { this.product = product; }

    public void addProduct(Product product) {
        this.product[index++] = product;
    }

    public String printProduct(){
        String rs = "";
        for(int i =0; i< product.length; i++){
            if(this.product[i]!=null){
                rs += this.product[i].getProduct_no() + " "
                        + this.product[i].getName() + " "
                        + this.product[i].getPrice()+ " "
                        +"\n";
            }
        }
        return  rs;
    }

}
