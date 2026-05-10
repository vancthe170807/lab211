package Manager;

import Entity.Fruit;
import Entity.Order;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Main entry point for the Fruit Shop Management System.
 * Optimized for Clean Code and better data structure usage.
 */
public class Main {

    public static void main(String[] args) {
        // Use List and Map interfaces for flexibility
        List<Fruit> fruitList = new ArrayList<>();
        Map<String, List<Order>> ordersMap = new HashMap<>();

        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    Manager.createFruit(fruitList);
                    break;
                case 2:
                    Manager.viewOrder(ordersMap);
                    break;
                case 3:
                    Manager.shopping(fruitList, ordersMap);
                    break;
                case 4:
                    System.out.println("Thank you for using the system. Goodbye!");
                    return;
                default:
                    System.err.println("Invalid choice. Please try again.");
            }
        }
    }
}