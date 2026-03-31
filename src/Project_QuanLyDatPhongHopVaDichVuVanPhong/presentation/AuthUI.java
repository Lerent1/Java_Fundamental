package Project_QuanLyDatPhongHopVaDichVuVanPhong.presentation;

import Project_QuanLyDatPhongHopVaDichVuVanPhong.model.User;
import Project_QuanLyDatPhongHopVaDichVuVanPhong.service.AuthService;
import Project_QuanLyDatPhongHopVaDichVuVanPhong.util.CheckValidatie;

import java.util.Scanner;

public class AuthUI {
    private static final Scanner sc = new Scanner(System.in);
    private static final AuthService authService = new AuthService();

    public static void start() {
        while (true) {
            System.out.println("\n===== HE THONG =====");
            System.out.println("1. Dang ky");
            System.out.println("2. Dang nhap");
            System.out.println("3. Thoat");
            System.out.print("Chon: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> register();
                case 2 -> login();
                case 3 -> System.exit(0);
                default -> System.out.println("Lua chon khong hop le!");
            }
        }
    }

    private static void register() {
        String username = CheckValidatie.inputRequired("Username: ");
        String password = CheckValidatie.inputRequired("Password: ");
        String fullname = CheckValidatie.inputRequired("Full name: ");

        String email;
        do {
            email = CheckValidatie.inputEmail("Email: ");
            if (authService.isEmailExist(email)) {
                System.out.println("Email da ton tai!");
                email = null;
            }
        } while (email == null);

        String phone;
        do {
            phone = CheckValidatie.inputPhone("Phone: ");
            if (authService.isPhoneExist(phone)) {
                System.out.println("SDT da ton tai!");
                phone = null;
            }
        } while (phone == null);

        boolean result = authService.register(username, password, fullname, email, phone);
        System.out.println(result ? "Dang ky thanh cong" : "That bai");
    }

    private static void login() {
        String username = CheckValidatie.inputRequired("Username: ");
        String password = CheckValidatie.inputRequired("Password: ");

        User user = authService.login(username, password);

        if (user == null) {
            System.out.println("Dang nhap that bai");
            return;
        }

        System.out.println("Dang nhap thanh cong. Vai tro: " + user.getRole());

        switch (user.getRole()) {
            case "ADMIN" -> AdminMenu.start();
            case "SUPPORT" -> SupportMenu.start(user.getId());
            default -> EmployeeMenu.start(user.getId());
        }
    }
}