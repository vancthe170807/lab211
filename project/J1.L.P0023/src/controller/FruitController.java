package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Constants;
import model.Fruit;
import model.Order;
import view.FruitView;
import view.Validation;

/**
 * The FruitController class manages the application flow by delegating tasks to
 * the Model and View layers.
 */
public class FruitController {

    private final List<Fruit> fruitList;

    private final Map<String, List<Order>> ordersMap;

    private final FruitView view;

    private final Validation validation;

    /**
     * Initializes the FruitController with its dependencies.
     */
    public FruitController() {
        this.fruitList = new ArrayList<>();
        this.ordersMap = new HashMap<>();
        this.view = new FruitView();
        this.validation = new Validation();
    }

    /**
     * Starts the program and handles the main menu loop.
     */
    public void start() {
        // Main program loop
        while (true) {
            int choice;

            view.displayMenu();

            choice = validation.checkInputIntLimit(1, 4);

            // Menu selection handling
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
                    System.out.println(Constants.MESSAGE_THANKS);
                    return;
                default:
                    break;
            }
        }
    }

    /**
     * Handles the logic for creating a new fruit.
     */
    private void createFruit() {
        // Loop for multiple fruit creation
        do {
            String id;
            String name;
            String origin;
            double price;
            int quantity;

            System.out.print("Enter fruit id: ");
            id = validation.checkInputString();

            // Check for duplicate ID
            if (findFruitById(id) != null) {
                System.err.println(Constants.ERROR_ID_EXISTS);

                continue;
            }

            System.out.print("Enter fruit name: ");
            name = validation.checkInputString();

            System.out.print("Enter price: ");
            price = validation.checkInputDouble();

            System.out.print("Enter quantity: ");
            quantity = validation.checkInputInt();

            System.out.print("Enter origin: ");
            origin = validation.checkInputString();

            fruitList.add(new Fruit(id, name, price, quantity, origin));

            System.out.println(Constants.MESSAGE_FRUIT_ADDED);
            System.out.print(Constants.PROMPT_CONTINUE);

        } while (validation.checkInputYN());
    }

    /**
     * Handles the shopping logic for customers.
     */
    private void shopping() {
        List<Order> currentOrderList;

        // Check if there are any fruits available
        if (fruitList.stream().noneMatch(f -> f.getQuantity() > 0)) {
            System.err.println(Constants.MESSAGE_OUT_OF_STOCK);

            return;
        }

        currentOrderList = new ArrayList<>();

        // Loop for selecting multiple items
        while (true) {
            List<Fruit> availableFruitList;
            Fruit selectedFruit;
            int itemIdx;
            int quantity;

            availableFruitList = new ArrayList<>();

            // Filter available fruits
            for (Fruit fruit : fruitList) {
                if (fruit.getQuantity() > 0) {
                    availableFruitList.add(fruit);
                }
            }

            // Check if items are sold out during session
            if (availableFruitList.isEmpty()) {
                System.out.println(Constants.MESSAGE_ALL_SOLD_OUT);

                break;
            }

            view.displayFruitList(availableFruitList);

            System.out.print("Select item: ");
            itemIdx = validation.checkInputIntLimit(1, availableFruitList.size());
            selectedFruit = availableFruitList.get(itemIdx - 1);

            System.out.println("You selected: " + selectedFruit.getFruitName());
            System.out.print("Please input quantity: ");
            quantity = validation.checkInputIntLimit(1, selectedFruit.getQuantity());

            selectedFruit.setQuantity(selectedFruit.getQuantity() - quantity);
            updateOrderList(currentOrderList, selectedFruit, quantity);

            System.out.print("Do you want to continue shopping (Y/N)? ");

            if (!validation.checkInputYN()) {
                break;
            }
        }

        // Finalize order if list is not empty
        if (!currentOrderList.isEmpty()) {
            String customerName;

            view.displayInvoice(currentOrderList);

            System.out.print("Enter customer name: ");
            customerName = validation.checkInputString();

            // Merge orders if customer exists
            if (ordersMap.containsKey(customerName)) {
                ordersMap.get(customerName).addAll(currentOrderList);
            } else {
                ordersMap.put(customerName, currentOrderList);
            }

            System.out.println(Constants.MESSAGE_ORDER_SAVED);
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
        // Search for existing item in order list
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
        // Search by ID (case insensitive)
        for (Fruit fruit : fruitList) {
            if (fruit.getFruitId().equalsIgnoreCase(id)) {
                return fruit;
            }
        }

        return null;
    }
}