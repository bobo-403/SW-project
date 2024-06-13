import java.util.*;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    protected static List<Category> categories = new ArrayList<>();
    protected static Map<Customer, List<Order>> customerOrder = new HashMap<>();
    protected static List<Review> reviews = new ArrayList<>();

    public Category searchCategory(String name){
        for (Category category : Menu.categories) {
            if (category.getName().equalsIgnoreCase(name)) {
                return category;
            }
        }
        return null;
    }
}
