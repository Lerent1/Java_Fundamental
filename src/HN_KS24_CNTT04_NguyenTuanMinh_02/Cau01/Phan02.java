package HN_KS24_CNTT04_NguyenTuanMinh_02.Cau01;

import java.util.Scanner;

public class Phan02 {
    public static void main(String[] args) {
        Scanner search = new Scanner(System.in);

        System.out.println("Hay nhap mot chuoi bat ky: ");
        String input = search.nextLine();
        if (input.length() <= 0) {
            System.out.println("Khong nhap noi dung");
            return;
        }

        int[] count = new int[300];
        for (int i = 0; i < input.length(); i++) {
            count[input.charAt(i)]++;
        }

        for (int i = 0; i < input.length(); i++) {
            if (count[input.charAt(i)] == 1) {
                System.out.println(input.charAt(i));
                return;
            }
        }
    }
}
