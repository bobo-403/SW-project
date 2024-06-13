import java.util.*;

public class AdminMenu extends Menu {

    public void adminMenu(Admin admin) {
        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. Product Manage");
            System.out.println("2. Customer Order");
            System.out.println("3. Review");
            System.out.println("0. Logout");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            if (option == 1) {
                while (true) {
                    Category category;
                    System.out.print("1.addcategory, 2.mange Product 3.exit : ");
                    int answer = scanner.nextInt();
                    System.out.println();
                    scanner.nextLine();
                    if (answer == 1)
                        addcategory();
                    else if (answer == 2) {
                        category = viewProduct();
                        if (category == null) {
                            System.out.println("Category not found");
                            System.out.println();
                        } else
                            manageProduct(category);
                    } else if (answer == 3)
                        break;
                    else
                        System.out.println("Invalid answer");
                }
            } else if (option == 2) {
                viewallOrder();
            } else if (option == 3) {
                System.out.println("Review");
                System.out.println();
            } else if (option == 0) {
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public void addcategory() {

        System.out.print("new Category name : ");
        String name = scanner.nextLine();
        System.out.println();
        Category new_Category = new Category(name);
        Menu.categories.add(new_Category);
    }

    public void manageProduct(Category category) {

        System.out.print("1. remove 2. add  3.exit : ");
        int answer = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        if (answer == 1) {
            System.out.print("Enter product ID to remove: ");
            int productId = scanner.nextInt();
            category.removeProduct(productId);

        } else if (answer == 2) {
            System.out.print("Enter product ID: ");
            int productId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter product name: ");
            String productName = scanner.nextLine();

            System.out.print("Enter product price: ");
            float productPrice = scanner.nextFloat();
            scanner.nextLine();

            System.out.print("Enter product description: ");
            String description = scanner.nextLine();
            System.out.println();

            Product product = new Product(productId, productName, productPrice, description);
            category.addProduct(product);

        } else if (answer == 3) {
            return;
        } else {
            System.out.println("Invalid answer");
        }

    }

    public Category viewProduct() {
        if (Menu.categories.size() == 0) {
            System.out.println("There is no registered product");
            System.out.println();
            return null;
        }
        int i = 1;
        System.out.println("Category List");
        for (Category category : Menu.categories)
            System.out.println("(" + i++ + ")" + category.getName());
        System.out.println();

        System.out.print("edit Which category? ");
        String name = scanner.nextLine();
        System.out.println();
        Category selectedCategory = searchCategory(name);
        if (selectedCategory != null)
            selectedCategory.displayProducts();

        return selectedCategory;

    }

    public void viewallOrder() {
        if (customerOrder.isEmpty()) {
            System.out.println("no orders from customers.");
        } else {
            for (Map.Entry<Customer, List<Order>> entry : customerOrder.entrySet()) {
                Customer customer = entry.getKey();
                List<Order> orders = entry.getValue();
                System.out.println("고객 ID: " + customer.getUserId());
                for (Order order : orders) {
                    System.out.println(order);
                    System.out.println();
                }
            }
        }
    }

    public void viewReview() {

    }

}
