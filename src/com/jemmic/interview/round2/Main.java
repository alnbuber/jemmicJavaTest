package com.jemmic.interview.round2;

public class Main {

    public static void main(String[] args) {
        System.out.println("Address-Book-App description: ");


        // Please change your file-path for the creation of the .txt-file
        String txtFilePath = "/home/alan/Desktop";

        AddressBookManagement app = new AddressBookManagement(txtFilePath);
        app.runApp();

    }
}
