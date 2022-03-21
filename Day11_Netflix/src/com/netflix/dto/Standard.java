package com.netflix.dto;

public class Standard extends MemberShip {
    public Standard(String id, String nickname,String signup_date, int point){
        super(id,nickname,signup_date,point);
    }

    public String getMemberShip() {
        return "Stand";
    }
}

