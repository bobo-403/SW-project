import java.util.*;

public class Cart {
    private Map<Product, Integer> items = new HashMap<>();

    public void addItem(Product product, int quantity) {
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public void removeItem(Product product) {
        items.remove(product);
    }

    public void updateItemQuantity(Product product, int quantity) {
        if (quantity <= 0) {
            removeItem(product);
        } else {
            items.put(product, quantity);
        }
    }

    public void cartEmpty() {
        items.clear();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public void viewCart() {
        double totalPrice = 0;
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            System.out.println();
        } else {
            System.out.println("Shopping Cart");
            System.out.println();
            for (Map.Entry<Product, Integer> entry : items.entrySet()) {
                Product product = entry.getKey();
                int quantity = entry.getValue();
                double Price = product.getPrice() * quantity;
                totalPrice += Price;
                System.out.println("Product: " + product.getName() +
                        ", Quantity: " + quantity +
                        ", Price: $" + Price);
                System.out.println();
            }
            System.out.println("Total Price: $" + totalPrice);
            System.out.println();
        }
    }
}
