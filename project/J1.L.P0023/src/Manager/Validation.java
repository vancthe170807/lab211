package Manager;

import java.util.Scanner;

public class Validation {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(SCANNER.nextLine().trim());
                if (result < min || result > max) throw new NumberFormatException();
                return result;
            } catch (NumberFormatException e) {
                System.err.printf("Please input number in range [%d, %d]: ", min, max);
            }
        }
    }

    public static String checkInputString() {
        while (true) {
            String result = SCANNER.nextLine().trim();
            if (result.isEmpty()) {
                System.err.print("Not empty! Enter again: ");
            } else return result;
        }
    }

    public static double checkInputDouble() {
        while (true) {
            try {
                return Double.parseDouble(SCANNER.nextLine().trim());
            } catch (NumberFormatException e) {
                System.err.print("Must be a double. Enter again: ");
            }
        }
    }

    public static boolean checkInputYN() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")) return true;
            if (result.equalsIgnoreCase("N")) return false;
            System.err.print("Please input Y or N: ");
        }
    }
}