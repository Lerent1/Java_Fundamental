package Session03.Bai01;

import java.util.Scanner;

public class Kha01 {
    public static void main(String[] args) {
        Scanner kha01 = new Scanner(System.in);

        System.out.print("Hay nhap so luong sach: ");
        int n = kha01.nextInt();

        int[] books = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Hay nhap ma sach thu " + (i + 1) + ": ");
            books[i] = kha01.nextInt();
        }

        System.out.print("Danh sach ma sach: ");
        for (int i = 0; i < n; i++) {
            System.out.print(books[i]);
            if (i < n - 1) {
                System.out.print(", ");
            }
        }
    }
}
