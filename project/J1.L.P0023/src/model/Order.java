package model;

/**
 * Lớp Order đại diện cho một mục hàng trong giỏ hàng.
 */
public class Order {
    private String fruitName;
    private int quantity;
    private double price;

    /**
     * Khởi tạo một đối tượng Order mới.
     *
     * @param fruitName Tên trái cây
     * @param quantity  Số lượng mua
     * @param price     Giá tại thời điểm mua
     */
    public Order(String fruitName, int quantity, double price) {
        this.fruitName = fruitName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Tính tổng tiền cho mục hàng này.
     *
     * @return Thành tiền
     */
    public double getAmount() {
        return price * quantity;
    }
}