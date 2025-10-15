// Lớp Validation dùng để kiểm tra và nhập dữ liệu từ bàn phím
public class Validation {
    // Phương thức nhập chuỗi, kiểm tra không được để trống
    public static String stringInput(String inputName) {
        String st;
        do {
            System.out.println("Please enter " + inputName); // Yêu cầu nhập thông tin
            st = System.console().readLine(); // Đọc dữ liệu từ bàn phím
            if (st.trim().equals("")) { // Nếu chuỗi rỗng
                System.out.println("Please enter your name"); // Thông báo nhập lại
                st = System.console().readLine();
            } else {
                return st; // Trả về chuỗi hợp lệ
            }
        }
        while (true);
    }

    // Phương thức nhập số thực, kiểm tra giá trị trong khoảng 0-10
    public static double InputDouble(String inputName) {
        double value;
        do {
            System.out.println("Please enter " + inputName + ": "); // Yêu cầu nhập số
            value = Double.valueOf(System.console().readLine()); // Đọc và chuyển sang kiểu double
            if (value < 0 || value > 10) { // Kiểm tra giá trị hợp lệ
                System.out.println("Please enter a number between 0 and 10: "); // Thông báo nhập lại
            } else {
                return value; // Trả về giá trị hợp lệ
            }
        } while (true);
    }
}
