package Manager;

import controller.FruitController;

/**
 * Lớp Main là điểm khởi đầu của ứng dụng.
 */
public class Main {
    /**
     * Phương thức main để khởi chạy chương trình.
     * @param args Tham số dòng lệnh
     */
    public static void main(String[] args) {
        FruitController controller = new FruitController();
        controller.start();
    }
}