package Session02.Bai04;

import java.util.Scanner;

public class Gioi02 {
    public static void main(String[] args) {
        Scanner gioi02 = new Scanner(System.in);

        int id;
        do {
            System.out.println("Hay nhap id: ");
            id = gioi02.nextInt();

            if (id <= 0) {
                System.out.println("Mã không hợp lệ, hãy nhập lại");
            }

        } while (id <= 0);

        System.out.println("Lưu mã sách thành công");
    }
}
