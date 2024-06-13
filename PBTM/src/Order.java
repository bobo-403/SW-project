import java.util.*;

public class Order {
    private Map<Product, Integer> items;
    private Date orderDate;
    private float totalAmount;
    private String address;

    public Order(Map<Product, Integer> items) {
        this.items = new HashMap<>(items);
        this.orderDate = new Date();
        this.totalAmount = calculateTotal();
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private float calculateTotal() {
        return items.entrySet().stream().map(e -> e.getKey().getPrice() * e.getValue()).reduce(0.0f, Float::sum);
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Date: ").append(orderDate).append("\n");
        sb.append("Order Address: ").append(address).append("\n");
        sb.append("Items: \n");
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            sb.append("- ").append(product.getName()).append(": ").append(quantity).append("\n");
        }
        sb.append("Total Amount: ").append(totalAmount).append("\n");
        return sb.toString();
    }
}
