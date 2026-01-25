package Session01;

import java.util.Scanner;

public class Kha01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã sách: ");
        String bookID = sc.nextLine();
        System.out.print("Nhập tên sách: ");
        String bookName = sc.nextLine();
        System.out.print("Nhập năm xuất bản: ");
        int publishYear = sc.nextInt();
        System.out.print("Nhập giá tiền: ");
        double price = sc.nextDouble();
        System.out.print("Sách còn trong kho? (true/false): ");
        boolean isAvailable = sc.nextBoolean();
        int bookAge = 2026 - publishYear;
        String status = isAvailable ? "Còn sách" : "Đã mượn";

        System.out.println("Mã sách      : " + bookID);
        System.out.println("Tên sách     : " + bookName.toUpperCase());
        System.out.println("Năm XB       : " + publishYear);
        System.out.println("Tuổi thọ sách: " + bookAge + " năm");
        System.out.printf("Giá tiền     : %.2f\n", price);
        System.out.println("Tình trạng   : " + status);
    }
}
