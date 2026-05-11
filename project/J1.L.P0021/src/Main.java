import controller.StudentController;

/**
 * Lớp khởi đầu của ứng dụng.
 */
public class Main {
    /**
     * Phương thức main để khởi chạy chương trình.
     * 
     * @param args Tham số dòng lệnh
     */
    public static void main(String[] args) {
        StudentController controller = new StudentController();
        controller.run();
    }
}

