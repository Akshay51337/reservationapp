package com.reservationapp;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String str = "hello";
        char firstNonRepeatingChar = findFirstNonRepeatingChar(str);
        if (firstNonRepeatingChar != '\0') {
            System.out.println("First non-repeating character: " + firstNonRepeatingChar);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }

    public static char findFirstNonRepeatingChar(String str) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        // Count occurrences of each character in the string
        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c,0) + 1);
        }

        // Find the first non-repeating character
        for (char c : str.toCharArray()) {
            if (charCountMap.get(c) == 1) {
                return c; // Found the first non-repeating character
            }
        }

        // If no non-repeating character is found, return '\0'
        return '\0';
    }
}

