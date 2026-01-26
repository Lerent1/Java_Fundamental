package Session02.Bai05;

import java.util.Scanner;

public class XuatSac01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = 100;
        int late = 0;

        System.out.println("Hay nhap so ngay tre cua moi lan tra sach (999 de ket thuc):");
        while (late != 999) {
            System.out.print("So ngay tre: ");
            late = sc.nextInt();
            if (late == 999) {
                break;
            }

            if (late <= 0) {
                score += 5;
            } else {
                score -= late * 2;
            }
        }

        System.out.println("\nTong diem uy tin: " + score);

        if (score > 120) {
            System.out.println("Xep loai: Doc gia Than thiet");
        } else if (score >= 80) {
            System.out.println("Xep loai: Doc gia Tieu chuan");
        } else {
            System.out.println("Xep loai: Doc gia can luu y");
        }
    }
}
