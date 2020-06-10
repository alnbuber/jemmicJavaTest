package com.jemmic.interview.round2;

import com.jemmic.interview.round2.entities.AddressBookEntry;
import com.jemmic.interview.round2.entities.AddressBookEntryFamily;
import com.jemmic.interview.round2.entities.AddressBookEntryFriends;
import com.jemmic.interview.round2.entities.FamilyRelationship;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    // 1. Define List containing the address-book entries
    private List<AddressBookEntry> addressBook = new ArrayList<>();

    // 2.1 add entry family - method
    public void addEntryFamily(String name, String surname, String telephoneNumber, String email, int age, String hair , FamilyRelationship relationship) {

        // 2.1.1 add mandatory information
        AddressBookEntryFamily familyEntry = new AddressBookEntryFamily(name, surname, telephoneNumber, email );

        // 2.1.2 add optional information
        if( age != -1 ) {
            familyEntry.setAge(age);
        }

        if( ! hair.equals("")  ){
            familyEntry.setHairColor(hair);
        }

        // 2.1.3 add category information
        if ( ! relationship.equals("")){
            familyEntry.setRelationship(relationship.toString());
        }
    }

    // 2.2 add entry friends - method
    public void addEntryFriends(String name, String surname, String telephoneNumber, String email, int age, String hair, int yearBefriended ) {

        // 2.2.1 add necessary information
        AddressBookEntryFriends familyEntry = new AddressBookEntryFriends(name, surname, telephoneNumber, email );

        // 2.2.2 add optional information
        if( age != -1 ) {
            familyEntry.setAge(age);
        }

        if( ! hair.equals("")  ){
            familyEntry.setHairColor(hair);
        }

        // 2.2.3 add category information
        if ( yearBefriended != -1){
            familyEntry.setYearBefriended(yearBefriended);
        }
    }

    // 2.3 add entry acquaintance - method
    public void addEntryAcquaintance(String name, String surname, String telephoneNumber, String email, int age, String hair) {

        // 2.2.1 add necessary information
        AddressBookEntryFriends familyEntry = new AddressBookEntryFriends(name, surname, telephoneNumber, email );

        // 2.2.2 add optional information
        if( age != -1 ) {
            familyEntry.setAge(age);
        }

        if( ! hair.equals("")  ){
            familyEntry.setHairColor(hair);
        }
    }

    // 3.1 Display entries alphabetically by surname
    public void displayEntries(){

    }

    // 3.2 Sort entries alphabetically by surname
    public void sortEntries(){

    }

    // 4.1 remove items
    public void removeEntry(){

    }

    // 5.1 edit item
    public void removeItem() {
        
    }


}
