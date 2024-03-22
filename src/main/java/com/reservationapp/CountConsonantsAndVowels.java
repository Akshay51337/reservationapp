package com.reservationapp;

public class CountConsonantsAndVowels {
    public static void main(String[] args) {
        String input = "Hello, World!";
        countConsonantsAndVowels(input);
    }

    static void countConsonantsAndVowels(String input) {
        int vowels = 0, consonants = 0;

        // Convert the input string to lowercase for case-insensitive counting
        input = input.toLowerCase();

        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                // Check if the character is a vowel
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Number of vowels: " + vowels);
        System.out.println("Number of consonants: " + consonants);
    }
}

