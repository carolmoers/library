package com.twu.library.domain;

import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class UserTest {

    @Test
    public void createUserTest(){
        String libraryNumber = "123-4567";
        String password = "123456";
        String name = "User Test";
        String email = "email@test.com";
        String phoneNumber = "3333-3333";

        User userTest = new User(libraryNumber, password, name, email, phoneNumber);

        assertThat(libraryNumber, is(equalTo(userTest.getLibraryNumber())));
        assertThat(password, is(equalTo(userTest.getPassword())));
        assertThat(name, is(equalTo(userTest.getName())));
        assertThat(email, is(equalTo(userTest.getEmail())));
        assertThat(phoneNumber, is(equalTo(userTest.getPhoneNumber())));
    }

    @Test(expected = IllegalArgumentException.class)
    public void createMovieWithInvalidLibraryNumber(){
        String libraryNumber = "234567";
        String password = "123456";
        String name = "User Test";
        String email = "email@test.com";
        String phoneNumber = "3333-3333";

        User userTest = new User(libraryNumber, password, name, email, phoneNumber);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createMovieWithInvalidPhoneNumber(){
        String libraryNumber = "123-4567";
        String password = "123456";
        String name = "User Test";
        String email = "email@test.com";
        String phoneNumber = "33-3333";

        User userTest = new User(libraryNumber, password, name, email, phoneNumber);
    }


    @Test(expected = IllegalArgumentException.class)
    public void createMovieWithInvalidEmail(){
        String libraryNumber = "123-4567";
        String password = "123456";
        String name = "User Test";
        String email = "email@testcom";
        String phoneNumber = "3333-3333";

        User userTest = new User(libraryNumber, password, name, email, phoneNumber);
    }
}
