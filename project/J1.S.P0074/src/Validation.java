import java.util.Scanner;

public class Validation {

    private final Scanner in = new Scanner(System.in);

    public int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public int checkInputInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                int result = Integer.parseInt(in.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.out.println("Value of matrix is digit");
            }
        }

    }
}
