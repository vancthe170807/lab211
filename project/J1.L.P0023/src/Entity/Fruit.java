package Entity;

public class Fruit {

    private String fruitId;
    private String fruitName;
    private double price;
    private int quantity;
    private String origin;

    public Fruit() {
    }

    public Fruit(String fruitId, String fruitName, double price, int quantity, String origin) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public String getFruitId() {
        return fruitId;
    }

    public void setFruitId(String fruitId) {
        this.fruitId = fruitId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        // check if price is negative
        if(price < 0) {
            throw new IllegalArgumentException("Price of Fruit cannot be negative");
        } else {
        this.price = price;
        }
    }

    public int getQuantity() {
            return quantity;
    }

    public void setQuantity(int quantity) {
        // check if quantity is negative
        if(quantity < 0) {
            throw new IllegalArgumentException("Quantity of Fruit cannot be negative");
        } else {
            this.quantity = quantity;
        }
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void updateQuantity(int amount) {
        this.quantity += amount;
    }

    public boolean isAvailable() {
        return quantity > 0;
    }

    public double calculateTotalPrice(int requestredQuantity) {
        return price * requestredQuantity;
    }

}
