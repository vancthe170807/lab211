package Manager;

import Entity.Fruit;
import Entity.Order;
import java.util.*;

public class Manager {

    public static int menu() {
        System.out.println("\n========= FRUIT SHOP SYSTEM =========");
        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        return Validation.checkInputIntLimit(1, 4);
    }

    public static void createFruit(List<Fruit> fruits) {
        do {
            System.out.print("Enter fruit id: ");
            String id = Validation.checkInputString();
            if (findFruitById(fruits, id) != null) {
                System.err.println("ID already exists!");
                continue;
            }
            System.out.print("Enter fruit name: ");
            String name = Validation.checkInputString();
            System.out.print("Enter price: ");
            double price = Validation.checkInputDouble();
            System.out.print("Enter quantity: ");
            int quantity = (int) Validation.checkInputDouble();
            System.out.print("Enter origin: ");
            String origin = Validation.checkInputString();

            fruits.add(new Fruit(id, name, price, quantity, origin));
            System.out.println("Fruit added successfully.");
            System.out.print("Do you want to continue (Y/N)? ");
        } while (Validation.checkInputYN());
    }

    public static void shopping(List<Fruit> fruits, Map<String, List<Order>> ordersMap) {
        if (fruits.isEmpty()) {
            System.err.println("Shop is empty!");
            return;
        }

        List<Order> currentOrderList = new ArrayList<>();
        while (true) {
            // 1. Lọc danh sách còn hàng
            List<Fruit> availableFruits = new ArrayList<>();
            for (Fruit f : fruits) {
                if (f.getQuantity() > 0) {
                    availableFruits.add(f);
                }
            }

            if (availableFruits.isEmpty()) {
                System.err.println("Sold out all items!");
                break;
            }

            // 2. Hiển thị danh sách đã lọc
            displayFruits(availableFruits);

            System.out.print("Select item: ");
            int itemIdx = Validation.checkInputIntLimit(1, availableFruits.size());

            // 3. Lấy đúng quả từ danh sách đã lọc
            Fruit selectedFruit = availableFruits.get(itemIdx - 1);

            System.out.println("You selected: " + selectedFruit.getFruitName());
            System.out.print("Please input quantity: ");
            int quantity = Validation.checkInputIntLimit(1, selectedFruit.getQuantity());

            selectedFruit.setQuantity(selectedFruit.getQuantity() - quantity);
            updateOrderList(currentOrderList, selectedFruit, quantity);

            System.out.print("Do you want to continue shopping (Y/N)? ");
            if (!Validation.checkInputYN()) break;
        }

        // Luu order
        displayInvoice(currentOrderList);
        System.out.print("Enter customer name: ");
        String customer = Validation.checkInputString();
        ordersMap.put(customer, currentOrderList);
    }

    private static void updateOrderList(List<Order> list, Fruit fruit, int qty) {
        for (Order o : list) {
            if (o.getFruitName().equals(fruit.getFruitName())) {
                // Trong thực tế nên dùng ID, nhưng đây là ví dụ theo cấu trúc cũ của bạn
                list.add(new Order(fruit.getFruitName(), qty, fruit.getPrice())); // simplified
                return;
            }
        }
        list.add(new Order(fruit.getFruitName(), qty, fruit.getPrice()));
    }

    public static void viewOrder(Map<String, List<Order>> ordersMap) {
        if (ordersMap.isEmpty()) {
            System.err.println("No orders yet.");
            return;
        }
        for (String name : ordersMap.keySet()) {
            System.out.println("\nCustomer: " + name);
            displayInvoice(ordersMap.get(name));
        }
    }

    private static void displayFruits(List<Fruit> fruits) {
        System.out.printf("| %-4s | %-15s | %-10s | %-10s |\n", "Item", "Fruit Name", "Origin", "Price");
        int i = 1;
        for (Fruit f : fruits) {
            if (f.getQuantity() > 0) {
                System.out.printf("| %-4d | %s\n", i++, f.toString());
            }
        }
    }

    private static void displayInvoice(List<Order> orders) {
        double total = 0;
        System.out.println("Product    | Quantity | Price | Amount");
        for (Order o : orders) {
            System.out.printf("%-10s | %-8d | %-5.1f$ | %-5.1f$\n",
                    o.getFruitName(), o.getQuantity(), o.getPrice(), o.getAmount());
            total += o.getAmount();
        }
        System.out.println("Total: " + total + "$");
    }

    private static Fruit findFruitById(List<Fruit> fruits, String id) {
        return fruits.stream().filter(f -> f.getFruitId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }
}