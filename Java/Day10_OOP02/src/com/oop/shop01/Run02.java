package com.oop.shop01;

public class Run02 {
    public static void main(String[] args) {
        //기본 생성자는 JVM 에서 스스로 만들어 준다
        IceCream ic = new IceCream();

        IceCream ic2 = new IceCream("001","바닐라",5000);
        Bread br  = new Bread("001","바게트",3000);
        Beverage bv = new Beverage("001", "우유", 2000);

        System.out.println(ic2.getName());
        System.out.println("아이스크림 할인 가격 : "+ic2.getPromotionPrice());
        System.out.println("빵 할인 가격 : "+br.getPromotionPrice());
        System.out.println("음료 할인 가격 : "+bv.getPromotionPrice());

    }

}
