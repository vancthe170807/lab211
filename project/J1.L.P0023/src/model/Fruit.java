package model;

/**
 * Lớp Fruit đại diện cho thực thể trái cây trong hệ thống.
 */
public class Fruit {
    private String fruitId;
    private String fruitName;
    private double price;
    private int quantity;
    private String origin;

    /**
     * Khởi tạo một đối tượng Fruit mới.
     *
     * @param fruitId   Mã trái cây
     * @param fruitName Tên trái cây
     * @param price     Giá
     * @param quantity  Số lượng
     * @param origin    Xuất xứ
     */
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
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * Trình bày thông tin trái cây dưới dạng chuỗi định dạng.
     *
     * @return Chuỗi thông tin trái cây
     */
    @Override
    public String toString() {
        return String.format("%-15s | %-10s | %-10.1f$", fruitName, origin, price);
    }
}