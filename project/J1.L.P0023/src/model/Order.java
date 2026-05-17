package model;

/**
 * The Order class represents a line item in a shopping cart.
 */
public class Order {

    private String fruitName;

    private int quantity;

    private double price;

    /**
     * Initializes a new Order object.
     *
     * @param fruitName The name of the fruit
     * @param quantity  The quantity purchased
     * @param price     The price at the time of purchase
     */
    public Order(String fruitName, int quantity, double price) {
        this.fruitName = fruitName;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Gets the fruit name.
     *
     * @return The name of the fruit
     */
    public String getFruitName() {
        return fruitName;
    }

    /**
     * Sets the fruit name.
     *
     * @param fruitName The name of the fruit
     */
    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    /**
     * Gets the quantity.
     *
     * @return The quantity ordered
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity.
     *
     * @param quantity The quantity ordered
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the price.
     *
     * @return The price per unit
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price.
     *
     * @param price The price per unit
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Calculates the total amount for this order item.
     *
     * @return The calculated amount (price * quantity)
     */
    public double getAmount() {
        double amount;

        amount = price * quantity;

        return amount;
    }
}