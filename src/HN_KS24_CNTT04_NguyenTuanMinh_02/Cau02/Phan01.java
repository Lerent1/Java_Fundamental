package HN_KS24_CNTT04_NguyenTuanMinh_02.Cau02;

import java.util.Scanner;

public class Phan01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hay nhap so phan tu trong mang: ");
        int num = sc.nextInt();

        int[] arr = new int[num];
        System.out.println("Hay nhap gia tri cua moi phan tu: ");
        for (int i = 0; i < num; i++) {
            System.out.println("Phan tu thu " + (i + 1) + " la: ");
            arr[i] = sc.nextInt();
        }

        System.out.println("Hay nhap vi tri muon xoa: ");
        int dele = sc.nextInt();
        for(int i = dele; i < num - 1; i++) {
            arr[i] = arr[i + 1];
        }

        for(int i = 0; i < num - 1; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}
