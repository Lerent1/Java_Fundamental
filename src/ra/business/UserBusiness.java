package ra.business;

import ra.entity.User;

import java.util.*;
import java.util.stream.Collectors;

public class UserBusiness {
    private static UserBusiness instance;
    private List<User> userList;

    private UserBusiness() {
        userList = new ArrayList<>();
    }

    public static UserBusiness getInstance() {
        if (instance == null) {
            instance = new UserBusiness();
        }
        return instance;
    }

    public void displayAll() {
        if (userList.isEmpty()) {
            System.out.println("Danh sách rỗng!");
            return;
        }
        System.out.printf("%-10s %-20s %-5s %-10s %-5s\n", "ID", "Name", "Age", "Role", "Score");
        userList.forEach(User::displayData);
    }

    public void addUser(User user) {
        boolean exists = userList.stream().anyMatch(u -> u.getUserId().equals(user.getUserId()));
        if (exists) {
            System.out.println("Mã người dùng đã tồn tại!");
        } else {
            userList.add(user);
            System.out.println("Thêm thành công!");
        }
    }

    public void updateUser(String id, Scanner scanner) {
        Optional<User> optional = userList.stream().filter(u -> u.getUserId().equals(id))
                .findFirst();

        if (!optional.isPresent()) {
            System.out.println("Mã người dùng không tồn tại!");
            return;
        }

        User user = optional.get();

        System.out.println("1. Tên");
        System.out.println("2. Tuổi");
        System.out.println("3. Role");
        System.out.println("4. Score");
        System.out.print("Chọn: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                System.out.print("Tên mới: ");
                user.setUserName(scanner.nextLine());
                break;
            case 2:
                System.out.print("Tuổi mới: ");
                user.setAge(Integer.parseInt(scanner.nextLine()));
                break;
            case 3:
                System.out.print("Role mới: ");
                user.setRole(scanner.nextLine());
                break;
            case 4:
                System.out.print("Score mới: ");
                user.setScore(Double.parseDouble(scanner.nextLine()));
                break;
            default:
                System.out.println("Không hợp lệ!");
        }
    }

    public void searchByName(String keyword) {
        List<User> result = userList.stream().filter(u -> u.getUserName().toLowerCase()
                        .contains(keyword.toLowerCase())).collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy!");
        } else {
            result.forEach(User::displayData);
            System.out.println("Tổng: " + result.size());
        }
    }

    public void deleteUser(String id) {
        int sizeBefore = userList.size();
        userList.removeIf(u -> u.getUserId().equals(id));
        if (sizeBefore == userList.size()) {
            System.out.println("Mã không tồn tại!");
        } else {
            System.out.println("Xóa thành công!");
        }
    }

    public void filterAdmin() {
        List<User> admins = userList.stream()
                .filter(u -> u.getRole().equalsIgnoreCase("ADMIN"))
                .collect(Collectors.toList());

        admins.forEach(User::displayData);
    }

    public void sortByScoreDesc() {
        userList = userList.stream()
                .sorted((a, b) -> Double.compare(b.getScore(), a.getScore()))
                .collect(Collectors.toList());

        displayAll();
    }
}
