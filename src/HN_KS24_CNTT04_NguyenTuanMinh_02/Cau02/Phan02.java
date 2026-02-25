package HN_KS24_CNTT04_NguyenTuanMinh_02.Cau02;

import java.util.Scanner;

public class Phan02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hay nhap so nguyen muon them vao manh: ");
        int num = sc.nextInt();
        int[] arr = new int[num];

        int input = 0;
        for(int i = 0; i < num; i++) {
            System.out.println("Phan tu thu " + (i + 1) + " la: ");
            arr[i] = sc.nextInt();
            input += arr[i];
        }

    }
}