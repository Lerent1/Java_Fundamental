package ra.presentation;

import ra.business.UserBusiness;
import ra.entity.User;

import java.util.Scanner;

public class UserManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserBusiness business = UserBusiness.getInstance();

        while (true) {
            System.out.println("************ MENU ************");
            System.out.println("1. Hiển thị");
            System.out.println("2. Thêm");
            System.out.println("3. Update");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Lọc ADMIN");
            System.out.println("7. Sắp xếp");
            System.out.println("8. Thoát");

            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    business.displayAll();
                    break;

                case 2:
                    while (true) {
                        User user = new User();
                        user.inputData(scanner);
                        business.addUser(user);

                        System.out.print("Tiếp? (y/n): ");
                        if (!scanner.nextLine().equalsIgnoreCase("y")) break;
                    }
                    break;

                case 3:
                    System.out.print("Nhập ID: ");
                    business.updateUser(scanner.nextLine(), scanner);
                    break;

                case 4:
                    System.out.print("Nhập ID: ");
                    business.deleteUser(scanner.nextLine());
                    break;

                case 5:
                    System.out.print("Nhập tên: ");
                    business.searchByName(scanner.nextLine());
                    break;

                case 6:
                    business.filterAdmin();
                    break;

                case 7:
                    business.sortByScoreDesc();
                    break;

                case 8:
                    System.exit(0);
            }
        }
    }
}