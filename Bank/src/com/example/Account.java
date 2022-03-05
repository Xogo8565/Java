package com.example;

// 하나의 계좌 정보를 담고 있는 클래스

public class Account {
    private String ano;
    private String owner;
    private int balance;


    public Account(String ano, String owner, int balance) {
        this.ano = ano;
        this.owner = owner;
        this.balance = balance;
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

    int getBalance() {
        return balance;
    }

    void setBalance(int balance) {
        this.balance = balance;
    }



}
