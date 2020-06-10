package com.jemmic.interview.round2.entities;

public class AddressBookEntryAcquitance extends AddressBookEntry{

    private String type = "acquitance";

    // constructor with mandatory fields
    public AddressBookEntryAcquitance(String name, String surname, String telephoneNumber, String email) {
        super(name, surname, telephoneNumber, email);
    }

    public String getType() {
        return type;
    }

}
