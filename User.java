public class User {
    @Regex(pattern = "^[A-Z][a-z]+$", message = "Name must start with Capital letter")
    private String name;

    @Range(min = 18, max = 120, message = "Age must be between 18 and 120")
    private int age;

    @Regex(pattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Invalid email format")
    private String email;

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
