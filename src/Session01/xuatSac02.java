package Session01;

import java.util.Scanner;

public class xuatSac02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số thứ tự của cuốn sách: ");
        int stt = sc.nextInt();

        int number = (stt - 1) / 25 + 1;
        int position = (stt - 1) % 25 + 1;
        String area = (number <= 10) ? "Khu Cận" : "Khu Viễn";

        System.out.println("Kệ số " + number + " - Vị trí " + position + " - Khu vực " + area);
    }
}
