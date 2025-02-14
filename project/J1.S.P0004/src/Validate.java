import java.util.Scanner;

public class Validate {
    private static Scanner sc = new Scanner(System.in);

    // Method to get a positive integer from the user
    public static int getPositiveInt() {
        Scanner scanner = new Scanner(System.in);
        int num;
        while (true) {
            try {
                num = Integer.parseInt(scanner.nextLine());
                if (num > 0) {
                    return num;
                } else {
                    System.out.println("Please enter a positive integer:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a positive integer:");
            }
        }
    }
}
