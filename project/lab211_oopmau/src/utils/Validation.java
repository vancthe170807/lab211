package utils;

import java.util.Scanner;

/**
 * Utility class for input validation from the console.
 */
public class Validation {

    private final Scanner scanner;

    public Validation() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Reads a non-empty string.
     * 
     * @param prompt The prompt message to display to the user
     * @return Non-empty string entered by the user
     */
    public String inputString(String prompt) {
        while (true) {
            System.out.print(prompt + ": ");
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Input cannot be empty. Please try again.");
        }
    }

    /**
     * Reads an integer within [min, max] range.
     * 
     * @param prompt The prompt message to display to the user
     * @param min The minimum allowed value (inclusive)
     * @param max The maximum allowed value (inclusive)
     * @return Integer value entered by the user within the specified range
     */
    public int inputInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt + " [" + min + ", " + max + "]: ");
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Value must be between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter an integer.");
            }
        }
    }

    /**
     * Reads a double within [min, max] range.
     * 
     * @param prompt The prompt message to display to the user
     * @param min    The minimum allowed value (inclusive)
     * @param max    The maximum allowed value (inclusive)
     * @return Double value entered by the user within the specified range
     */
    public double inputDouble(String prompt, double min, double max) {
        while (true) {
            System.out.print(prompt + " [" + min + ", " + max + "]: ");
            String input = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Value must be between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter a double value.");
            }
        }
    }

    /**
     * Reads a Yes/No option (returns true for Y/y, false for N/n).
     * 
     * @param prompt The prompt message to display to the user
     * @return true for Y/y, false for N/n
     */
    public boolean inputYesNo(String prompt) {
        while (true) {
            System.out.print(prompt + " (Y/N): ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("Y")) {
                return true;
            }
            if (input.equals("N")) {
                return false;
            }
            System.out.println("Invalid option. Please enter Y or N.");
        }
    }
}
