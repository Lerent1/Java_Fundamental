package Session03.Bai04;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Gioi02 {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("minh", "minh@gmail.com"),
                new User("thangl", "thang@yahoo.com"),
                new User("loc", "loc@gmail.com"),
                new User("tien", "tien@gmail.com")
        );

        List<User> uniqueUsers = new ArrayList<>(
                users.stream().collect(Collectors.toMap(User::username, u -> u, (u1, u2) -> u1)).values()
        );

        uniqueUsers.forEach(System.out::println);
    }
}
