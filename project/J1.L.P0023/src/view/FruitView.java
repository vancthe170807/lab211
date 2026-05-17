package view;

import java.util.List;
import java.util.Map;
import model.Constants;
import model.Fruit;
import model.Order;

/**
 * The FruitView class handles displaying information to the console.
 */
public class FruitView {

    /**
     * Displays the main menu of the program.
     */
    public void displayMenu() {
        System.out.println(Constants.MENU_TITLE);
        System.out.println(Constants.MENU_OPTION_1);
        System.out.println(Constants.MENU_OPTION_2);
        System.out.println(Constants.MENU_OPTION_3);
        System.out.println(Constants.MENU_OPTION_4);
        System.out.print(Constants.MENU_PROMPT);
    }

    /**
     * Displays the list of available fruits for purchase.
     *
     * @param fruitList The list of fruits to display
     */
    public void displayFruitList(List<Fruit> fruitList) {
        int index;

        // Check if list is empty
        if (fruitList.isEmpty()) {
            System.out.println(Constants.MESSAGE_SHOP_EMPTY);

            return;
        }

        System.out.println(Constants.FRUIT_TABLE_SEP);
        System.out.printf(Constants.FRUIT_TABLE_HEADER, "Item", "Fruit Name", "Origin", "Price");
        System.out.println(Constants.FRUIT_TABLE_SEP);

        index = 1;

        // Iterate through fruit list
        for (Fruit fruit : fruitList) {
            // Display only available fruits
            if (fruit.getQuantity() > 0) {
                System.out.printf(Constants.FRUIT_TABLE_ROW,
                        index, fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());

                index = index + 1;
            }
        }

        System.out.println(Constants.FRUIT_TABLE_SEP);
    }

    /**
     * Displays the invoice of the current order.
     *
     * @param orderList The list of items in the order
     */
    public void displayInvoice(List<Order> orderList) {
        double totalAmount;

        totalAmount = 0;

        System.out.println(Constants.INVOICE_TABLE_SEP);
        System.out.printf(Constants.INVOICE_TABLE_HEADER, "Product", "Quantity", "Price", "Amount");
        System.out.println(Constants.INVOICE_TABLE_SEP);

        // Iterate through order list
        for (Order order : orderList) {
            System.out.printf(Constants.INVOICE_TABLE_ROW,
                    order.getFruitName(), order.getQuantity(), order.getPrice(), order.getAmount());

            totalAmount = totalAmount + order.getAmount();
        }

        System.out.println(Constants.INVOICE_TABLE_SEP);
        System.out.printf(Constants.TOTAL_AMOUNT_FORMAT, totalAmount);
    }

    /**
     * Displays all orders saved in the system.
     *
     * @param ordersMap A map containing customer names and their order lists
     */
    public void displayAllOrders(Map<String, List<Order>> ordersMap) {
        // Check if map is empty
        if (ordersMap.isEmpty()) {
            System.err.println(Constants.MESSAGE_NO_ORDERS);

            return;
        }

        // Iterate through all orders
        for (Map.Entry<String, List<Order>> entry : ordersMap.entrySet()) {
            StringBuilder customerLabel;

            customerLabel = new StringBuilder();
            customerLabel.append(Constants.MESSAGE_CUSTOMER_LABEL);
            customerLabel.append(entry.getKey());

            System.out.println(customerLabel.toString());
            displayInvoice(entry.getValue());
        }
    }
}