package calculator;

import java.util.Scanner;

public class Validate {
    
    private static final Scanner in = new Scanner(System.in);
    
    /**
     * Prompts the user to input an integer within a specified range.
     * Continues to prompt until a valid integer is entered.
     *
     * @param min the minimum acceptable integer value
     * @param max the maximum acceptable integer value
     * @return a valid integer within the specified range
     */
    public static int checkInputIntLimit(int min, int max) {
        // Loop until user inputs a correct integer within the range
        while (true) {
            try {
                // Parse the user's input as an integer
                int result = Integer.parseInt(in.nextLine().trim());

                // Check if the input is within the specified range
                if (result < min || result > max) {
                    throw new NumberFormatException(); // Throw exception if out of range
                }

                // Return the valid result
                return result;
            } catch (NumberFormatException e) {
                // Inform the user about the error and prompt again
                System.err.println("Please input number in range [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * Prompts the user to input a double value.
     * Continues to prompt until a valid double is entered.
     *
     * @return a valid double input by the user
     */
    public static double checkInputDouble() {
        // Loop until user inputs a correct double
        while (true) {
            try {
                // Parse the user's input as a double
                double result = Double.parseDouble(in.nextLine());
                // Return the valid result
                return result;
            } catch (NumberFormatException e) {
                // Inform the user about the error and prompt again
                System.err.println("Must be input double");
                System.out.print("Enter again: ");
            }
        }
    }
    
    /**
     * Prompts the user to input a double value that is greater than 0.
     * Continues to prompt until a valid double is entered.
     *
     * @return a valid double value greater than 0
     */
    public static double possitiveNumber() {
        // Loop until user inputs a correct double
        while (true) {
            try {
                // Parse the user's input as a double
                double result = Double.parseDouble(in.nextLine());

                // Check if the input is greater than 0
                if (result <= 0) {
                    throw new NumberFormatException(); // Throw exception if not positive
                }

                // Return the valid result
                return result;
            } catch (NumberFormatException e) {
                // Inform the user about the error and prompt again
                System.err.println("Number must be greater than 0");
                System.out.print("Enter again: ");
            }
        }
    }
}
