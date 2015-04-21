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

        assertThat("Menu Options:\n1 - List Books\n2 - Checkout Books\n3 - Return Books\n4 - Quit", is(equalTo(options)));
    }

    @Test
    public void mainMenuTest(){
        Menu menu = new Menu();
        String options = menu.menuOptions();
        Message message = new Message();
        options += message.showInputDataMessage();

        assertThat("Menu Options:\n1 - List Books\n2 - Checkout Books\n3 - Return Books\n4 - Quit" +
                "\nWhat you would like to do (1-4)? ", is(equalTo(options)));
    }
}
