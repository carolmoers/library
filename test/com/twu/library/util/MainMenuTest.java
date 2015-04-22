package com.twu.library.util;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class MainMenuTest {

    @Test
    public void mainMenuTest(){
        MainMenu mainMenu = new MainMenu();
        String result = mainMenu.createMainMenu();

        StringBuilder expectedResult = new StringBuilder();
        expectedResult.append("+---------------------------------+\n");
        expectedResult.append("|           MENU OPTIONS          |\n");
        expectedResult.append("+---------------------------------+\n");
        expectedResult.append("|         1 - List Books          |\n");
        expectedResult.append("|         2 - Checkout Books      |\n");
        expectedResult.append("|         3 - Return Books        |\n");
        expectedResult.append("|         4 - Quit                |\n");
        expectedResult.append("+---------------------------------+");

        assertThat(result, is(equalTo(expectedResult.toString())));
    }
}