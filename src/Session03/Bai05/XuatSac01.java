package Session03.Bai05;

import java.util.Comparator;
import java.util.List;

public class XuatSac01 {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("minh", "minh@gmail.com"),
                new User("thangl", "thang@gmail.com"),
                new User("loc", "loc@gmail.com"),
                new User("thangu", "thangu@gmail.com"),
                new User("minhvippro", "minhquy@gmail.com")
        );
        users.stream().sorted(Comparator.comparingInt((User u) -> u.username().length()).reversed())
                .limit(3).forEach(u -> System.out.println(u.username()));
    }
}
