import java.util.*;

public class Admin extends User {
    private static final String ADMIN_ID = "admin";
    private static final String ADMIN_PASSWORD = "admin123";
    private static final String ADMIN_PHONENUMBER = "0000-0000";
    private List<Customer> customers = new ArrayList<>();

    public Admin() {
        super(ADMIN_ID, ADMIN_PASSWORD, ADMIN_PHONENUMBER);
    }

    public void addCutomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

}
