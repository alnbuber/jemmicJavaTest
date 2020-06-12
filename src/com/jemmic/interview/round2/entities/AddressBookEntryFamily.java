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

    @Override
    public String toString() {
        boolean ageSet = (this.getAge() != -1);
        boolean hairSet =  ( this.getHairColor()!=null || ! this.getHairColor().equals(""));
        // confirm construction of new item
        String confirmationMessageAgeAndHair =
                "\n--------------------------\n" +
                        "name : "+ this.getName() + "\n" +
                        "surname : "+ this.getSurname() + "\n" +
                        "telephone : "+ this.getTelephoneNumber() + "\n" +
                        "e-mail : "+ this.getEmail() + "\n" +
                        "age : "+ this.getAge() + "\n" +
                        "hair : "+ this.getHairColor() + "\n" +
                        "type: family" + "\n" +
                        "relationship : "+ this.getRelationship()
                ;

        String confirmationMessageAge =
                "\n--------------------------\n" +
                        "name : "+ this.getName() + "\n" +
                        "surname : "+ this.getSurname() + "\n" +
                        "telephone : "+ this.getTelephoneNumber() + "\n" +
                        "e-mail : "+ this.getEmail() + "\n" +
                        "age : "+ this.getAge() + "\n" +
                        "hair : "+ "not-specified" + "\n" +
                        "type: family" + "\n" +
                        "relationship : "+ this.getRelationship();

        String confirmationMessageHair =
                "\n--------------------------\n" +
                        "name : "+ this.getName() + "\n" +
                        "surname : "+ this.getSurname() + "\n" +
                        "telephone : "+ this.getTelephoneNumber() + "\n" +
                        "e-mail : "+ this.getEmail() + "\n" +
                        "age : "+ "not-specified" + "\n" +
                        "hair : "+ this.getHairColor() + "\n" +
                        "type: family" + "\n" +
                        "relationship : "+ this.getRelationship()
                ;

        String confirmationMessage =
                "\n--------------------------\n" +
                        "name : "+ this.getName() + "\n" +
                        "surname : "+ this.getSurname() + "\n" +
                        "telephone : "+ this.getTelephoneNumber() + "\n" +
                        "e-mail : "+ this.getEmail() + "\n" +
                        "age : "+ "not-specified" + "\n" +
                        "hair : "+ "not-specified" + "\n" +
                        "type: family" + "\n" +
                        "relationship : "+ this.getRelationship()
                ;

        if( ageSet && hairSet ){
            return confirmationMessageAgeAndHair;
        } else if ( ageSet && !hairSet ) {
            return confirmationMessageAge;
        } else if ( !ageSet && hairSet ){
            return confirmationMessageHair;
        } else {
            return confirmationMessage;
        }

    }
}
