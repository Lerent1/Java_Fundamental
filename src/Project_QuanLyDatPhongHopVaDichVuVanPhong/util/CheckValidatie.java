package Project_QuanLyDatPhongHopVaDichVuVanPhong.util;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckValidatie {
    private static final Scanner sc = new Scanner(System.in);

    public static String inputRequired(String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Loi: Khong duoc de trong");
            } else {
                return input;
            }
        }
    }

    public static int inputPositiveInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                int value = Integer.parseInt(sc.nextLine());

                if (value <= 0) {
                    System.out.println("Loi: Phai nhap so duong");
                } else {
                    return value;
                }

            } catch (Exception e) {
                System.out.println("Loi: Phai nhap so");
            }
        }
    }

    public static String inputEmail(String message) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

        while (true) {
            String email = inputRequired(message);

            if (!Pattern.matches(regex, email)) {
                System.out.println("Email khong hop le");
            } else {
                return email;
            }
        }
    }

    public static String inputPhone(String message) {
        String regex = "^0\\d{9}$";

        while (true) {
            String phone = inputRequired(message);

            if (!Pattern.matches(regex, phone)) {
                System.out.println("SDT khong hop le");
            } else {
                return phone;
            }
        }
    }
}