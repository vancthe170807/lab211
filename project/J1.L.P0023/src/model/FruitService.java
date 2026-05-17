package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The FruitService class handles fruit inventory and order business logic.
 */
public class FruitService {

    private final List<Fruit> fruitList;

    private final Map<String, List<Order>> ordersMap;

    /**
     * Initializes an empty fruit inventory and order storage.
     */
    public FruitService() {
        this.fruitList = new ArrayList<>();
        this.ordersMap = new HashMap<>();
    }

    /**
     * Gets all saved customer orders.
     *
     * @return A map containing customer names and order lists
     */
    public Map<String, List<Order>> getOrdersMap() {
        return ordersMap;
    }

    /**
     * Checks whether a fruit ID already exists.
     *
     * @param id The fruit ID to check
     * @return True if the ID exists, otherwise false
     */
    public boolean isFruitIdExists(String id) {
        return findFruitById(id) != null;
    }

    /**
     * Adds a new fruit to the inventory.
     *
     * @param id       The fruit ID
     * @param name     The fruit name
     * @param price    The fruit price
     * @param quantity The fruit quantity
     * @param origin   The fruit origin
     */
    public void addFruit(String id, String name, double price, int quantity, String origin) {
        Fruit fruit;

        fruit = new Fruit(id, name, price, quantity, origin);
        fruitList.add(fruit);
    }

    /**
     * Checks whether at least one fruit is available.
     *
     * @return True if any fruit has positive quantity, otherwise false
     */
    public boolean hasAvailableFruit() {
        // Check inventory quantities.
        for (Fruit fruit : fruitList) {
            if (fruit.getQuantity() > 0) {
                return true;
            }
        }

        return false;
    }

    /**
     * Gets all fruits that are still available for purchase.
     *
     * @return A list of available fruits
     */
    public List<Fruit> getAvailableFruitList() {
        List<Fruit> availableFruitList;

        availableFruitList = new ArrayList<>();

        // Filter fruits that can be sold.
        for (Fruit fruit : fruitList) {
            if (fruit.getQuantity() > 0) {
                availableFruitList.add(fruit);
            }
        }

        return availableFruitList;
    }

    /**
     * Creates an empty order list for a shopping session.
     *
     * @return A new empty order list
     */
    public List<Order> createOrderList() {
        return new ArrayList<>();
    }

    /**
     * Adds selected fruit quantity to the current order list.
     *
     * @param orderList The current order list
     * @param fruit     The selected fruit
     * @param quantity  The selected quantity
     */
    public void addOrderItem(List<Order> orderList, Fruit fruit, int quantity) {
        fruit.setQuantity(fruit.getQuantity() - quantity);
        updateOrderList(orderList, fruit, quantity);
    }

    /**
     * Saves a completed order for a customer.
     *
     * @param customerName The customer name
     * @param orderList    The completed order list
     */
    public void saveOrder(String customerName, List<Order> orderList) {
        // Merge with old orders for the same customer.
        if (ordersMap.containsKey(customerName)) {
            ordersMap.get(customerName).addAll(orderList);
        } else {
            ordersMap.put(customerName, orderList);
        }
    }

    /**
     * Updates the current order list with selected fruit and quantity.
     *
     * @param orderList The current list of orders
     * @param fruit     The selected fruit
     * @param quantity  The quantity purchased
     */
    private void updateOrderList(List<Order> orderList, Fruit fruit, int quantity) {
        // Search for an existing item in the order list.
        for (Order order : orderList) {
            if (order.getFruitName().equals(fruit.getFruitName())) {
                order.setQuantity(order.getQuantity() + quantity);

                return;
            }
        }

        orderList.add(new Order(fruit.getFruitName(), quantity, fruit.getPrice()));
    }

    /**
     * Finds a fruit from the fruit list by its ID.
     *
     * @param id The ID to search for
     * @return The Fruit object if found, otherwise null
     */
    private Fruit findFruitById(String id) {
        // Search by ID case-insensitively.
        for (Fruit fruit : fruitList) {
            if (fruit.getFruitId().equalsIgnoreCase(id)) {
                return fruit;
            }
        }

        return null;
    }
}
