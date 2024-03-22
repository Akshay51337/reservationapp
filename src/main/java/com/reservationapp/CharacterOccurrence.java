package com.reservationapp;

import java.util.HashMap;
import java.util.Map;

public class CharacterOccurrence {

    public static void main(String[] args) {
        String inputString = "programming";

        Map<Character, Integer> charOccurrences = countCharacterOccurrences(inputString);

        System.out.println("Character occurrences in the string:");
        for (Map.Entry<Character, Integer> entry : charOccurrences.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static Map<Character, Integer> countCharacterOccurrences(String input) {
        Map<Character, Integer> charOccurrences = new HashMap<>();

        // Iterate through each character in the string
        for (char ch : input.toCharArray()) {
            // Increment the count for each character in the map
            charOccurrences.put(ch, charOccurrences.getOrDefault(ch,0) + 1);
        }

        return charOccurrences;
    }
}

