package com.atm;

import java.util.Scanner;

public class InputHandler {
    private static Scanner scanner = new Scanner(System.in);

    public static String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
