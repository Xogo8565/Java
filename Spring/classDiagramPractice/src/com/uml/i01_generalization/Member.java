package com.uml.i01_generalization;

public class Member {

    /*
    * 일반화 관계 - > 상속을 통해 클래스 간의 참조가 이뤄지는 관계
    * 화살표(실선+비어있는 삼각형)으로 하위 클래스가 상위 클래스를 가르키는 형태
   * */
    private int id;
    private String name;
    private double point;

    public Member() {
    }

    public Member(int id, String name, double point) {
        this.id = id;
        this.name = name;
        this.point = point;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }
}
