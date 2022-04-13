package com.oop.objectArray01;

public class LaptopRun {
    public static void main(String[] args) {
        Laptop LgLaptop = new Laptop("LG", 200000, "White");
        Laptop Mac = new Laptop("Apple", 500000, "Silver");
        Laptop SamsungLaptop = new Laptop("Samsung", 300000, "Red");

        //Laptop 형 배열 5칸짜리
        Laptop[] laptops = new Laptop[5];
        //Laptop 형 인스턴스의 주소값이 laptops 배열에 저장

        laptops[0] = LgLaptop;
//        System.out.println(laptops[0]);
//
//        //참조연산자(.)를 통해 주소값을 불러 온 후 get 메서드를 활용해 값 출력 가능
//        System.out.println(laptops[0].getBrand());
//        System.out.println(laptops[0].getPrice());
//        System.out.println(laptops[0].getColor());
//        System.out.println(laptops[0].printAll());

        laptops[1] = Mac;
//        System.out.println(laptops[1]);
//        System.out.println(laptops[1].getBrand());
//        System.out.println(laptops[1].getPrice());
//        System.out.println(laptops[1].getColor());
//        System.out.println(laptops[1].printAll());

        laptops[2] = SamsungLaptop;
//        System.out.println(laptops[2]);
//        System.out.println(laptops[2].getBrand());
//        System.out.println(laptops[2].getPrice());
//        System.out.println(laptops[2].getColor());
//        System.out.println(laptops[2].printAll());


//        for(int i = 0; i<laptops.length; i++){
//            if(laptops[i] != null) System.out.println(laptops[i].printAll());
//        }
        //nullPointException -> 참주좌료형의 default : null
        //주소값을 참조하려는데 null 이 나오다는 의미

    laptops[3] = new Laptop("LG", 450000, "Blue");
    laptops[4] = new Laptop("Dell", 500000, "Pink");

    System.out.println(" 수정 전 :" + laptops[3] +":"+laptops[4]);

    // 기존의 Laptops[3]에 [4]를 대입하면 같은 인스턴스를 가르키게 되면서 기존의 laptops[3] 인스턴스는 GC에 의해 Heap 영역에서 삭제됨.
    laptops[3] = laptops[4];

    System.out.println(" 수정 후 :" + laptops[3] +":"+laptops[4]);
    laptops[0].setPrice(400000);
    System.out.println("수정 후 :"+laptops[0].getPrice());
    laptops[0] = null;
//    System.out.println("수정 후 :"+laptops[0].printAll());

    System.out.println("수정 전 :"+laptops[2].printAll());
    laptops[2].setBrand("Dell");
    laptops[2].setColor("Blue");
    System.out.println("수정 후 :"+laptops[2].printAll());

    }
}
