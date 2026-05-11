package view;

import java.util.Scanner;

/**
 * Lớp Validation cung cấp các phương thức để kiểm tra dữ liệu nhập từ người dùng.
 */
public class Validation {
    private final Scanner scanner;

    /**
     * Khởi tạo đối tượng Validation với một Scanner.
     */
    public Validation() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Kiểm tra và yêu cầu người dùng nhập một số nguyên trong khoảng giới hạn.
     * @param min Giá trị tối thiểu
     * @param max Giá trị tối đa
     * @return Số nguyên hợp lệ
     */
    public int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(scanner.nextLine().trim());
                if (result < min || result > max) throw new NumberFormatException();
                return result;
            } catch (NumberFormatException e) {
                System.err.printf("Please input number in range [%d, %d]: ", min, max);
            }
        }
    }

    /**
     * Kiểm tra và yêu cầu người dùng nhập một chuỗi không rỗng.
     * @return Chuỗi hợp lệ
     */
    public String checkInputString() {
        while (true) {
            String result = scanner.nextLine().trim();
            if (result.isEmpty()) {
                System.err.print("Not empty! Enter again: ");
            } else return result;
        }
    }

    /**
     * Kiểm tra và yêu cầu người dùng nhập một số thực dương.
     * @return Số thực hợp lệ
     */
    public double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(scanner.nextLine().trim());
                if (result < 0) throw new NumberFormatException();
                return result;
            } catch (NumberFormatException e) {
                System.err.print("Must be a positive number. Enter again: ");
            }
        }
    }

    /**
     * Kiểm tra người dùng nhập Y (Yes) hoặc N (No).
     * @return true nếu là Y, false nếu là N
     */
    public boolean checkInputYN() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")) return true;
            if (result.equalsIgnoreCase("N")) return false;
            System.err.print("Please input Y or N: ");
        }
    }
}