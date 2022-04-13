package com.oop.cls;

public class Run_Car {
    public static void main(String[] args) {
        Car avante = new Car();
//        avante.setBrand("BMW");
//        System.out.println(avante.getBrand());
//        avante.setSpeed(0);
//        System.out.println(avante.getSpeed());
//        avante.setOil(10);
//        System.out.println(avante.getOil());
//
//        avante.powerOn();
//        avante.speedUp();
//        System.out.println("Up 후 speed : " + avante.getSpeed());
//
//        for(int i=0; i<300; i++){
//            avante.speedUp();
//        }
//        System.out.println("Up 후 speed : " + avante.getSpeed());
//        avante.speedDown();
//        System.out.println("Down 후 speed : " + avante.getSpeed());
//        avante.powerOff();
        avante.setBrand("Hyundai");
        avante.setSpeed(50);
        avante.setOil(100);
        System.out.println(avante.getBrand()+":"+avante.getSpeed()+":"+avante.getOil());

        Car morning = new Car("Kia",100,50);
        System.out.println(morning.getBrand()+":"+morning.getSpeed()+":"+morning.getOil());

    }
}
