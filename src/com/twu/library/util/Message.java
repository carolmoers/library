package com.twu.library.util;

public class Message {
    public String showWelcomeMessage() {
        String welcomeMessage = "Welcome to the Library!\n";
        return welcomeMessage;
    }

    public String showInputDataMessage() {
        String inputDataMessage = "\nWhat you would like to do (1-4)? ";
        return inputDataMessage;
    }

    public String showInputDataMessageCheckoutBook() {
        String inputDataMessage = "What book would you like to checkout (choose a number)? ";
        return inputDataMessage;
    }

    public String showInputDataMessageReturnBook() {
        String inputDataMessage = "What book would you like to return (choose a number)? ";
        return inputDataMessage;
    }
}
