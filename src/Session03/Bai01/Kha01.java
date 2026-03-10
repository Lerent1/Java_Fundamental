package Session03.Bai01;

import java.util.ArrayList;
import java.util.List;

public class Kha01 {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("alice", "alice@gmail.com", "ACTIVE"));
        users.add(new User("bob", "bob@gmail.com", "INACTIVE"));
        users.add(new User("charlie", "charlie@gmail.com", "ACTIVE"));

        users.forEach(user -> System.out.println("Username: " + user.username()
                + ", Email: " + user.email() + ", Status: " + user.status())
        );
    }
}
