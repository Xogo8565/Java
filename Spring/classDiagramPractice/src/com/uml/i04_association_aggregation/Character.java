package com.uml.i04_association_aggregation;

public class Character {

    // 연관 관계
    /*
    * Aggregation - > 멤버 필드로 다른 클래스의 인스턴스를 참조하는 관계
    * 해당 클래스의 인스턴스가 생명을 다해도 참조하고 있는 클래스의 인스턴스 생명주기가 영향을 받지 않는 관계
    * 즉 생명 주기가 일치하지 않는 관계
    * 실선 + 비어있는 마름모로 표현
    * */
    private Watch watch;
    private Glass glass;

    public Character() {
    }

    public Character(Watch watch, Glass glass) {
        this.watch = watch;
        this.glass = glass;
    }

    public Watch getWatch() {
        return watch;
    }

    public void setWatch(Watch watch) {
        this.watch = watch;
    }

    public Glass getGlass() {
        return glass;
    }

    public void setGlass(Glass glass) {
        this.glass = glass;
    }
}
