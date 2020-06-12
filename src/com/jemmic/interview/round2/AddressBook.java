package com.jemmic.interview.round2;

import com.jemmic.interview.round2.entities.AddressBookEntry;
import com.jemmic.interview.round2.entities.AddressBookEntryAcquitance;
import com.jemmic.interview.round2.entities.AddressBookEntryFamily;
import com.jemmic.interview.round2.entities.AddressBookEntryFriends;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AddressBook {

    // 1. Define List containing the address-book entries
    private List<AddressBookEntry> addressBook = new ArrayList<>();

    // 2.1 add entry family - method
    public void addEntryFamily(String name, String surname, String telephoneNumber, String email, int age, String hair , String relationship) {

        // 2.1.1 add mandatory information
        AddressBookEntryFamily familyEntry = new AddressBookEntryFamily(name, surname, telephoneNumber, email );

        // 2.1.2 add optional information
        boolean ageSet = age != -1;
        if( ageSet ) {
            familyEntry.setAge(age);
        }

        boolean hairSet =  (hair!= null || ! hair.equals(""));
        if( hairSet ){
            familyEntry.setHairColor(hair);
        }

        // 2.1.3 add category information
        if ( ! relationship.equals("")){
            familyEntry.setRelationship(relationship);
        }

        // add item to address book list
        this.addressBook.add(familyEntry);

        printCreationFamily(name, surname, telephoneNumber, email, age, hair, relationship);
    }

    public void printCreationFamily(String name, String surname, String telephoneNumber, String email, int age, String hair, String relationship){
        boolean ageSet = age != -1;
        boolean hairSet =  (hair!= null || ! hair.equals(""));
        // confirm construction of new item
        String confirmationMessageAgeAndHair =
                "\nThe friend contact:\n"+
                        "name : "+ name + "\n" +
                        "surname : "+ surname + "\n" +
                        "telephone : "+ telephoneNumber + "\n" +
                        "e-mail : "+ email + "\n" +
                        "age : "+ age + "\n" +
                        "hair : "+ hair + "\n" +
                        "relationship : "+ relationship + "\n"
                ;

        String confirmationMessageAge =
                "\nThe friend contact:\n"+
                        "name : "+ name + "\n" +
                        "surname : "+ surname + "\n" +
                        "telephone : "+ telephoneNumber + "\n" +
                        "e-mail : "+ email + "\n" +
                        "age : "+ age + "\n" +
                        "hair : "+ "not-specified" + "\n" +
                        "relationship : "+ relationship + "\n"
                ;

        String confirmationMessageHair =
                "\nThe friend contact:\n"+
                        "name : "+ name + "\n" +
                        "surname : "+ surname + "\n" +
                        "telephone : "+ telephoneNumber + "\n" +
                        "e-mail : "+ email + "\n" +
                        "age : "+ "not-specified" + "\n" +
                        "hair : "+ hair + "\n" +
                        "relationship : "+ relationship + "\n"
                ;

        String confirmationMessage =
                "\nThe friend contact:\n"+
                        "name : "+ name + "\n" +
                        "surname : "+ surname + "\n" +
                        "telephone : "+ telephoneNumber + "\n" +
                        "e-mail : "+ email + "\n" +
                        "age : "+ "not-specified" + "\n" +
                        "hair : "+ "not-specified" + "\n" +
                        "relationship : "+ relationship + "\n"
                ;

        if( ageSet && hairSet ){
            System.out.println(confirmationMessageAgeAndHair);
        } else if ( ageSet && !hairSet ) {
            System.out.println(confirmationMessageAge);
        } else if ( !ageSet && hairSet ){
            System.out.println(confirmationMessageHair);
        } else {
            System.out.println(confirmationMessage);
        }
    }

    // 2.2 add entry friends - method
    public void addEntryFriends(String name, String surname, String telephoneNumber, String email, int age, String hair, int yearBefriended ) {

        // 2.2.1 add necessary information
        AddressBookEntryFriends friendEntry = new AddressBookEntryFriends(name, surname, telephoneNumber, email );

        // 2.2.2 add optional information
        boolean ageSet = age != -1;
        if( ageSet ) {
            friendEntry.setAge(age);
        }

        boolean hairSet =  (hair!= null || ! hair.equals(""));
        if( hairSet ){
            friendEntry.setHairColor(hair);
        }

        // 2.2.3 add category information
        boolean yearBefriendedSet = (yearBefriended != -1);
        if ( yearBefriendedSet){
            friendEntry.setYearBefriended(yearBefriended);
        } else {
            friendEntry.setYearBefriended(LocalDate.now().getYear());
        }

        // add item to address book list
        this.addressBook.add(friendEntry);


        printCreationFriend(name, surname, telephoneNumber, email, age, hair, friendEntry.getYearBefriended());
    }

    public void printCreationFriend(String name, String surname, String telephoneNumber, String email, int age, String hair, int yearBefriended){
        boolean ageSet = age != -1;
        boolean hairSet =  (hair!= null || ! hair.equals(""));
        int yearsBefriended = LocalDate.now().getYear() - yearBefriended;

        // confirm construction of new item
        String confirmationMessageAgeAndHair =
                "\nThe friend contact:\n"+
                        "name : "+ name + "\n" +
                        "surname : "+ surname + "\n" +
                        "telephone : "+ telephoneNumber + "\n" +
                        "e-mail : "+ email + "\n" +
                        "age : "+ age + "\n" +
                        "hair : "+ hair + "\n" +
                        "friends for : "+ yearsBefriended + "years.\n"
                ;

        String confirmationMessageAge =
                "\nThe friend contact:\n"+
                        "name : "+ name + "\n" +
                        "surname : "+ surname + "\n" +
                        "telephone : "+ telephoneNumber + "\n" +
                        "e-mail : "+ email + "\n" +
                        "age : "+ age + "\n" +
                        "hair : "+ "not-specified" + "\n" +
                        "friends for : "+ yearBefriended + "years.\n"
                ;

        String confirmationMessageHair =
                "\nThe friend contact:\n"+
                        "name : "+ name + "\n" +
                        "surname : "+ surname + "\n" +
                        "telephone : "+ telephoneNumber + "\n" +
                        "e-mail : "+ email + "\n" +
                        "age : "+ "not-specified" + "\n" +
                        "hair : "+ hair + "\n" +
                        "friends for : "+ yearBefriended + "years.\n"
                ;

        String confirmationMessage =
                "\nThe friend contact:\n"+
                        "name : "+ name + "\n" +
                        "surname : "+ surname + "\n" +
                        "telephone : "+ telephoneNumber + "\n" +
                        "e-mail : "+ email + "\n" +
                        "age : "+ "not-specified" + "\n" +
                        "hair : "+ "not-specified" + "\n" +
                        "friends for : "+ yearBefriended + "years.\n"
                ;

        if( ageSet && hairSet ){
            System.out.println(confirmationMessageAgeAndHair);
        } else if ( ageSet && !hairSet ) {
            System.out.println(confirmationMessageAge);
        } else if ( !ageSet && hairSet ){
            System.out.println(confirmationMessageHair);
        } else {
            System.out.println(confirmationMessage);
        }
    }

    // 2.3 add entry acquaintance - method
    public void addEntryAcquaintance(String name, String surname, String telephoneNumber, String email, int age, String hair) {

        // 2.2.1 add necessary information
        AddressBookEntryAcquitance friendAcquitance = new AddressBookEntryAcquitance(name, surname, telephoneNumber, email );

        // 2.2.2 add optional information
        boolean ageSet = age != -1;
        if( ageSet ) {
            friendAcquitance.setAge(age);
        }

        boolean hairSet =  (hair!= null || ! hair.equals(""));
        if( hairSet ){
            friendAcquitance.setHairColor(hair);
        }

        // add item to address book list
        this.addressBook.add(friendAcquitance);

        // print creation
        printCreationAcquaitance(name,  surname, telephoneNumber, email, age, hair);

    }

    public void printCreationAcquaitance(String name, String surname, String telephoneNumber, String email, int age, String hair){
        boolean ageSet = age != -1;
        boolean hairSet =  (! hair.equals(""));
        // confirm construction of new item
        String confirmationMessageAgeAndHair =
                "\nThe acquitance contact:\n"+
                        "name : "+ name + "\n" +
                        "surname : "+ surname + "\n" +
                        "telephone : "+ telephoneNumber + "\n" +
                        "e-mail : "+ email + "\n" +
                        "age : "+ age + "\n" +
                        "hair : "+ hair + "\n"
                ;

        String confirmationMessageAge =
                "\nThe acquitance contact:\n"+
                        "name : "+ name + "\n" +
                        "surname : "+ surname + "\n" +
                        "telephone : "+ telephoneNumber + "\n" +
                        "e-mail : "+ email + "\n" +
                        "age : "+ age + "\n" +
                        "hair : "+ "not-specified" + "\n"
                ;

        String confirmationMessageHair =
                "\nThe acquitance contact:\n"+
                        "name : "+ name + "\n" +
                        "surname : "+ surname + "\n" +
                        "telephone : "+ telephoneNumber + "\n" +
                        "e-mail : "+ email + "\n" +
                        "age : "+ "not-specified" + "\n" +
                        "hair : "+ hair + "\n"
                ;

        String confirmationMessage =
                "\nThe acquitance contact:\n"+
                        "name : "+ name + "\n" +
                        "surname : "+ surname + "\n" +
                        "telephone : "+ telephoneNumber + "\n" +
                        "e-mail : "+ email + "\n" +
                        "age : "+ "not-specified" + "\n" +
                        "hair : "+ "not-specified" + "\n"
                ;

        if( ageSet && hairSet ){
            System.out.println(confirmationMessageAgeAndHair);
        } else if ( ageSet && !hairSet ) {
            System.out.println(confirmationMessageAge);
        } else if ( !ageSet && hairSet ){
            System.out.println(confirmationMessageHair);
        } else {
            System.out.println(confirmationMessage);
        }
    }

    // 3.1 Display entries alphabetically by surname
    public void displayEntries(){

        // sorting algorithm
        Collections.sort(addressBook, AddressBookEntry.entrySurnameComparator);

        // print the items
        System.out.println( "\n----------------------\n" +
                "The adress book contains the following entries:\n");

        AtomicInteger pos = new AtomicInteger(1);
        addressBook.stream().forEach(entry -> {
            System.out.println("\n======================\n Item-selector: "
                                + pos + entry.toString());
            pos.getAndIncrement();
        });


       // save list to txt-file
        saveEntriesToTxt("/home/alan/Desktop", addressBook);

    }

    // 3.2 Sort entries alphabetically by surname
    public void saveEntriesToTxt(String path, List<AddressBookEntry> entries){
        try {
            String finalPath = path.concat("/the-file-name-").concat(LocalDate.now().toString()).concat(".txt");
            List<String> lines = new ArrayList<>();
            entries.stream().forEach(item -> lines.add(item.toString()));

            Path file = Paths.get(finalPath);
            Files.write(file, lines, StandardCharsets.UTF_8);
        } catch (IOException ioException) {
            System.err.println(ioException);
        }
    }

    // 4.1 remove items
    public void removeEntry(int index){
        try {
            this.addressBook.remove(index);
        } catch (IndexOutOfBoundsException exception) {

        }

    }

    // 5.1 edit item
    public void editEntry() {
        
    }

    public int numberOfContacts() {
        return this.addressBook.size();
    }


}
