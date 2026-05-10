package Entity;

public class Order {
    private String fruitName;
    private int quantity;
    private double price;

    public Order(String fruitName, int quantity, double price) {
        this.fruitName = fruitName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getFruitName() { return fruitName; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    public double getAmount() {
        return price * quantity;
    }
}