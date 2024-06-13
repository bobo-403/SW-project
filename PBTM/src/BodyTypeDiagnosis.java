import java.util.*;

public class BodyTypeDiagnosis {
    private static final String[] bodyTypes = { "natural", "wave", "straight" };

    public String performDiagnosis() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Body Type Diagnosis!");
        System.out.println("Please answer the following question to determine your body type:");

        // Asking questions to determine body type
        System.out.println("Do your shoulders and hips align?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int answer = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        if (answer == 1) {
            return bodyTypes[0]; // natural
        } else {
            System.out.println("Do you have a defined waist?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            answer = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            if (answer == 1) {
                return bodyTypes[1]; // wave
            } else {

                return bodyTypes[2]; // straight
            }
        }
    }
}
