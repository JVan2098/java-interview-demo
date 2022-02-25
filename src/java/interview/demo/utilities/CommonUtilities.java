/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java.interview.demo.utilities;

/**
 *
 * @author Jason Van Dyke
 */
public class CommonUtilities {
    // Taken from StackOverflow, so I decided not to use someone else's code.
    // This code apparently runs 20-30x faster than using Integer.parseInt(), 
    // but I wanted to use my own code for an interview.
    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
    
    public static int[] parseOrderedPair(String input) {
        int[] tempCoords = new int[2];
        String[] splitInput = input.split(",");
        splitInput[0] = splitInput[0].trim();
        splitInput[1] = splitInput[1].trim();
        tempCoords[0] = Integer.parseInt(splitInput[0]);
        tempCoords[1] = Integer.parseInt(splitInput[1]);
        return tempCoords;
    }
}
