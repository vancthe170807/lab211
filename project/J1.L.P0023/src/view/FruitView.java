package view;

import model.Fruit;
import model.Order;
import java.util.List;
import java.util.Map;

/**
 * Lớp FruitView xử lý việc hiển thị thông tin ra màn hình console.
 */
public class FruitView {
    
    /**
     * Hiển thị menu chính của chương trình.
     */
    public void displayMenu() {
        System.out.println("\n================ FRUIT SHOP SYSTEM ================");
        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Hiển thị danh sách trái cây có sẵn để mua.
     * @param fruits Danh sách trái cây
     */
    public void displayFruitList(List<Fruit> fruits) {
        if (fruits.isEmpty()) {
            System.out.println("The shop is currently empty.");
            return;
        }
        System.out.println("+------+-----------------+------------+------------+");
        System.out.printf("| %-4s | %-15s | %-10s | %-10s |\n", "Item", "Fruit Name", "Origin", "Price");
        System.out.println("+------+-----------------+------------+------------+");
        int i = 1;
        for (Fruit f : fruits) {
            if (f.getQuantity() > 0) {
                System.out.printf("| %-4d | %-15s | %-10s | %-9.1f$ |\n", 
                        i++, f.getFruitName(), f.getOrigin(), f.getPrice());
            }
        }
        System.out.println("+------+-----------------+------------+------------+");
    }

    /**
     * Hiển thị hóa đơn của đơn hàng hiện tại.
     * @param orders Danh sách các mục hàng
     */
    public void displayInvoice(List<Order> orders) {
        double total = 0;
        System.out.println("+-----------------+----------+--------+----------+");
        System.out.printf("| %-15s | %-8s | %-6s | %-8s |\n", "Product", "Quantity", "Price", "Amount");
        System.out.println("+-----------------+----------+--------+----------+");
        for (Order o : orders) {
            System.out.printf("| %-15s | %-8d | %-5.1f$ | %-7.1f$ |\n",
                    o.getFruitName(), o.getQuantity(), o.getPrice(), o.getAmount());
            total += o.getAmount();
        }
        System.out.println("+-----------------+----------+--------+----------+");
        System.out.printf("Total: %.1f$\n", total);
    }

    /**
     * Hiển thị tất cả các đơn hàng đã lưu trong hệ thống.
     * @param ordersMap Bản đồ chứa tên khách hàng và danh sách đơn hàng của họ
     */
    public void displayAllOrders(Map<String, List<Order>> ordersMap) {
        if (ordersMap.isEmpty()) {
            System.err.println("No orders found.");
            return;
        }
        for (Map.Entry<String, List<Order>> entry : ordersMap.entrySet()) {
            System.out.println("\nCustomer: " + entry.getKey());
            displayInvoice(entry.getValue());
        }
    }
}