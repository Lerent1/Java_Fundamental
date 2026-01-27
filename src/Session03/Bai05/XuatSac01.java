package Session03.Bai05;

import java.util.Scanner;

public class XuatSac01 {
    public static void main(String[] args) {
        Scanner xs01 = new Scanner(System.in);
        int[] books = {101, 102, 103, 104, 105};
        int n = books.length;

        while (n > 0) {
            System.out.print("Danh sach ma sach: ");
            for (int i = 0; i < n; i++) {
                System.out.print(books[i] + " ");
            }
            System.out.println();

            System.out.print("Hay nhap ma sach can xoa (0 de dung lai): ");
            int bookId = xs01.nextInt();
            if (bookId == 0) {
                break;
            }

            int pos = -1;
            for (int i = 0; i < n; i++) {
                if (books[i] == bookId) {
                    pos = i;
                    break;
                }
            }

            if (pos == -1) {
                System.out.println("Khong tim thay ma sach");
                continue;
            }
            for (int i = pos; i < n - 1; i++) {
                books[i] = books[i + 1];
            }
            n--;

            System.out.println("Da xoa sach ma " + bookId);
        }
    }
}
