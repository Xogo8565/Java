package com.oop.access02;

import com.oop.access01.Access01;

public class Run {
    public static void main(String[] args) {
        Access01 ac = new Access01();
//        ac.written_date = "2022-03-10";
//        ac.age = 10;
        ac.id = "abc123";
        System.out.println(ac.id);
    }
}
