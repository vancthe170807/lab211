package controller;

import java.util.List;
import model.Constants;
import model.Fruit;
import model.FruitService;
import model.Order;
import view.FruitView;
import view.Validation;

/**
 * The FruitController class manages the application flow by delegating tasks to
 * the Model and View layers.
 */
public class FruitController {

    private final FruitService fruitService;

    private final FruitView view;

    private final Validation validation;

    /**
     * Initializes the FruitController with its dependencies.
     */
    public FruitController() {
        this.fruitService = new FruitService();
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
                    view.displayAllOrders(fruitService.getOrdersMap());
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

            id = view.inputString(Constants.PROMPT_FRUIT_ID, validation);

            // Check for duplicate ID
            if (fruitService.isFruitIdExists(id)) {
                view.displayError(Constants.ERROR_ID_EXISTS);

                continue;
            }

            name = view.inputString(Constants.PROMPT_FRUIT_NAME, validation);
            price = view.inputDouble(Constants.PROMPT_PRICE, validation);
            quantity = view.inputInteger(Constants.PROMPT_QUANTITY, validation);
            origin = view.inputString(Constants.PROMPT_ORIGIN, validation);

            fruitService.addFruit(id, name, price, quantity, origin);

            view.displayMessage(Constants.MESSAGE_FRUIT_ADDED);

        } while (view.inputYesNo(Constants.PROMPT_CONTINUE, validation));
    }

    /**
     * Handles the shopping logic for customers.
     */
    private void shopping() {
        List<Order> currentOrderList;

        // Check if there are any fruits available
        if (!fruitService.hasAvailableFruit()) {
            view.displayError(Constants.MESSAGE_OUT_OF_STOCK);

            return;
        }

        currentOrderList = fruitService.createOrderList();

        // Loop for selecting multiple items
        while (true) {
            List<Fruit> availableFruitList;
            Fruit selectedFruit;
            int itemIdx;
            int quantity;

            availableFruitList = fruitService.getAvailableFruitList();

            // Check if items are sold out during session
            if (availableFruitList.isEmpty()) {
                view.displayMessage(Constants.MESSAGE_ALL_SOLD_OUT);

                break;
            }

            view.displayFruitList(availableFruitList);

            itemIdx = view.inputIntegerLimit(Constants.PROMPT_SELECT_ITEM,
                    validation, 1, availableFruitList.size());
            selectedFruit = availableFruitList.get(itemIdx - 1);

            view.displaySelectedFruit(selectedFruit.getFruitName());
            quantity = view.inputIntegerLimit(Constants.PROMPT_INPUT_QUANTITY,
                    validation, 1, selectedFruit.getQuantity());

            fruitService.addOrderItem(currentOrderList, selectedFruit, quantity);

            if (!view.inputYesNo(Constants.PROMPT_CONTINUE_SHOPPING, validation)) {
                break;
            }
        }

        // Finalize order if list is not empty
        if (!currentOrderList.isEmpty()) {
            String customerName;

            view.displayInvoice(currentOrderList);

            customerName = view.inputString(Constants.PROMPT_CUSTOMER_NAME, validation);
            fruitService.saveOrder(customerName, currentOrderList);

            view.displayMessage(Constants.MESSAGE_ORDER_SAVED);
        }
    }
}
