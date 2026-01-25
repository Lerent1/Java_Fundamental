package Session01;

import java.util.Scanner;

public class Gioi02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập giá sách: ");
        double price = sc.nextDouble();
        float tygia = 25450.0f;
        double exactVND = price * tygia;
        long roundedVND = (long) exactVND;

        System.out.println("Giá chính xác (số thực): " + exactVND);
        System.out.println("Giá làm tròn để thanh toán (long): " + roundedVND);
    }
}
