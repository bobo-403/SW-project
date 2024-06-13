import java.util.*;

public class Review {
    private int productId;
    private String customerId;
    private int rating;
    private String comment;

    public Review(int productId, String customerId, int rating, String comment) {
        this.productId = productId;
        this.customerId = customerId;
        this.rating = rating;
        this.comment = comment;
    }

    public void viewReview() {
        System.out.println("Product ID: " + productId);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Rating: " + rating);
        System.out.println("Comment: " + comment);
    }

    public void addReivew(Customer customer, ArrayList<Review> review) {
    }
}
