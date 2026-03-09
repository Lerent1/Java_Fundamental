package Session02.Bai04;

import java.util.*;
import java.util.function.Supplier;

public class Gioi02 {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Minh"));
        users.add(new User("Thang"));
        users.add(new User("Loc"));

        users.stream().map(User::getUsername).forEach(System.out::println);

        Supplier<User> supplier = User::new;
        User newUser = supplier.get();

        System.out.println("New user: " + newUser.getUsername());
    }
}
