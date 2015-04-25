package com.twu.library.processor;

import java.util.Scanner;

public class MainProcessor {
    public Integer getInputDataInteger(String message){
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        return input.nextInt();
    }

    public String getInputDataString(String message){
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        return input.next();
    }
}
