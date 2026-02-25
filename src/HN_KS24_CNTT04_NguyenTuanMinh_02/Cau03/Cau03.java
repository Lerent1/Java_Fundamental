package HN_KS24_CNTT04_NguyenTuanMinh_02.Cau03;

import java.util.Scanner;

public class Cau03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hay nhap so nguyen muon them vao manh thu 1: ");
        int num01 = sc.nextInt();
        int[] arr01 = new int[num01];
        for(int i = 0; i < num01; i++) {
            System.out.println("Phan tu thu " + (i + 1) + " la: ");
            arr01[i] = sc.nextInt();
        }

        System.out.println("Hay nhap so nguyen muon them vao manh thu 2: ");
        int num02 = sc.nextInt();
        int[] arr02 = new int[num02];
        for(int i = 0; i < num02; i++) {
            System.out.println("Phan tu thu " + (i + 1) + " la: ");
            arr02[i] = sc.nextInt();
        }

        for (int i = 0; i < num01; i++) {
            for (int j = i + 1; j < num01; j++) {
                if (arr01[i] == arr01[j]) {
                    for (int k = j; k < num01 - 1; k++) {
                        arr01[k] = arr01[k + 1];
                    }
                }
            }
        }

        for (int i = 0; i < num01; i++) {
            System.out.print(arr01[i]);
        }
    }
}
