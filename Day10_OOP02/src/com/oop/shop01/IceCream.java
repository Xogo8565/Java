package com.oop.shop01;

//자식 클래스 extends 상속받고 싶은 클래스명(부모 클래스)
public class IceCream extends Product {
    public IceCream() {
        // super(); -> 명시적으로 기재하지 않아도 자동으로 생성되는 코드
        //             상속해주는 부모 클래스를 참조하는 변수
        //             부모 클래스의 기본 생성자를 호출하는 작업
        //             IceCream 의 생성자를 호출하면
        //             부모 클래스의 인스턴스 또한 생성됨.
        //             반드시 첫번째 코드에 위치해야 한다.
    }

    public IceCream(String product_no, String name, int price){
        //private 접근제한자 때문에 멤버 필드에 접근이 불가
        //this.product_no = product_no;
        //this.name = name;
        //this.price = price;

        // getter, setter 를 통한 값 세팅
//        this.setProduct_no(product_no);
//        this.setName(name);
//        this.setPrice(price);\

        // 부모의 매개변수 있는 생성자 활용업
    }

    /* 메서드의 오버라이딩
    부모클래스가 가지고 있는 메서드를 재정의하는 작업

    cf) 오버로딩
    -> 하나의 클래스 안에서 이뤄짐
    -> 똑같은 이름의 메서드를 리턴타입이나 개수를 달리해주는 작업
    -> 리턴타입 동일

    vs 오버라이딩
    -> 다른 클래스 안에서 이뤄짐
    - 똑같은 이름의 메서드, 똑같은 반환타입, 똑같은 매개변수
    -> 부모 클래스가 가지고 있는 이름의 메서드를 무효화시킴

     */
    public double getPromotionPrice(){
        return this.getPrice()*0.01;
    }
}
