package com.stdmanager.dto;

public class StudentDTO {
    int no;
    String name;
    int age;
    char gender;
    public StudentDTO(){

    }

    public StudentDTO(int no, String name, int age, char gender) {
        this.no = no;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "student{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
