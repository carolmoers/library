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
        expectedResult.append("|         4 - List Movies         |\n");
        expectedResult.append("|         5 - Checkout Movies     |\n");
        expectedResult.append("|         6 - Return Movies       |\n");
        expectedResult.append("|         7 - User Information    |\n");
        expectedResult.append("|         8 - Quit                |\n");
        expectedResult.append("+---------------------------------+");

        assertThat(result, is(equalTo(expectedResult.toString())));
    }
}
