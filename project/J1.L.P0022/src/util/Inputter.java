package util;

import java.util.Scanner;

/**
 * Handle user input with validation
 */
public class Inputter {
    private static final Scanner sc = new Scanner(System.in);

    /**
     * Get non-empty string
     */
    public static String getString(String prompt) {
        String input;
        // Loop until valid non-empty input is provided
        while (true) {
            System.out.print(prompt);
            input = sc.nextLine().trim();
            // Check if input is not empty
            if (Validator.isNotEmpty(input)) {
                return input; // Valid input, return it
            }
            // Input is empty, show error and retry
            System.out.println("Input cannot be empty. Please try again.");
        }
    }

    /**
     * Get integer with range validation
     */
    public static int getInteger(String prompt, int min, int max) {
        int value;
        // Loop until valid integer within range is provided
        while (true) {
            try {
                System.out.print(prompt);
                value = Integer.parseInt(sc.nextLine().trim());
                // Check if value is within specified range
                if (value >= min && value <= max) {
                    return value; // Valid value, return it
                }
                // Value out of range, show error
                System.out.println("Please enter a number between " + min + " and " + max);
            } catch (NumberFormatException e) {
                // Catch non-numeric input
                System.out.println("Invalid number. Please try again.");
            }
        }
    }

    /**
     * Get validated email
     */
    public static String getEmail(String prompt) {
        String email;
        // Loop until valid email format is provided
        while (true) {
            System.out.print(prompt);
            email = sc.nextLine().trim();
            // Validate email format using regex
            if (Validator.isValidEmail(email)) {
                return email; // Valid email, return it
            }
            // Invalid format, show error and example
            System.out.println("Invalid email format. Example: user@domain.com");
        }
    }

    /**
     * Get validated phone
     */
    public static String getPhone(String prompt) {
        String phone;
        // Loop until valid phone number is provided
        while (true) {
            System.out.print(prompt);
            phone = sc.nextLine().trim();
            // Validate phone has minimum 10 digits
            if (Validator.isValidPhone(phone)) {
                return phone; // Valid phone, return it
            }
            // Invalid phone, show error
            System.out.println("Phone must be at least 10 digits.");
        }
    }

    /**
     * Get validated birth date
     */
    public static int getBirthDate(String prompt) {
        int year;
        // Loop until valid birth year is provided
        while (true) {
            try {
                System.out.print(prompt);
                year = Integer.parseInt(sc.nextLine().trim());
                // Check if year is between 1900 and current year
                if (Validator.isValidBirthDate(year)) {
                    return year; // Valid birth year, return it
                }
                // Year out of valid range, show error
                System.out.println("Birth year must be between 1900 and " + Validator.getCurrentYear());
            } catch (NumberFormatException e) {
                // Catch non-numeric input
                System.out.println("Invalid year. Please enter a 4-digit year.");
            }
        }
    }

    /**
     * Get graduation rank with menu
     */
    public static String getGraduationRank(String prompt) {
        System.out.println(prompt);
        // Loop through all graduation ranks to display menu
        for (int i = 0; i < Validator.GRADUATION_RANKS.length; i++) {
            System.out.println((i + 1) + ". " + Validator.GRADUATION_RANKS[i]);
        }
        // Get user choice (1-4)
        int choice = getInteger("Choose rank (1-4): ", 1, 4);
        // Return selected rank (subtract 1 for zero-based array index)
        return Validator.GRADUATION_RANKS[choice - 1];
    }

    /**
     * Confirm action (Y/N)
     */
    public static boolean confirm(String prompt) {
        String response;
        // Loop until valid Y or N response is provided
        while (true) {
            System.out.print(prompt + " (Y/N): ");
            response = sc.nextLine().trim().toUpperCase();
            // Check if user confirmed (Y)
            if (response.equals("Y")) {
                return true; // User confirmed
            } else if (response.equals("N")) {
                // User declined
                return false;
            }
            // Invalid response, show error and retry
            System.out.println("Please enter Y or N.");
        }
    }
}
