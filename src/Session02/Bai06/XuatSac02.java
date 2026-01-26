package Session02.Bai06;

import java.util.Scanner;

public class XuatSac02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 0;
        int min = 0;
        int total = 0;
        int date = 0;

        for (int i = 1; i <= 7; i++) {
            System.out.print("Nhap so luot muon sach ngay thu " + i + ": ");
            int luotMuon = sc.nextInt();
            if (luotMuon == 0) {
                continue;
            }
            if (date == 0) {
                max = min = luotMuon;
            } else {
                if (luotMuon > max) max = luotMuon;
                if (luotMuon < min) min = luotMuon;
            }

            total += luotMuon;
            date++;
        }

        if (date > 0) {
            double trungBinh = (double) total / date;
            System.out.println("Luot muon cao nhat: " + max);
            System.out.println("Luot muon thap nhat: " + min);
            System.out.printf("Luot muon trung binh: %.2f\n", trungBinh);
        } else {
            System.out.println("Khong co ngay nao mo cua trong tuan.");
        }
    }
}