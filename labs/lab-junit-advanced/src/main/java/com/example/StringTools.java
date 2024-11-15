package com.example;

import java.util.stream.Stream;

public class StringTools {

    // Reverses the given string
    public static String reverse(String input) {
        if (input == null) return null;
        return new StringBuilder(input).reverse().toString();
    }

    // Checks if the string is a palindrome
    public static boolean isPalindrome(String input) {
        if (input == null) return false;
        String reversed = reverse(input);
        return input.equalsIgnoreCase(reversed);
    }

    // Counts the number of vowels in a string
    public static long countVowels(String input) {
        if (input == null) return 0;
        return input.chars()
            .filter(c -> "AEIOUaeiou".indexOf(c) != -1)
            .count();
    }

    // Converts a CSV line to a title-cased string (each word capitalized)
    public static String toTitleCase(String input) {
        if (input == null) return null;
        return Stream.of(input.split(" "))
            .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase())
            .reduce((s1, s2) -> s1 + " " + s2)
            .orElse("");
    }
}
