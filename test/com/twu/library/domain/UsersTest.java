package com.twu.library.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class UsersTest {

    @Test
    public void createPredefinedUsersTest(){
        Users users = new Users();

        assertThat(users.createPredefinedUsers().size(), is(3));

        assertThat("111-1111", is(equalTo(users.getUsers().get(0).getLibraryNumber())));
        assertThat("Steven Universe", is(equalTo(users.getUsers().get(0).getName())));
        assertThat("esteven@universe.com", is(equalTo(users.getUsers().get(0).getEmail())));
        assertThat("3218-4675", is(equalTo(users.getUsers().get(0).getPhoneNumber())));
        assertThat("123456", is(equalTo(users.getUsers().get(0).getPassword())));

        assertThat("222-2222", is(equalTo(users.getUsers().get(1).getLibraryNumber())));
        assertThat("Princess Bubblegum", is(equalTo(users.getUsers().get(1).getName())));
        assertThat("bubblegum@adventure.com", is(equalTo(users.getUsers().get(1).getEmail())));
        assertThat("3284-6571", is(equalTo(users.getUsers().get(1).getPhoneNumber())));
        assertThat("123456", is(equalTo(users.getUsers().get(1).getPassword())));

        assertThat("333-3333", is(equalTo(users.getUsers().get(2).getLibraryNumber())));
        assertThat("Finn the Human", is(equalTo(users.getUsers().get(2).getName())));
        assertThat("finn3@adventure.com", is(equalTo(users.getUsers().get(2).getEmail())));
        assertThat("3761-4829", is(equalTo(users.getUsers().get(2).getPhoneNumber())));
        assertThat("123456", is(equalTo(users.getUsers().get(2).getPassword())));
    }
}
