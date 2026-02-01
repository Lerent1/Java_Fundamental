package Session06.Bai02;

public class Kha02 {
    public static class Account {
        private String username;
        private String password;
        private String email;

        public Account(String username, String password, String email) {
            this.username = username;
            this.password = password;
            this.email = email;
        }

        public void changePassword(String newPassword) {
            this.password = newPassword;
            System.out.println("Doi mat khau thanh cong");
        }

        public void showInfo() {
            System.out.println("Username: " + username);
            System.out.println("Email: " + email);
            System.out.println("Password: ******");
        }
    }

    public static void main(String[] args) {
        Account acc = new Account("minh01", "123456", "minh@gmail.com");

        acc.showInfo();
        acc.changePassword("167206");
        acc.showInfo();
    }
}
