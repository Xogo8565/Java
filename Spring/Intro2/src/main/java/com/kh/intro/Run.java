package com.kh.intro;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Run {
    public static void main(String[] args) {
//        SamsungLaptop samsungLaptop = new SamsungLaptop();
//        samsungLaptop.turnOn();
//        samsungLaptop.soundDown();
//        samsungLaptop.soundUp();
//        samsungLaptop.turnOff();
//
//        LgLaptop lgLaptop = new LgLaptop();
//        samsungLaptop.turnOn();
//        samsungLaptop.soundDown();
//        samsungLaptop.soundUp();
//        samsungLaptop.turnOff();

        // 다형성 : 부모 클래스 참조변수가 자식 클래스 인스턴스를 담을 수 있는 성질
//        Laptop laptop = new SamsungLaptop();
//        laptop.turnOn();
//        laptop.soundUp();
//        laptop.soundDown();
//        laptop.turnOff();

        // 팩토리 패턴 : 인스턴스의 생성은 팩토리 클래스가 담당하고 개발자는 어떤 인스턴스를 생성할지에 대한 값만 넘겨서 인스턴스를 반환 받는 방식
//        BeanFactory beanFactory = new BeanFactory();
//        Laptop laptop = beanFactory.getBean("lg");
//        laptop.turnOn();
//        laptop.soundUp();
//        laptop.soundDown();
//        laptop.turnOff();

        AbstractApplicationContext abstractApplicationContext = new GenericXmlApplicationContext("applicationContext.xml");
        // bean instance 사용
        /*
        * DL(Dependency Lookup) : 스프링 컨테이너에서 알아서 생성해준 인스턴스들을 가져다 사용하는 것
        * */
        SamsungLaptop laptop = (SamsungLaptop) abstractApplicationContext.getBean("samsung");
//        laptop.turnOn();
//        laptop.soundUp();
//        laptop.soundDown();
//        laptop.turnOff();
        System.out.println(laptop.getPrice());
        laptop.setPrice(3000);
    }
}
