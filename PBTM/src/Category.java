import java.util.*;

public class Category {
    private String name;
    private List<Product> products = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int productId) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductId() == productId) {
                iterator.remove();
                System.out.println("Product removed successfully.");
                return;
            }
        }
        System.out.println("Product with ID " + productId + " not found in the category.");
    }

    public List<Product> getProducts() {
        return products;
    }

    public void displayProducts() {
        System.out.println(this.name);
        System.out.println();
        if (products.isEmpty()) {
            System.out.println("No products in this category.");
            System.out.println();
        } else {
            for (Product product : products) {
                product.viewDetails();
                System.out.println();
            }
        }
    }

}
