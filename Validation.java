import java.util.Scanner;

public class Validation {

    // Scanner object for user input
    public static Scanner scanner = new Scanner(System.in);

    /**
     * Reads an integer input from the user.
     * @return valid integer input
     */
    public static int getInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter an integer: ");
            }
        }
    }

    /**
     * Reads an integer within a given range.
     * @param msg Prompt message
     * @param min Minimum valid value
     * @param max Maximum valid value
     * @return valid integer within the range
     */
    public static int getInt(String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            try {
                int num = Integer.parseInt(scanner.nextLine());
                if (num >= min && num <= max) return num;
                System.out.println("Out of range, please enter a number between " + min + " and " + max + ": ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter an integer between " + min + " and " + max + ": ");
            }
        }
    }

    /**
     * Reads a positive integer from the user.
     * @return valid positive integer
     */
    public static int getPositiveInt() {
        while (true) {
            try {
                int num = Integer.parseInt(scanner.nextLine());
                if (num > 0) return num;
                System.out.println("Please enter a positive integer: ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a positive integer: ");
            }
        }
    }

    /**
     * Reads a double input from the user.
     * @return valid double value
     */
    public static double getDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a decimal number: ");
            }
        }
    }

    /**
     * Reads a double within a given range.
     * @param msg Prompt message
     * @param min Minimum valid value
     * @param max Maximum valid value
     * @return valid double within the range
     */
    public static double getDouble(String msg, double min, double max) {
        while (true) {
            System.out.print(msg);
            try {
                double num = Double.parseDouble(scanner.nextLine());
                if (num >= min && num <= max) return num;
                System.out.println("Out of range, please enter a number between " + min + " and " + max + ": ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number between " + min + " and " + max + ": ");
            }
        }
    }

    /**
     * Reads a non-empty string from the user.
     * @param msg Prompt message
     * @param err Error message for empty input
     * @return valid non-empty string
     */
    public static String getString(String msg, String err) {
        while (true) {
            System.out.print(msg);
            String s = scanner.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.err.println(err);
        }
    }

    /**
     * Reads a string that matches a given regex pattern.
     * @param msg Prompt message
     * @param regex Regular expression pattern
     * @param err Error message for invalid input
     * @return valid string matching the regex
     */
    public static String getStringRegex(String msg, String regex, String err) {
        while (true) {
            System.out.print(msg);
            String s = scanner.nextLine().trim();
            if (!s.isEmpty() && s.matches(regex)) return s;
            System.err.println(err);
        }
    }
}
