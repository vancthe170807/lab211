package Entity;

public class Fruit {
    private String fruitId;
    private String fruitName;
    private double price;
    private int quantity;
    private String origin;

    public Fruit(String fruitId, String fruitName, double price, int quantity, String origin) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    // Getters and Setters
    public String getFruitId() { return fruitId; }
    public String getFruitName() { return fruitName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getOrigin() { return origin; }

    public void setQuantity(int quantity) {
        if (quantity < 0) throw new IllegalArgumentException("Quantity cannot be negative");
        this.quantity = quantity;
    }

    public void updateQuantity(int amount) {
        this.quantity += amount;
    }

    @Override
    public String toString() {
        return String.format("%-15s | %-10s | %-10.1f$", fruitName, origin, price);
    }
}