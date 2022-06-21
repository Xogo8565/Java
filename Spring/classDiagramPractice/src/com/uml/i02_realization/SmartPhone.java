package com.uml.i02_realization;

public class SmartPhone implements USBType {
    @Override
    public void bootUp() {
        System.out.println("스마트폰");
    }
}
