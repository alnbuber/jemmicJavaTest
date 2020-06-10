package com.jemmic.interview.round2.entities;

public abstract class AddressBookEntry {

    // mandatory fields
    private String name;
    private String surname;
    private String telephoneNumber;
    private String email;

    // optional fields
    private int age;
    private String hair;

    // constructor
    public AddressBookEntry(String name, String surname, String telephoneNumber, String email) {
        this.name = name;
        this.surname = surname;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }

    // getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHairColor() {
        return hair;
    }

    public void setHairColor(String hairColor) {
        this.hair = hairColor;
    }
}
