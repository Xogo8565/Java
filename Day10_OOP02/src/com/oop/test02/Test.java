package com.oop.test02;

class A{
    public void funcA(){
        System.out.println("funcA");
    }
    public void funcExtra() {
        System.out.println("A");
    }
}

class B extends A {
    public void funcB(){
        System.out.println("funcB");
    }
    public void funcExtra(){
        System.out.println("B");
    }
}

class C extends A {
    public void func() {
        System.out.println("funcC");
        }
}

public class Test {
    //다형성
    /*
    다형성 : 다형한 형태의 성질을 가지는 것
    (상속관곙체서 부모 타입의 참조변수가 자식 타입의 인스턴스를 가질 수 있는 것)
     */
    public static void main(String[] args) {
        //자식을 상속받는 모든 자식형 인스턴스를 부모형 참조변수에 담을 수 있다.

        A a1 = new B();
        a1.funcA();
        a1.funcExtra();

        A a2 = new C();
        a2.funcA();
        a2.funcExtra();

        //
        int a = 10;
        long b = a; //자동 형변환 큰 자료형에 작은 자료형을 담는 UpCasting

        //부모형 참조변수로 자식의 기능을 사용하게 하고 싶다면
        // 강제 형변환 -> a라는 참조 변수(상위클래스)를 B 형으로(자식 클래스)로 다운 캐스팅
        ((B)a1).funcB();
        ((C)a2).func();;

        //반대로 자식 클래스형 참조변수에 부모 인스턴스를 담는 것은 불가능
//        B b1 = new A();
//        C c1 = new A();

//        B b2 = (B)(new A());
//        b2.funcA();
//        b2.funcB();

    }
}
