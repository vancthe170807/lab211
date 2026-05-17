package model;

/**
 * The Fruit class represents a fruit entity in the system.
 */
public class Fruit {

    private String fruitId;

    private String fruitName;

    private double price;

    private int quantity;

    private String origin;

    /**
     * Initializes a new Fruit object.
     *
     * @param fruitId   Fruit ID
     * @param fruitName Fruit Name
     * @param price     Price
     * @param quantity  Quantity
     * @param origin    Origin
     */
    public Fruit(String fruitId, String fruitName, double price, int quantity, String origin) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    /**
     * Gets the fruit ID.
     * 
     * @return The ID of the fruit
     */

    public String getFruitId() {
        return fruitId;
    }

    /**
     * Sets the fruit ID.
     *
     * @param fruitId The ID of the fruit
     */
    public void setFruitId(String fruitId) {
        this.fruitId = fruitId;
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
     * Gets the fruit price.
     *
     * @return The price of the fruit
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the fruit price.
     *
     * @param price The price of the fruit
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the fruit quantity.
     *
     * @return The quantity of the fruit
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the fruit quantity.
     *
     * @param quantity The quantity of the fruit
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the fruit origin.
     *
     * @return The origin of the fruit
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the fruit origin.
     *
     * @param origin The origin of the fruit
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * Returns a formatted representation of the fruit information.
     *
     * @return String representation of the fruit.
     */
    @Override
    public String toString() {
        String result;

        result = String.format(Constants.FRUIT_DISPLAY_FORMAT, fruitName, origin, price);

        return result;
    }
}