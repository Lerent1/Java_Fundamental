package Session02.Bai05;

public interface UserActions {
    default void logActivity(String activity) {
        System.out.println("User activity: " + activity);
    }
}
