package com.uml.i05_association_composition;

public class Character {
    /*
    * composition
    * 멤버 필드로써 다른 클래스의 인스턴스를 참조하는 관계
    * 다만 참조하는 클래스의 인스턴스와 참조되는 클래스의 인스턴스의 생명주기가 동일
    * 실선 + 속이 차있는 마름모로 표현
    * */
    private Glass glass = new Glass();
    private Watch watch = new Watch();

    public Character(Glass glass, Watch watch) {
        this.glass = glass;
        this.watch = watch;
    }
}
