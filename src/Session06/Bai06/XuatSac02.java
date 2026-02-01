package Session06.Bai06;

import java.util.regex.Pattern;

public class XuatSac02 {
    public static class User {
        private int id;
        private String username;
        private String password;
        private String email;

        public User(int id, String username, String password, String email) {
            this.id = id;
            this.username = username;
            setPassword(password);
            setEmail(email);
        }

        public int getId() {
            return id;
        }
        public String getUsername() {
            return username;
        }
        public String getEmail() {
            return email;
        }
        public void setUsername(String username) {
            this.username = username;
        }

        public void setPassword(String password) {
            if (password != null && !password.trim().isEmpty()) {
                this.password = password;
            } else {
                System.out.println("Password kong dc rong");
            }
        }

        public void setEmail(String email) {
            String regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
            if (email != null && Pattern.matches(regex, email)) {
                this.email = email;
            } else {
                System.out.println("Email Khong hop le");
            }
        }

        public void hienThiThongTin() {
            System.out.println("ID: " + id);
            System.out.println("Username: " + username);
            System.out.println("Email: " + email);
            System.out.println("Password: ******");
        }
    }

    public static void main(String[] args) {
        System.out.println("User hop le:");
        User u1 = new User(1, "admin", "123456", "admin@gmail.com");
        u1.hienThiThongTin();

        System.out.println("\nUser sai email:");
        User u2 = new User(2, "user01", "abcdef", "sai-email");
        u2.hienThiThongTin();

        System.out.println("\nUser password Rong:");
        User u3 = new User(3, "user02", "", "user02@gmail.com");
        u3.hienThiThongTin();
    }
}
