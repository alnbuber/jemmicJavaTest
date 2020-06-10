package com.jemmic.interview.round2.entities;

public class AddressBookEntryFamily extends AddressBookEntry{

    // constructor with mandatory fields
    public AddressBookEntryFamily(String name, String surname, String telephoneNumber, String email) {
        super(name, surname, telephoneNumber, email);
    }

    // class specific fields and methods
    private String type = "family";
    private String relationship;

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getType() {
        return type;
    }
}
