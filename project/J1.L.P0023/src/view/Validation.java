package view;

import java.util.Scanner;
import model.Constants;

/**
 * The Validation class provides methods to validate user input.
 */
public class Validation {

    private final Scanner scanner;

    /**
     * Initializes the Validation object with a Scanner.
     */
    public Validation() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Validates and requests an integer input within a specified range.
     *
     * @param min The minimum allowed value
     * @param max The maximum allowed value
     * @return A valid integer within the range
     */
    public int checkInputIntLimit(int min, int max) {
        // Loop until valid input is received
        while (true) {
            try {
                int result;

                result = Integer.parseInt(scanner.nextLine().trim());

                // Check if result is within bounds
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }

                return result;
            } catch (NumberFormatException e) {
                System.err.printf(Constants.ERROR_RANGE_FORMAT, min, max);
            }
        }
    }

    /**
     * Validates and requests a non-empty string input.
     *
     * @return A valid non-empty string
     */
    public String checkInputString() {
        // Loop until valid non-empty string is received
        while (true) {
            String result;

            result = scanner.nextLine().trim();

            // Check if string is empty
            if (result.isEmpty()) {
                System.err.print(Constants.ERROR_EMPTY_INPUT);
            } else {
                return result;
            }
        }
    }

    /**
     * Validates and requests a positive double input.
     *
     * @return A valid positive double
     */
    public double checkInputDouble() {
        // Loop until valid positive double is received
        while (true) {
            try {
                double result;

                result = Double.parseDouble(scanner.nextLine().trim());

                // Check if number is positive
                if (result < 0) {
                    throw new NumberFormatException();
                }

                return result;
            } catch (NumberFormatException e) {
                System.err.print(Constants.ERROR_POSITIVE_NUMBER);
            }
        }
    }

    /**
     * Validates and requests an integer input.
     *
     * @return A valid integer
     */
    public int checkInputInt() {
        // Loop until valid integer is received
        while (true) {
            try {
                int result;

                result = Integer.parseInt(scanner.nextLine().trim());

                // Check if number is positive
                if (result < 0) {
                    throw new NumberFormatException();
                }

                return result;
            } catch (NumberFormatException e) {
                System.err.print("Must be a positive integer. Enter again: ");
            }
        }
    }

    /**
     * Validates and requests a Y/N input.
     *
     * @return True if 'Y' or 'y', false if 'N' or 'n'
     */
    public boolean checkInputYN() {
        // Loop until Y or N is received
        while (true) {
            String result;

            result = checkInputString();

            // Check for Y
            if (result.equalsIgnoreCase(Constants.YES)) {
                return true;
            }

            // Check for N
            if (result.equalsIgnoreCase(Constants.NO)) {
                return false;
            }

            System.err.print(Constants.ERROR_YN_INPUT);
        }
    }
}