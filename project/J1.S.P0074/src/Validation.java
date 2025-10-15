import java.util.Scanner;

public class Validation {
    private final static Scanner sc = new Scanner(System.in);

    // Check if input is an integer number in the range [min, max]
    public int checkIntegerLimit(int min, int max, String message) {
        while (true) {
            try {
                System.out.print(message);
                int result = Integer.parseInt(sc.nextLine());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer between " + min + " and " + max + ".");
            }
        }
    }

    // Check if input is an integer number
    public int checkInteger(String message) {
        while (true) {
            try {
                System.out.print(message);
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Valid of matrix is digit");
            }
        }
    }
}
