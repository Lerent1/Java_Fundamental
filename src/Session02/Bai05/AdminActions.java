package Session02.Bai05;

public interface AdminActions {
    default void logActivity(String activity) {
        System.out.println("Admin activity: " + activity);
    }
}
