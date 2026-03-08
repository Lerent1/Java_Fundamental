package HN_KS24_CNTT4_NguyenTuanMinh_01.Cau01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cau01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        System.out.println("Hay nhap so ngay chi tieu: ");
        int day = sc.nextInt();
        if (day <= 0) {
            System.out.println("So luong phan tu khong hop le");
            return;
        }

        System.out.println("Hay nhap so chi tieu cua tung ngay: ");
        for (int i = 0; i < day; i++) {
            System.out.println("So chi tieu cua ngay thu " + (i + 1) + " la: ");
            list.add(sc.nextInt());
        }

        int sum = 0;
        for(int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        System.out.println("Tong so chi tieu la: " + sum);

        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        System.out.println("Chi tieu nhieu nhat: " + max);

        int min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < min) {
                min = list.get(i);
            }
        }
        System.out.println("Chi tieu it nhat: " + min);

        int avg = sum / day;
        System.out.println("Trung binh/ngay: " + avg);

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > avg) {
                count++;
            }
        }
        System.out.println("So ngay vuot trung binh la: " + count);
    }
}
