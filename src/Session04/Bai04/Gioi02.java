package Session04.Bai04;

public class Gioi02 {
    public static String evaluatePasswordStrength(String password) {
        if (password == null || password.length() < 6) {
            return "Yếu";
        }

        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasLower = password.matches(".*[a-z].*");
        boolean hasNumber = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");

        if (password.length() >= 8 && hasUpper && hasLower && hasNumber && hasSpecial) {
            return "Mạnh";
        }
        if (hasLower && hasNumber) {
            return "Trung bình";
        }
        return "Yếu";
    }
}