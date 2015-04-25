package com.twu.library.domain;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class LoginTest {
    @Test
    public void verifyLoginTest(){
        User userExpected = new User("111-1111","123456","Steven Universe", "esteven@universe.com", "3218-4675");

        Login login = new Login();
        User userLogged = login.verifyLogin(userExpected.getLibraryNumber(), userExpected.getPassword());

        assertThat(userLogged.getName(), is(equalTo(userExpected.getName())));
        assertThat(userLogged.getEmail(), is(equalTo(userExpected.getEmail())));
        assertThat(userLogged.getLibraryNumber(), is(equalTo(userExpected.getLibraryNumber())));
        assertThat(userLogged.getPassword(), is(equalTo(userExpected.getPassword())));
        assertThat(userLogged.getPhoneNumber(), is(equalTo(userExpected.getPhoneNumber())));
    }

    @Test
    public void verifyInvalidLoginTest() {
        String libraryNumber = "111-1111";
        String password = "hdiushd";
        Login login = new Login();

        assertThat(login.verifyLogin(libraryNumber, password), is(equalTo(null)));
    }
}
