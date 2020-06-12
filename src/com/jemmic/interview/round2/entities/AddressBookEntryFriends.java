package com.jemmic.interview.round2.entities;

import java.time.LocalDate;

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

    @Override
    public String toString() {
        boolean ageSet = (this.getAge() != -1);
        boolean hairSet =  ( this.getHairColor()!=null || ! this.getHairColor().equals(""));

        int yearsBefriended = LocalDate.now().getYear()-this.getYearBefriended();

        // confirm construction of new item
        String confirmationMessageAgeAndHair =
                "\n--------------------------\n" +
                        "name : "+ this.getName() + "\n" +
                        "surname : "+ this.getSurname() + "\n" +
                        "telephone : "+ this.getTelephoneNumber() + "\n" +
                        "e-mail : "+ this.getEmail() + "\n" +
                        "age : "+ this.getAge() + "\n" +
                        "hair : "+ this.getHairColor() + "\n" +
                        "type: friend"
                ;

        String confirmationMessageAge =
                "\n--------------------------\n" +
                        "name : "+ this.getName() + "\n" +
                        "surname : "+ this.getSurname() + "\n" +
                        "telephone : "+ this.getTelephoneNumber() + "\n" +
                        "e-mail : "+ this.getEmail() + "\n" +
                        "age : "+ this.getAge() + "\n" +
                        "hair : "+ "not-specified" + "\n" +
                        "type: friend" + "\n" +
                        "years befriended: " + yearsBefriended
                        ;

        String confirmationMessageHair =
                "\n--------------------------\n" +
                        "name : "+ this.getName() + "\n" +
                        "surname : "+ this.getSurname() + "\n" +
                        "telephone : "+ this.getTelephoneNumber() + "\n" +
                        "e-mail : "+ this.getEmail() + "\n" +
                        "age : "+ "not-specified" + "\n" +
                        "hair : "+ this.getHairColor() + "\n" +
                        "type: friend"+ "\n" +
                        "years befriended: " + yearsBefriended
                ;

        String confirmationMessage =
                "\n--------------------------\n" +
                        "name : "+ this.getName() + "\n" +
                        "surname : "+ this.getSurname() + "\n" +
                        "telephone : "+ this.getTelephoneNumber() + "\n" +
                        "e-mail : "+ this.getEmail() + "\n" +
                        "age : "+ "not-specified" + "\n" +
                        "hair : "+ "not-specified" + "\n" +
                        "type: friend"+ "\n" +
                        "years befriended: " + yearsBefriended
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
