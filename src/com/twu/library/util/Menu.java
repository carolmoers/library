package com.twu.library.util;

public class Menu {

    public String mainMenu() {
        String menuOptions = menuOptions();
        return menuOptions;
    }

    public String menuOptions() {
        StringBuilder options = new StringBuilder("Menu Options:\n");
        options.append("1 - List Books\n");
        options.append("2 - Checkout Books\n");
        options.append("3 - Return Books\n");
        options.append("4 - Quit");

        return options.toString();
    }
}
