package Session02.Bai01;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Kha01 {
    public static void main(String[] args) {
        Predicate<User> isAdmin = u -> u.getRole().equals("ADMIN");
        Function<User, String> getUsername = u -> u.getUsername();
        Consumer<User> printUser = u -> System.out.println("User: " + u.getUsername() + ", Role: " + u.getRole());
        Supplier<User> createDefaultUser = () -> new User("guest", "USER");

        User u1 = new User("minh", "ADMIN");
        User u2 = createDefaultUser.get();

        System.out.println(isAdmin.test(u1));
        System.out.println(getUsername.apply(u1));
        printUser.accept(u1);
        printUser.accept(u2);
    }
}
