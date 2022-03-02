package com.example;

// 하나의 계좌 정보를 담고 있는 클래스

public class Account20 {
    private String ano;
    private String owner;
    private int balnace;


    public Account20(String ano, String owner, int balance) {
        this.ano = ano;
        this.owner = owner;
        this.balnace = balance;
    }

    String getAno() {
        return ano;
    }

    void setAno(String ano) {
        this.ano = ano;
    }

    String getOwner() {
        return owner;
    }

    void setOwner(String owner) {
        this.owner = owner;
    }

    int getBalnace() {
        return balnace;
    }

    void setBalnace(int balnace) {
        this.balnace = balnace;
    }



}
