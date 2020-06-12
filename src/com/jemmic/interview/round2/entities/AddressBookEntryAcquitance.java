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
                        "type: acquaintance"
                ;

        String confirmationMessageAge =
                "\n--------------------------\n" +
                "name : "+ this.getName() + "\n" +
                        "surname : "+ this.getSurname() + "\n" +
                        "telephone : "+ this.getTelephoneNumber() + "\n" +
                        "e-mail : "+ this.getEmail() + "\n" +
                        "age : "+ this.getAge() + "\n" +
                        "hair : "+ "not-specified" + "\n" +
                        "type: acquaintance";

        String confirmationMessageHair =
                "\n--------------------------\n" +
                "name : "+ this.getName() + "\n" +
                        "surname : "+ this.getSurname() + "\n" +
                        "telephone : "+ this.getTelephoneNumber() + "\n" +
                        "e-mail : "+ this.getEmail() + "\n" +
                        "age : "+ "not-specified" + "\n" +
                        "hair : "+ this.getHairColor() + "\n" +
                        "type: acquaintance"
        ;

        String confirmationMessage =
                "\n--------------------------\n" +
                        "name : "+ this.getName() + "\n" +
                        "surname : "+ this.getSurname() + "\n" +
                        "telephone : "+ this.getTelephoneNumber() + "\n" +
                        "e-mail : "+ this.getEmail() + "\n" +
                        "age : "+ "not-specified" + "\n" +
                        "hair : "+ "not-specified" + "\n" +
                        "type: acquaintance"

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
