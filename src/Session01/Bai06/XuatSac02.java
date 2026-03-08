package Session01.Bai06;

import java.io.IOException;
import java.util.Scanner;

public class XuatSac02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Nhap ten nguoi dung: ");
            String name = sc.nextLine();
            User user = new User(name);

            if (user.getName() != null) {
                System.out.println("Xin chao " + user.getName());
            }

            System.out.print("Nhap nam sinh: ");
            String input = sc.nextLine();

            try {
                int birthYear = Integer.parseInt(input);
                int age = 2026 - birthYear;
                user.setAge(age);
            }
            catch (NumberFormatException e) {
                Logger.logError("Nam sinh phai la so hop le!");
            }

            System.out.print("Nhap tong so nguoi: ");
            int total = sc.nextInt();

            System.out.print("Nhap so nhom: ");
            int group = sc.nextInt();

            try {
                int result = total / group;
                System.out.println("Moi nhom co: " + result + " nguoi");
            }
            catch (ArithmeticException e) {
                Logger.logError("Khong the chia cho 0!");
            }

            try {
                FileService.processUser(user);
            }
            catch (IOException e) {
                Logger.logError("Loi he thong khi ghi file: " + e.getMessage());
            }

        }
        catch (InvalidAgeException e) {
            Logger.logError("Loi nghiep vu: " + e.getMessage());
        }
        finally {
            sc.close();
            System.out.println("Thuc hien don dep tai nguyen trong finally...");
        }
        System.out.println("Chuong trinh ket thuc an toan.");
    }
}
