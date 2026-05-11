package utils;

import java.util.Scanner;

/**
 * Lớp tiện ích dùng để kiểm tra và nhận dữ liệu nhập từ người dùng.
 */
public class Validation {
    private final Scanner sc = new Scanner(System.in);

    /**
     * Lấy số nguyên trong một khoảng nhất định.
     * 
     * @param msg Thông báo yêu cầu nhập
     * @param min Giá trị nhỏ nhất
     * @param max Giá trị lớn nhất
     * @return Số nguyên hợp lệ
     */
    public int getInteger(String msg, int min, int max) {
        int output;
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty, please try again");
                continue;
            }
            try {
                output = Integer.parseInt(input);
                if (output < min || output > max) {
                    System.out.println("Input must be in range [" + min + "," + max + "], please try again");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input must be integer");
            }
        }
        return output;
    }

    /**
     * Lấy chuỗi ký tự khớp với định dạng regex.
     * 
     * @param msg Thông báo yêu cầu nhập
     * @param regex Định dạng kiểm tra
     * @param exampleOfRegex Ví dụ về định dạng đúng
     * @return Chuỗi ký tự hợp lệ
     */
    public String getString(String msg, String regex, String exampleOfRegex) {
        String output;
        while (true) {
            System.out.print(msg);
            output = sc.nextLine();
            if (output.isEmpty()) {
                System.out.println("Input cannot be empty, please try again");
                continue;
            }
            if (regex.isEmpty() || output.matches(regex)) {
                break;
            } else {
                System.out.println("Incorrect format input");
                System.out.println("Correct input like: " + exampleOfRegex);
            }
        }
        return output;
    }
    
    /**
     * Xác nhận lựa chọn Yes/No từ người dùng.
     * 
     * @param msg Thông báo yêu cầu xác nhận
     * @return true nếu chọn Y, false nếu chọn N
     */
    public boolean checkYN(String msg) {
        while (true) {
            String result = getString(msg, "[yYnN]", "Y or N");
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
        }
    }

    /**
     * Xác nhận lựa chọn Update/Delete từ người dùng.
     * 
     * @param msg Thông báo yêu cầu xác nhận
     * @return "U" nếu chọn Update, "D" nếu chọn Delete
     */
    public String checkUD(String msg) {
        while (true) {
            String result = getString(msg, "[uUdD]", "U or D");
            return result.toUpperCase();
        }
    }
}
