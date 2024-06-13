import java.util.*;

public class Customer extends User {
    private List<Order> orderHistory = new ArrayList<>();
    private Cart cart = new Cart();
    private String personalType;

    public Customer(String userId, String password, String phoneNumber) {
        super(userId, password, phoneNumber);
    }

    public void setPersonalType(String personalType) {
        this.personalType = personalType;
    }

    public String getPersonalType() {
        return personalType;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }

    public void addToOrderHistory(Order order) {
        this.orderHistory.add(order);
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

}
