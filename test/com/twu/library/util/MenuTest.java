package com.twu.library.util;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class MenuTest {
    @Test
    public void menuOptionsTest(){
        Menu menu = new Menu();
        String options = menu.menuOptions();

        assertThat("Menu Options:\n1 - List Books\n2 - Quit", is(equalTo(options)));
    }

    @Test
    public void mainMenuTest(){
        Menu menu = new Menu();
        String options = menu.menuOptions();
        options += "\nWhat you would like to do (1-2)? ";

        assertThat("Menu Options:\n1 - List Books\n2 - Quit\n" +
                "What you would like to do (1-2)? ", is(equalTo(options)));
    }

    @Test
    public void verifyMenuTest(){
        Menu menu = new Menu();

    }
}
