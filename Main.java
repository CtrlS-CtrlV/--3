import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Validating User 1 (Correct) ===");
        User validUser = new User("John", 25, "john.doe@example.com");
        runValidation(validUser);

        System.out.println("\n=== Validating User 2 (Incorrect) ===");
        User invalidUser = new User("john", 16, "john.doe.com");
        runValidation(invalidUser);
    }

    private static void runValidation(Object obj) {
        List<String> errors = Validator.validate(obj);
        if (errors.isEmpty()) {
            System.out.println("Validation passed! Object is valid.");
        } else {
            System.out.println("Validation failed with errors:");
            for (String error : errors) {
                System.out.println(" - " + error);
            }
        }
    }
}
