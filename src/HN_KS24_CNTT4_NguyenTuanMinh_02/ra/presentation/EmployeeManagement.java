package HN_KS24_CNTT4_NguyenTuanMinh_02.ra.presentation;

import java.util.Scanner;

public class EmployeeManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            System.out.println("**************** Quan Ly Nhan Vien ******************");
            System.out.println("1. Hien thi danh sach hien toan bo nhan vien");
            System.out.println("2. Them moi nhan vien");
            System.out.println("3. Cap nhap thong tin nhan vien theo ma");
            System.out.println("4. Xoa nhan vien theo ma nhan vien");
            System.out.println("5. Tim kiem nhan vien theo ten");
            System.out.println("6. Loc danh sach nhan vien xuat sac");
            System.out.println("7. Sap xep danh sach nhan vien giam dan theo luong");
            System.out.println("8. Thoat");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:
                    System.out.println("Thoat thanh cong");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, hay chon lai");
            }
        } while(choice !=8);
    }
}
