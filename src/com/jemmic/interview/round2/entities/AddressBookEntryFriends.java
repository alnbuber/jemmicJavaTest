package com.jemmic.interview.round2.entities;

public class AddressBookEntryFriends extends AddressBookEntry{

    // constructor with mandatory fields
    public AddressBookEntryFriends(String name, String surname, String telephoneNumber, String email) {
        super(name, surname, telephoneNumber, email);
    }

    // class specific fields and methods
    private int yearBefriended;

    public int getYearBefriended() {
        return yearBefriended;
    }

    public void setYearBefriended(int yearBefriended) {
        this.yearBefriended = yearBefriended;
    }
}
