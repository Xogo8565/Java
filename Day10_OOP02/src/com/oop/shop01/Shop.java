package com.oop.shop01;

public class Shop { //재고 관리
    //갸게 이름, openTime, closeTime, IceCream
    private String name;
    private String openTime;
    private String closeTime;
    private IceCream[] iceCream;
    private Bread[] bread;
    private Beverage[] beverage;
    private int iceIndex = 0;
    private int breadIndex = 0;
    private int beverageIndex = 0;

    public Shop(String name, String openTime, String closeTime, IceCream[] icecream, Bread[] bread) {
        this.name = name;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.iceCream = icecream;
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

    public IceCream[] getIceCream() {
        return iceCream;
    }

    public void setIceCream(IceCream[] iceCream) {
        this.iceCream = iceCream;
    }

    public Bread[] getBread() {
        return bread;
    }

    public void setBread(Bread[] bread) {
        this.bread = bread;
    }

    public Beverage[] getBeverage() {
        return beverage;
    }

    public void setBeverage(Beverage[] beverage) {
        this.beverage = beverage;
    }

    public void addIceCream(IceCream icecream) {
        this.iceCream[iceIndex++] = icecream;
    }

    public void addBread(Bread bread) {
        this.bread[breadIndex++] = bread;
    }

    public void addBeverage(Beverage beverage) {
        this.beverage[beverageIndex++] = beverage;
    }

    public String printIceCream(){
        String rs = "";
        for(int i =0; i< iceCream.length; i++){
            if(this.iceCream[i]!=null){
                rs += this.iceCream[i].getProduct_no()
                        + this. iceCream[i].getName()
                        + this. iceCream[i].getPrice()
                        +"\n";
            }
        }
        return  rs;
    }

    public String printBread(){
        String rs = "";
        for(int i =0; i< bread.length; i++){
            if(this.bread[i]!=null){
                rs += this.bread[i].getProduct_no()
                        + this. bread[i].getName()
                        + this. bread[i].getPrice()
                        +"\n";
            }
        }
        return  rs;
    }
    public String printBeverage(){
        String rs = "";
        for(int i =0; i< beverage.length; i++){
            if(this.beverage[i]!=null){
                rs += this.beverage[i].getProduct_no()
                        + this. beverage[i].getName()
                        + this. beverage[i].getPrice()
                        +"\n";
            }
        }
        return  rs;
    }
}
