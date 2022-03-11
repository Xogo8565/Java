package com.oop.practice;

public class Person {
    private int id;
    private String name;
    private String contact;

    public Person(){
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getContact() {
        return contact;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String printAll(){
        return "ID: "+ id + "\nName: " + name + "\nContact: " + contact;
    }
}
