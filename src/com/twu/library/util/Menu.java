package com.twu.library.util;

import java.util.Scanner;

public class Menu {

    public String mainMenu() {
        String menuOptions = menuOptions();
        return menuOptions;
    }

    public String menuOptions(){
        String options = "Menu Options:\n" +
                         "1 - List Books\n" +
                         "2 - Quit";
        return options;
    }
}
