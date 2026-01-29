package Session05;

import java.util.Scanner;

public class Baitapthuchanh {
    static void lastZero(int[] a) {
        int position = 0;
        // Dua cac so khac 0 ve dau mang
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                a[position] = a[i];
                position++;
            }
        }
        // Dua so 0 ve cuoi mang
        for (int i = position; i < a.length; i++) {
            a[i] = 0;
        }
    }

//    static void lastZero(int[] a) {
//        int j = 0; // vi tri cua so 0
//
//        for (int i = 0; i < a.length; i++) {
//            if (a[i] != 0) {
//                int temp = a[i];
//                a[i] = a[j];
//                a[j] = temp;
//                j++;
//            }
//        }
//    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while(choice != 6){
            System.out.println("------MENU------");
            System.out.println("1.Tim cap so co tong bang K ");
            System.out.println("2.Don so 0 ve cuoi: ");
            System.out.println("3.Kiem tra chuoi doi xung");
            System.out.println("4.Dao nguoc tu trong cau");
            System.out.println("5.So hanh phuc ");
            System.out.println("6.Thoat chuong trinh");
            System.out.printf("Lua chon cua ban: ");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    break;
                case 2:
                    System.out.print("Hay nhap so phan tu cua mang: ");
                    int num = sc.nextInt();

                    int[] a = new int[num];
                    System.out.println("Hay nhap cac phan tu cua mang:");
                    for (int i = 0; i < num; i++) {
                        System.out.print("Phan tu thu " + ( i + 1 ) + " la: ");
                        a[i] = sc.nextInt();
                    }
                    lastZero(a);

                    System.out.println("Mang sau khi don so 0 ve cuoi la:");
                    for (int i = 0; i < a.length; i++) {
                        System.out.print(a[i] + " ");
                    }
                    System.out.println();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!!");
            }
        }
    }
}
