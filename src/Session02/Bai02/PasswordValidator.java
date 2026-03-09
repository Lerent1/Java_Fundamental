package Session02.Bai02;

@FunctionalInterface
public interface PasswordValidator {
    boolean isValid(String password);
}
