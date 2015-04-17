package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        showWelcomeMessage();
        mainMenu();
    }

    private static void mainMenu() {
        Boolean keepRunning = true;
        while(keepRunning) {
            showMenuOptions();

            Scanner input = new Scanner(System.in);
            System.out.print("What you would like to do (1-2)? ");
            int optionChoose = input.nextInt();

            switch (optionChoose){
                case 1:
                    showBooksLibrary();
                    break;
                case 2:
                    keepRunning = false;
                    System.out.close();
                    break;
                default:
                    System.out.println("Select a valid option!");
                    break;
            }
        }
    }

    private static void showWelcomeMessage() {
        System.out.println("Welcome to the Library!\n");
    }

    private static void showMenuOptions(){
        String options = "MenuOptions\n" +
                         "1 - List Books\n" +
                         "2 - Quit";

        System.out.println(options);
    }

    private static void showBooksLibrary(){
        Books predefinedList = new Books();

        for(Book book : predefinedList.getBooks()){
            System.out.println(book.getTitle());
            System.out.print("\tAuthor: " + book.getAuthor());
            System.out.println(" - Year Published: " + book.getYearPublished());
        }
    }
}
