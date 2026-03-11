package Session04.Bai02;

public class UserService {
    public static boolean checkRegistrationAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        return age >= 18;
    }
}
