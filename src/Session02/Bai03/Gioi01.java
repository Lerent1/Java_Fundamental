package Session02.Bai03;

import java.util.Scanner;

public class Gioi01 {
    public static void main(String[] args) {
        Scanner gioi01 = new Scanner(System.in);

        int ban = 5000;
        int total = 0;

        System.out.println("Hay nhap so luong sach tra muon: ");
        int books = gioi01.nextInt();

        for (int i = 1; i < books; i++){
            System.out.println("Hay nhap so ngay tre cua cuon thu " + i + ":");
            int late = gioi01.nextInt();

            total += late * ban;
        }

        System.out.println("Tong tien phat la: " + total);
    }
}