import java.util.*;

public class CustomerMenu extends Menu {

    public void customerMenu(Customer customer) {
        while (true) {
            System.out.println("Customer Menu:");
            System.out.println("1. Pernonal Type Diagosis");
            System.out.println("2. Products");
            System.out.println("3. Review");
            System.out.println("4. My Order");
            System.out.println("5. Cart");
            System.out.println("0. Logout");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            if (option == 1) {
                pernonalTypeDiagosis(customer);
            } else if (option == 2) {
                viewProduct(customer);
            } else if (option == 3) {
                System.out.println("Review");
            } else if (option == 4) {
                viewMyOrders(customer);
            } else if (option == 5) {
                viewCart(customer);
            } else if (option == 0) {
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }

        }
    }

    public void pernonalTypeDiagosis(Customer customer) {
        BodyTypeDiagnosis diagnosis = new BodyTypeDiagnosis();
        String personalType = diagnosis.performDiagnosis();
        System.out.println("Your Personal Body type is " + personalType);
        System.out.print("Save Personal Type?(y/n) ");
        String answer = scanner.nextLine();

        if (answer.equals("y"))
            customer.setPersonalType(personalType);
        System.out.println();

        System.out.print("Style Recommenation?(y/n) ");
        answer = scanner.nextLine();
        if(answer.equals("y"))
            StyleRecommendations(customer,personalType);


    }
    public void StyleRecommendations(Customer customer, String personalType){
        Category selectedCategory = searchCategory(personalType);

        if (selectedCategory != null)
            selectedCategory.displayProducts();
        else {
            System.out.println("No products registered for your type");
            System.out.println();
        }
    }

    public void viewProduct(Customer customer) {
        if (Menu.categories.size() == 0) {
            System.out.println("There is no registered product");
            System.out.println();
        }
        int i = 1;
        System.out.println("Category List");
        for (Category category : Menu.categories)
            System.out.println("(" + i++ + ")" + category.getName());
        System.out.println();

        System.out.print("Witch category? ");
        String name = scanner.nextLine();
        System.out.println();
        Category selectedCategory = searchCategory(name);

        if (selectedCategory != null)
            selectedCategory.displayProducts();
        else {
            System.out.println("Category not found");
            return;
        }

        while (true) {
            System.out.print("Product ID to add to cart (0 : finish)? ");
            int productId = scanner.nextInt();
            System.out.println();
            if (productId != 0) {
                System.out.print("quantity: ");
                int quantity = scanner.nextInt();
                System.out.println();

                Product selecteProduct = null;
                for (Product product : selectedCategory.getProducts()) {
                    if (product.getProductId() == productId) {
                        selecteProduct = product;
                        break;
                    }
                }
                Cart cart = customer.getCart();
                cart.addItem(selecteProduct, quantity);
                customer.setCart(cart);
            } else {
                break;
            }
        }

    }

    public void viewCart(Customer customer) {
        Cart cart = customer.getCart();
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            System.out.println();
            return;
        }
        cart.viewCart();
        System.out.print("1.Order product 2. exit : ");
        int answer = scanner.nextInt();
        scanner.nextLine();
        if (answer == 1) {
            Order newOrder = new Order(cart.getItems());
            System.out.print("Address : ");
            String adress = scanner.nextLine();
            newOrder.setAddress(adress);
            System.out.println();
            customer.addToOrderHistory(newOrder);
            cart.cartEmpty();
            Menu.customerOrder.put(customer, customer.getOrderHistory());

        } else if (answer == 2) {
            return;
        } else {
            System.out.println("Invalid option");
            System.out.println();
        }

    }

    public void viewReview() {

    }

    public void viewMyOrders(Customer customer) {
        List<Order> orders = customer.getOrderHistory();
        for (Order order : orders)
            System.out.println(order);
        System.out.println();
    }
}
