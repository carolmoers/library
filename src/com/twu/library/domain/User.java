package com.twu.library.domain;

import com.twu.library.util.Message;

public class User {
    private String libraryNumber;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;


    public User(String libraryNumber, String password, String name, String email, String phoneNumber) {
        validateLibraryNumber(libraryNumber);
        validatePhoneNumber(phoneNumber);
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private void validateLibraryNumber(String libraryNumber){
        String libraryNumberPattern = "\\d{3}-\\d{4}";

        if(!libraryNumber.matches(libraryNumberPattern)){
            throw new IllegalArgumentException(Message.INVALID_LIBRARY_NUMBER);
        }
    }

    private void validatePhoneNumber(String phoneNumber){
        String phoneNumberPattern = "\\d{4}-\\d{4}";

        if(!phoneNumber.matches(phoneNumberPattern)){
            throw new IllegalArgumentException(Message.INVALID_PHONE_NUMBER);
        }
    }
}
