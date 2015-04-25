package com.twu.library.util;

public class MainMenu {

    public String createMainMenu() {

        StringBuilder menuOptions = new StringBuilder();
        menuOptions.append("+---------------------------------+\n");
        menuOptions.append("|           MENU OPTIONS          |\n");
        menuOptions.append("+---------------------------------+\n");
        menuOptions.append("|         1 - List Books          |\n");
        menuOptions.append("|         2 - Checkout Books      |\n");
        menuOptions.append("|         3 - Return Books        |\n");
        menuOptions.append("|         4 - List Movies         |\n");
        menuOptions.append("|         5 - Checkout Movies     |\n");
        menuOptions.append("|         6 - Return Movies       |\n");
        menuOptions.append("|         7 - User Information    |\n");
        menuOptions.append("|         8 - Quit                |\n");
        menuOptions.append("+---------------------------------+");

        return menuOptions.toString();
    }
}
