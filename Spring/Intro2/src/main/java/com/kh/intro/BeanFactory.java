package com.kh.intro;

//인스턴스 공장 클래스
public class BeanFactory {
    public Laptop getBean(String str){
        if(str.equals("lg")){
            return new LgLaptop();
        } else if (str.equals("samsung")){
            return new SamsungLaptop();
        }
        return null;
    }
}
