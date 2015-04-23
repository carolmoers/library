package com.twu.library.processor;

import java.util.Scanner;

public class MainProcessor {
    public Integer getInputData(String message){
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        return input.nextInt();
    }
}
