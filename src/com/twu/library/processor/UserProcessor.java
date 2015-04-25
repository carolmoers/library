package com.twu.library.processor;

import com.twu.library.domain.User;

public class UserProcessor {
    public void showUserInformation(User user) {
        if(user != null) {
            String leftAlignFormat = "| %-14s | %-30s | %-25s | %-12s |%n";

            System.out.format("+----------------+--------------------------------+---------------------------+--------------+%n");
            System.out.printf("| Library Number | Name                           | Email                     | Phone Number |%n");
            System.out.format("+----------------+--------------------------------+---------------------------+--------------+%n");
            System.out.format(leftAlignFormat, user.getLibraryNumber(), user.getName(), user.getEmail(), user.getPhoneNumber());
            System.out.format("+----------------+--------------------------------+---------------------------+--------------+%n%n");
        }else{
            System.out.format("+----------------+--------------------------------+---------------------------+--------------+%n");
            System.out.printf("|                          There are no available information                                |%n");
            System.out.format("+----------------+--------------------------------+---------------------------+--------------+%n%n");
        }
    }
}
