package Session07.Bai06;

import java.util.ArrayList;
import java.util.List;

public class XuatSac02 {
    static class User {
        public final int id;
        private String username;
        private String password;

        public User(int id, String username, String password) {
            this.id = id;
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        @Override
        public String toString() {
            return "User{id=" + id + ", username='" + username + "'}";
        }
    }

    static class UserManager {
        private static List<User> users = new ArrayList<>();

        public static void addUser(User u) {
            users.add(u);
        }

        public static boolean checkLogin(String username, String password) {
            for (User u : users) {
                if (u.getUsername().equals(username)
                        && u.getPassword().equals(password)) {
                    return true;
                }
            }
            return false;
        }

        public static void showUsers() {
            for (User u : users) {
                System.out.println(u);
            }
        }
    }

    public static void main(String[] args) {
        User u1 = new User(1, "admin", "123");
        User u2 = new User(2, "user1", "abc");
        User u3 = new User(3, "user2", "xyz");

        UserManager.addUser(u1);
        UserManager.addUser(u2);
        UserManager.addUser(u3);

        System.out.println("Danh Sach user:");
        UserManager.showUsers();

        System.out.println("Dang nhap:");
        System.out.println("admin/123: " + UserManager.checkLogin("admin", "123"));
        System.out.println("user1/sai: " + UserManager.checkLogin("user1", "sai"));

    }
}
