package controller;

import model.Fruit;
import model.Order;
import view.FruitView;
import view.Validation;
import java.util.*;

/**
 * Lớp FruitController điều khiển luồng hoạt động giữa Model và View.
 */
public class FruitController {
    private final List<Fruit> fruitList;
    private final Map<String, List<Order>> ordersMap;
    private final FruitView view;
    private final Validation validation;

    /**
     * Khởi tạo Controller với các thành phần cần thiết.
     */
    public FruitController() {
        this.fruitList = new ArrayList<>();
        this.ordersMap = new HashMap<>();
        this.view = new FruitView();
        this.validation = new Validation();
    }

    /**
     * Bắt đầu chương trình và hiển thị menu chính.
     */
    public void start() {
        while (true) {
            view.displayMenu();
            int choice = validation.checkInputIntLimit(1, 4);
            switch (choice) {
                case 1:
                    createFruit();
                    break;
                case 2:
                    view.displayAllOrders(ordersMap);
                    break;
                case 3:
                    shopping();
                    break;
                case 4:
                    System.out.println("Thanks for using the system. Goodbye!");
                    return;
            }
        }
    }

    /**
     * Xử lý logic tạo mới trái cây.
     */
    private void createFruit() {
        do {
            System.out.print("Enter fruit id: ");
            String id = validation.checkInputString();
            if (findFruitById(id) != null) {
                System.err.println("ID already exists!");
                continue;
            }
            System.out.print("Enter fruit name: ");
            String name = validation.checkInputString();
            System.out.print("Enter price: ");
            double price = validation.checkInputDouble();
            System.out.print("Enter quantity: ");
            int quantity = (int) validation.checkInputDouble();
            System.out.print("Enter origin: ");
            String origin = validation.checkInputString();

            fruitList.add(new Fruit(id, name, price, quantity, origin));
            System.out.println("Fruit added successfully.");
            
            System.out.print("Do you want to continue (Y/N)? ");
        } while (validation.checkInputYN());
    }

    /**
     * Xử lý logic mua hàng dành cho khách hàng.
     */
    private void shopping() {
        if (fruitList.stream().noneMatch(f -> f.getQuantity() > 0)) {
            System.err.println("The shop is out of stock or has no products!");
            return;
        }

        List<Order> currentOrderList = new ArrayList<>();
        while (true) {
            // Lọc danh sách trái cây còn hàng
            List<Fruit> availableFruits = new ArrayList<>();
            for (Fruit f : fruitList) {
                if (f.getQuantity() > 0) {
                    availableFruits.add(f);
                }
            }

            if (availableFruits.isEmpty()) {
                System.out.println("All items are sold out!");
                break;
            }

            // Hiển thị và chọn mặt hàng
            view.displayFruitList(availableFruits);
            System.out.print("Select item: ");
            int itemIdx = validation.checkInputIntLimit(1, availableFruits.size());
            Fruit selectedFruit = availableFruits.get(itemIdx - 1);

            System.out.println("You selected: " + selectedFruit.getFruitName());
            System.out.print("Please input quantity: ");
            int quantity = validation.checkInputIntLimit(1, selectedFruit.getQuantity());

            // Cập nhật số lượng trong kho và giỏ hàng
            selectedFruit.setQuantity(selectedFruit.getQuantity() - quantity);
            updateOrderList(currentOrderList, selectedFruit, quantity);

            System.out.print("Do you want to continue shopping (Y/N)? ");
            if (!validation.checkInputYN()) break;
        }

        if (!currentOrderList.isEmpty()) {
            view.displayInvoice(currentOrderList);
            System.out.print("Enter customer name: ");
            String customer = validation.checkInputString();
            
            // Fix: Tránh ghi đè nếu khách hàng đã tồn tại trong hệ thống
            if (ordersMap.containsKey(customer)) {
                ordersMap.get(customer).addAll(currentOrderList);
            } else {
                ordersMap.put(customer, currentOrderList);
            }
            System.out.println("Order saved successfully.");
        }
    }

    /**
     * Cập nhật danh sách đơn hàng hiện tại.
     * @param list Danh sách đơn hàng hiện tại
     * @param fruit Trái cây được chọn
     * @param qty Số lượng mua
     */
    private void updateOrderList(List<Order> list, Fruit fruit, int qty) {
        for (Order o : list) {
            if (o.getFruitName().equals(fruit.getFruitName())) {
                o.setQuantity(o.getQuantity() + qty);
                return;
            }
        }
        list.add(new Order(fruit.getFruitName(), qty, fruit.getPrice()));
    }

    /**
     * Tìm kiếm trái cây theo mã ID.
     * @param id Mã ID cần tìm
     * @return Đối tượng Fruit hoặc null nếu không thấy
     */
    private Fruit findFruitById(String id) {
        for (Fruit f : fruitList) {
            if (f.getFruitId().equalsIgnoreCase(id)) {
                return f;
            }
        }
        return null;
    }
}