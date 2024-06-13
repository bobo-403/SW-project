import java.util.*;

public class UserControl {
    private Map<String, User> users = new HashMap<>();

    public boolean signUp(String id, String pw, String phoneNumber) {
        if (users.containsKey(id) || users.values().stream().anyMatch(u -> u.getPhoneNumber().equals(phoneNumber))) {
            return false;
        } else if (id.equals("admin") || phoneNumber.equals("0000-0000"))
            return false;
        users.put(id, new Customer(id, pw, phoneNumber));
        return true;
    }

    public User login(String id, String pw) {
        User user = users.get(id);
        return (user != null && user.getPassword().equals(pw)) ? user : null;
    }

    public boolean isAdmin(String id, String pw) {
        return id.equals("admin") && pw.equals("admin123");
    }

}
