package com.gowri.quartz.string;

import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author NaveenWodeyar
 * @date 18-Oct-2024
 * @time 12:21:32 am
 */
@Component
public class StringUtils {

    // Check if a string is null or empty
    public boolean isNullOrEmpty(String str) {
        return Optional.ofNullable(str).map(String::isEmpty).orElse(true);
    }

    // Reverse a string
    public String reverse(String str) {
        return Optional.ofNullable(str)
                       .filter(s -> !s.isEmpty())
                       .map(s -> new StringBuilder(s).reverse().toString())
                       .orElse(str); // Return original if null or empty
    }

    // Convert a string to uppercase
    public String toUpperCase(String str) {
        return Optional.ofNullable(str).map(String::toUpperCase).orElse(str);
    }

    // Convert a string to lowercase
    public String toLowerCase(String str) {
        return Optional.ofNullable(str).map(String::toLowerCase).orElse(str);
    }

    // Trim whitespace from a string
    public String trim(String str) {
        return Optional.ofNullable(str).map(String::trim).orElse(str);
    }

    // Check if a string contains a substring (case-sensitive)
    public boolean contains(String str, String substring) {
        return Optional.ofNullable(str)
                       .filter(s -> substring != null)
                       .map(s -> s.contains(substring))
                       .orElse(false);
    }

    // Join an array of strings into a single string
    public String join(String[] strings, String delimiter) {
        return Optional.ofNullable(strings)
                       .map(s -> String.join(Optional.ofNullable(delimiter).orElse(""), s))
                       .orElse(null);
    }
}

