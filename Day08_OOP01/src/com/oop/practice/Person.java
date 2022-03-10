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

    public void printAll(){
        System.out.println("ID: "+ id + "\nName: " + name + "\nContact: " + contact);
    }
}
