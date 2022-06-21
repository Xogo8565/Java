package com.uml.i03_dependency;

public class Character {
    // 의존관계 : 하나의 클래스가 다른 클래스의 인스턴ㅌ스를
    // 메서드의 반환타입, 메서드의 인자값, 메서드 내부에서 참조하는 관계
    // 메서드 내부에서 참조되는 다른 클래스의 인스턴스는 메서드의 생명주기와 동일
    // 점선 + 열려있는 화살표로 표현
    public Fire makeFire() {
        return new Fire();
    }

    public void cooking (Fire fire) {

    }

    public void cooking2 () {
        Fire fire = new Fire();
    }
}
