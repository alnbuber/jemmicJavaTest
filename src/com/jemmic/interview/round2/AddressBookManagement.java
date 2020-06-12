package com.jemmic.interview.round2;

import com.jemmic.interview.round2.entities.AddressBookEntry;
import com.jemmic.interview.round2.entities.FamilyRelationship;

import java.io.StringReader;
import java.util.Scanner;

public class AddressBookManagement {

    // 0. Define basic fields and methods
    public boolean processFinalized = false;
    public Scanner scanner = new Scanner(System.in);

    // 1. Define the address book
    AddressBook addressBook = new AddressBook();

    // 2. Define the methods
    public void runApp() {
        while(!processFinalized){
            String generalMessage = "\n--------------------------------\n" +
                    "Please select one of the following options by typing in the respective number:\n" +
                    "0. cancel\n" +
                    "1. Add new contact\n" +
                    "2. Display all contacts\n" +
                    "3. Remove one specific contact\n" +
                    "4. Edit one specific contact\n";


            int optionSelected = scanIntegerMethod(generalMessage);

            if(optionSelected != -1) {
                System.out.println("You selected option: " + optionSelected + ".");

                switch (optionSelected) {
                    case 0:
                        System.out.println("The process was canceled.");
                        break;
                    case 1:
                        this.addContact();
                        break;
                    case 2:
                        this.addressBook.displayEntries();
                        break;
                    case 3:
                        this.removeContact();
                        break;
                    case 4:
                        this.editContact();
                        break;
                }

            } else {
                System.out.println("The input is not correct.");
            }
        }
    }

    // function for scanning numbers
    public int scanIntegerMethod(String message) {
        String input;
        int inputNumber = 0;
        boolean scanCorrect = false;

        while(!scanCorrect){
            try {
                System.out.println(message);
                input = scanner.nextLine();
                inputNumber = Integer.parseInt(input);
                scanCorrect = true;

                if(inputNumber<0){
                    inputNumber = -1;
                }
            } catch (NumberFormatException exception){
                System.err.println("The entered number is not an integer.");
                scanCorrect = false;
            }
        }

        return inputNumber;
    }

    // function for scanning numbers
    public String scanStringsMethod(String instructionMessage, String outputMessage) {
        String inputString = "";
        boolean scanCorrect = false;

        while(!scanCorrect){
            System.out.println(instructionMessage);
            inputString = scanner.nextLine();

            if(! inputString.equals("")){
                scanCorrect = true;
            }
        }

        System.out.println(outputMessage + inputString +".");
        return inputString;
    }

    // function for scanning numbers
    public boolean scanAcceptDeclineMethod(String instructionMessage) {
        String inputString = "";
        boolean scanCorrect = false;
        boolean acceptOrDecline = false;

        while(!scanCorrect){
            System.out.println(instructionMessage);
            inputString = scanner.nextLine();

            if(( inputString.equals("y") || inputString.equals("n"))){

                if(inputString.equals("y")){
                    acceptOrDecline = true;
                }
                scanCorrect = true;
            }
        }

        return acceptOrDecline;
    }

    public void addContact(){
        System.out.println( "You selected option 1: Add contact to address-book\n" +
                            "Please type in the following mandatory input fields:");

        // mandatory fields
        String name = scanStringsMethod("Please type in the name:", "The typed in name is: ");
        String surname = scanStringsMethod("Please type in the surname:", "The typed in surname is: ");
        String telephoneNumber = scanStringsMethod("Please type in the telephone number:", "The typed in telephone number is: ");
        String mail = scanStringsMethod("Please type in the email-address:", "The typed in email-address is: ");

        // optional fields
        boolean typeInAge = scanAcceptDeclineMethod("Would you like to save the age?\n Type in 'y' for yes or 'n' for no");
        int age = -1;
        if(typeInAge){
            age = scanIntegerMethod("Please type in the age:");
        }

        boolean typeInHair = scanAcceptDeclineMethod("Would you like to save the hair-type?\n Type in 'y' for yes or 'n' for no");
        String hair = "";
        if(typeInHair){
            hair = scanStringsMethod("Please type in the hair-type:", "The hair-type is: ");
        }

        // select contact-type
        String contactTypeMessage =
                "The contact belongs to one of the following categories:\n" +
                "(select one of the options by typing in the respective number):\n" +
                "1. acquaintance\n" +
                "2. family\n" +
                "3. friends\n";

        int category = scanIntegerMethod(contactTypeMessage);

        if(category != -1) {
            System.out.println("You selected option: " + category + ".");

            switch (category) {

                // acquaintance
                case 1:
                    this.addressBook.addEntryAcquaintance(name, surname, telephoneNumber, mail, age, hair);
                    break;

                // family
                case 2:
                    System.out.println("family");

                    // Find out about the relationship-type
                    String familyRelationship = "";
                    String familyTypeMessage =
                            "The contact belongs to one of the following categories:\n" +
                                    "(select one of the options by typing in the respective number):\n" +
                                    "1. parent\n" +
                                    "2. grandparent\n" +
                                    "3. son or daughter\n"+
                                    "4. aunt or uncle\n";
                    int familyTypeNumber = scanIntegerMethod(familyTypeMessage);
                    switch (familyTypeNumber){
                        case 1:
                            familyRelationship = "parent";
                            break;
                        case 2:
                            familyRelationship = "grandparent";
                            break;
                        case 3:
                            familyRelationship = "son or daughter";
                            break;
                        case 4:
                            familyRelationship = "aunt or uncle";
                            break;
                    }

                    this.addressBook.addEntryFamily(name, surname, telephoneNumber, mail, age, hair, familyRelationship );
                    break;

                // friend
                case 3:
                    String friendshipStartYearMessage =
                            "Since which year are you friends ?\n";
                    int friendshipStartYear = scanIntegerMethod(friendshipStartYearMessage);
                    this.addressBook.addEntryFriends(name, surname, telephoneNumber, mail, age, hair, friendshipStartYear);
                    break;
            }
        } else {
            System.out.println("The input is not correct.");
        }


    }

    private void removeContact(){
        System.out.println("\nRemove contact:\n");
        addressBook.displayEntries();
        int numEntries = addressBook.numberOfContacts();

        String indexRemoveItemMessage = "Which contact do you want to delete? \n (Please select insert the Item-selector number )";
        int indexRemoveItem = scanIntegerMethod(indexRemoveItemMessage);

        try {
            if(numEntries>0 && indexRemoveItem-1<=numEntries){
                addressBook.removeEntry(indexRemoveItem);
            }
        } catch (IndexOutOfBoundsException exception) {

        }
    }

    private void editContact(){
        System.out.println("\nEdit contacs:\n");
        addressBook.displayEntries();
        int numEntries = addressBook.numberOfContacts();

        String indexRemoveItemMessage = "Which contact do you want to edit? \n (Please select insert the Item-selector number )";
        int indexEditItem = scanIntegerMethod(indexRemoveItemMessage);

        String indexEditFieldMessage = "Which contact do you want to edit? \n" +
                "(Please select insert the Item-selector number )\n"+
                "1. name\n" +
                "2. surname\n" +
                "3. telephone\n" +
                "4. e-mail\n" +
                "5. age\n" +
                "6. hair"
                ;

        int indexEditField = scanIntegerMethod(indexEditFieldMessage);

        String newFieldContentMessageInput = "Which should be the new content? \n (Please type in the new value.)";
        String newFieldContentMessageOutput = "The new value of the field is: ";
        String newFieldContent = scanStringsMethod(newFieldContentMessageInput, newFieldContentMessageOutput);

        try {
            if(numEntries>0 && indexEditItem-1<=numEntries){

                if(indexEditField>0 && indexEditField<7) {
                    this.addressBook.setAddressBook(
                            addressBook.editEntry(indexEditItem , indexEditField, newFieldContent)
                    );

                }

            }
        } catch (IndexOutOfBoundsException exception) {

        }
    }
}
