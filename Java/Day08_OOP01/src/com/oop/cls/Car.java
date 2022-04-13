package com.oop.cls;

public class Car {
    /*
    속성 : brand, speed, oil
    기능 : 시동 on/off speed up/down
     */
    /*
    정보은닉(캡슐화) : 사용자가 접근하면 안되는 데이터들을 내부적으로 숨기거나 접근을 제한하는 것
    -> 1. 접근제한자 사용
        접근제한자
        - public : 외부, 모든 곳에서 접근이 가능
        - protected : 같은 패키지 혹은 자식 클래스
        - default : 같은 패키지 안에서는 접근 가능
        - private : 해당 클래스 내부에서만 접근 가능

    -> 2. getter / setter
        private 접근제한자 사용 -> 외부에서 접근 불가
        ->  getter : read-only
        ->  setter : write-only
     */
    private String brand;
    private int speed;
    private int oil;

    /*
    생성자(Constructor)
    - return type 없음
    - 클래스명과 이름이 같음
    - 인스턴스가 만들어질 때 초기화 해주는 역할을 수행
    - 기본생성자(Default Constructor)는 명시하지 않아도 JVM 에서 생성해 줌.
     */
    //기본생성자
    public Car() {

    }
    // 매개변수가 있는 생성자를 정의하면 기본생성자가 JVM 에서 자동으로 생성되지 않음
    // -> 생성자 또한 메서드이기 때문에 오버로딩이 가능

    // 생성자 오버로딩
    public Car(String brand, int speed, int oil) {
        this.brand = brand;
        this.speed = speed;
        this.oil = oil;
    }

    public String getBrand() {
        return brand;
    }

    public int getSpeed() {
        return speed;
    }

    public int getOil() {
        return oil;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
        //(좌) : this. -> 자기자신의 heap 영역에 접근
        //(우) : 매개변수 speed
    }

    public void setOil(int oil) {
        this.oil = oil;
    }

    public void setBrand(String brand) {
        if(brand.equals("BMW")) this.brand = "Hyundai";
        else this.brand = brand;
    }

    public void powerOn(){
        System.out.println("시동을 걸었습니다.");
    }
    public void powerOff(){
        System.out.println("시동을 껐습니다.");
    }
    public void speedUp(){
        if(speed<200) speed++;
    }

    public void speedDown(){
        speed--;
    }
}
