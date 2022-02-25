/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java.interview.demo.utilities;

import java.util.Scanner;

/**
 *
 * @author Jason Van Dyke
 */
public class IOUtility {
    public static String getValidUserInput() {
        String temporaryUserInput = "";
        boolean validInput = false;
        do {
            temporaryUserInput = getKeyboardInput();
            validInput = validateInput(temporaryUserInput);

            if (!validInput) {
                System.out.println("That's not the correct type of input!");
            }
        } while (!validInput);
        return temporaryUserInput;
    }

    public static String getKeyboardInput() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter an ordered coordinate pair, with both numbers between 0 and 10, inclusive.");
        String userInput = kb.nextLine();
        return userInput;
    }

    public static boolean validateInput(String input) {
        if (!isCorrectInputFormat(input)) {
            return false;
        }
        String[] numberStrings = input.split(",");
        numberStrings[0] = numberStrings[0].trim();
        numberStrings[1] = numberStrings[1].trim();
        if (!isCorrectInputType(numberStrings)) {
            return false;
        }
        if (!isCorrectInputRange(numberStrings)) {
            return false;
        }
        return true;
    }

    public static boolean isCorrectInputFormat(String input) {
        if (input.indexOf(',') == -1) {
            return false;
        }
        if (input.indexOf(',') != input.lastIndexOf(',')) {
            return false;
        }
        return true;
    }

    public static boolean isCorrectInputType(String[] numberStrings) {
        try {
            for (String numberString : numberStrings) {
                if (Integer.parseInt(numberString) < 0) {
                    return false;
                }
                //if (isInteger(numberString)) return false; // See isInteger() method below
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isCorrectInputRange(String[] numberStrings) {
        try {
            for (String numberString : numberStrings) {
                if (Integer.parseInt(numberString) < 0) {
                    return false;
                }
                if (Integer.parseInt(numberString) > 10) {
                    return false;
                }
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    
    public static void informCustomer(String shopName) {
        System.out.println("The closest coffee shop to you is " + shopName);
    }
}
