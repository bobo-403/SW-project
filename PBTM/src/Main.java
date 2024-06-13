import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static UserControl userControl = new UserControl();
    private static AdminMenu adminMenu = new AdminMenu();
    private static CustomerMenu customerMenu = new CustomerMenu();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Personal body type mall");
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume the newline
            System.out.println();
            if (option == 1) {
                signUp();
            } else if (option == 2) {
                login();
            } else if (option == 0) {
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void signUp() {
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println();

        if (userControl.signUp(id, password, phoneNumber)) {
            System.out.println("Sign Up successful.");
        } else {
            System.out.println("Sign Up failed User ID or Phone Number already exists.");
        }
        System.out.println();
    }

    private static void login() {
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.println();

        if (userControl.isAdmin(id, password)) {
            Admin admin = new Admin();
            adminMenu.adminMenu(admin);
        } else {
            User user = userControl.login(id, password);

            if (user != null) {
                customerMenu.customerMenu((Customer) user);

            } else {
                System.out.println("Login failed. Invalid User ID or Password.");
                System.out.println();
            }
        }
    }
}
