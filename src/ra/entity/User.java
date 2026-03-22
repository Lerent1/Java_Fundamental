package ra.entity;

import java.util.Scanner;

public class User {
    private String userId;
    private String userName;
    private int age;
    private String role;
    private double score;

    public User() {
    }

    public User(String userId, String userName, int age, String role, double score) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
        this.role = role;
        this.score = score;
    }

    public String getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }
    public int getAge() {
        return age;
    }
    public String getRole() {
        return role;
    }
    public double getScore() {
        return score;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public void setScore(double score) {
        this.score = score;
    }

    public void inputData(Scanner scanner) {
        System.out.print("Nhập mã user: ");
        this.userId = scanner.nextLine();

        System.out.print("Nhập tên user: ");
        this.userName = scanner.nextLine();

        while (true) {
            System.out.print("Nhập tuổi (>=18): ");
            try {
                this.age = Integer.parseInt(scanner.nextLine());
                if (age >= 18) break;
                System.out.println("Tuổi phải >= 18!");
            } catch (Exception e) {
                System.out.println("Nhập sai định dạng!");
            }
        }

        while (true) {
            System.out.print("Nhập role (USER/ADMIN): ");
            this.role = scanner.nextLine().toUpperCase();
            if (role.equals("USER") || role.equals("ADMIN")) break;
            System.out.println("Role không hợp lệ!");
        }

        while (true) {
            System.out.print("Nhập điểm (0-10): ");
            try {
                this.score = Double.parseDouble(scanner.nextLine());
                if (score >= 0 && score <= 10) break;
                System.out.println("Điểm từ 0-10!");
            } catch (Exception e) {
                System.out.println("Sai định dạng!");
            }
        }
    }

    public void displayData() {
        System.out.printf("%-10s %-20s %-5d %-10s %-5.2f\n", userId, userName, age, role, score);
    }
}
