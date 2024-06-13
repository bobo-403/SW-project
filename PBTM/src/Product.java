import java.util.Locale.Category;

import javax.management.Descriptor;

public class Product {
    private int productId;
    private String name;
    private float price;
    private String description;
    

    public Product(int productId, String name, float price, String description) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.description = description;

    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public void viewDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        if (description != null)
            System.out.println("Description: " + description);
    }

}
