package Session03.Bai02;

import java.util.ArrayList;
import java.util.List;

public class Kha02 {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("alice", "alice@gmail.com"));
        users.add(new User("bob", "bob@yahoo.com"));
        users.add(new User("charlie", "charlie@gmail.com"));

        users.stream().filter(user -> user.email().endsWith("@gmail.com")).forEach(user -> System.out.println(user.username()));
    }
}
