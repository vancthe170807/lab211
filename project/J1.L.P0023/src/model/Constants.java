package model;

/**
 * The Constants class stores all constant values used in the application.
 */
public class Constants {

    /**
     * Formatting string for displaying fruit information.
     */
    public static final String FRUIT_DISPLAY_FORMAT = "%-15s | %-10s | %-10.1f$";

    /**
     * Error message for empty input.
     */
    public static final String ERROR_EMPTY_INPUT = "Not empty! Enter again: ";

    /**
     * Error message for invalid positive number.
     */
    public static final String ERROR_POSITIVE_NUMBER = "Must be a positive number. Enter again: ";

    /**
     * Error message for invalid Y/N input.
     */
    public static final String ERROR_YN_INPUT = "Please input Y or N: ";

    /**
     * Prompt for range input error.
     */
    public static final String ERROR_RANGE_FORMAT = "Please input number in range [%d, %d]: ";

    /**
     * String 'Y' for Yes.
     */
    public static final String YES = "Y";

    /**
     * String 'N' for No.
     */
    public static final String NO = "N";

    /**
     * Main menu title.
     */
    public static final String MENU_TITLE = "\n================ FRUIT SHOP SYSTEM ================";

    /**
     * Menu option 1.
     */
    public static final String MENU_OPTION_1 = "1. Create Fruit";

    /**
     * Menu option 2.
     */
    public static final String MENU_OPTION_2 = "2. View orders";

    /**
     * Menu option 3.
     */
    public static final String MENU_OPTION_3 = "3. Shopping (for buyer)";

    /**
     * Menu option 4.
     */
    public static final String MENU_OPTION_4 = "4. Exit";

    /**
     * Prompt for user choice.
     */
    public static final String MENU_PROMPT = "Enter your choice: ";

    /**
     * Shop empty message.
     */
    public static final String MESSAGE_SHOP_EMPTY = "The shop is currently empty.";

    /**
     * Fruit table separator.
     */
    public static final String FRUIT_TABLE_SEP =
            "+------+-----------------+------------+------------+";

    /**
     * Fruit table header format.
     */
    public static final String FRUIT_TABLE_HEADER = "| %-4s | %-15s | %-10s | %-10s |\n";

    /**
     * Fruit table row format.
     */
    public static final String FRUIT_TABLE_ROW = "| %-4d | %-15s | %-10s | %-9.1f$ |\n";

    /**
     * Invoice table separator.
     */
    public static final String INVOICE_TABLE_SEP =
            "+-----------------+----------+--------+----------+";

    /**
     * Invoice table header format.
     */
    public static final String INVOICE_TABLE_HEADER = "| %-15s | %-8s | %-6s | %-8s |\n";

    /**
     * Invoice table row format.
     */
    public static final String INVOICE_TABLE_ROW = "| %-15s | %-8d | %-5.1f$ | %-7.1f$ |\n";

    /**
     * Total amount format.
     */
    public static final String TOTAL_AMOUNT_FORMAT = "Total: %.1f$\n";

    /**
     * Customer label message.
     */
    public static final String MESSAGE_CUSTOMER_LABEL = "\nCustomer: ";

    /**
     * No orders found message.
     */
    public static final String MESSAGE_NO_ORDERS = "No orders found.";

    /**
     * Thanks message.
     */
    public static final String MESSAGE_THANKS = "Thanks for using the system. Goodbye!";

    /**
     * ID exists error.
     */
    public static final String ERROR_ID_EXISTS = "ID already exists!";

    /**
     * Fruit added message.
     */
    public static final String MESSAGE_FRUIT_ADDED = "Fruit added successfully.";

    /**
     * Continue prompt.
     */
    public static final String PROMPT_CONTINUE = "Do you want to continue (Y/N)? ";

    /**
     * Out of stock message.
     */
    public static final String MESSAGE_OUT_OF_STOCK =
            "The shop is out of stock or has no products!";

    /**
     * Prompt for fruit ID input.
     */
    public static final String PROMPT_FRUIT_ID = "Enter fruit id: ";

    /**
     * Prompt for fruit name input.
     */
    public static final String PROMPT_FRUIT_NAME = "Enter fruit name: ";

    /**
     * Prompt for price input.
     */
    public static final String PROMPT_PRICE = "Enter price: ";

    /**
     * Prompt for quantity input.
     */
    public static final String PROMPT_QUANTITY = "Enter quantity: ";

    /**
     * Prompt for origin input.
     */
    public static final String PROMPT_ORIGIN = "Enter origin: ";

    /**
     * Prompt for selected item input.
     */
    public static final String PROMPT_SELECT_ITEM = "Select item: ";

    /**
     * Prompt for shopping quantity input.
     */
    public static final String PROMPT_INPUT_QUANTITY = "Please input quantity: ";

    /**
     * Prompt for continuing shopping.
     */
    public static final String PROMPT_CONTINUE_SHOPPING =
            "Do you want to continue shopping (Y/N)? ";

    /**
     * Prompt for customer name input.
     */
    public static final String PROMPT_CUSTOMER_NAME = "Enter customer name: ";

    /**
     * Message prefix for selected fruit.
     */
    public static final String MESSAGE_SELECTED_FRUIT = "You selected: ";

    /**
     * Error message for invalid positive integer.
     */
    public static final String ERROR_POSITIVE_INTEGER =
            "Must be a positive integer. Enter again: ";

    /**
     * All items sold out message.
     */
    public static final String MESSAGE_ALL_SOLD_OUT = "All items are sold out!";

    /**
     * Order saved message.
     */
    public static final String MESSAGE_ORDER_SAVED = "Order saved successfully.";

    /**
     * Private constructor to prevent instantiation.
     */
    private Constants() {
    }
}
