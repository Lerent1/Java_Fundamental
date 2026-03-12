package ThucHang;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> list = new ArrayList<>();
        int choice;

        while (true) {
            System.out.println("========== Product Management System ===========");
            System.out.println("1. Them san pham moi");
            System.out.println("2. Hien thi san pham");
            System.out.println("3. Cap nhat san pham");
            System.out.println("4. Xoa san pham");
            System.out.println("5. Thoat chuong trinh");
            System.out.println("================================================");
            System.out.print("Lua chon cua ban la: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:{
                    System.out.println("Hay nhap id: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    boolean check = false;

                    for (Product item : list) {
                        if (item.getId() == id) {
                            check = true;
                        }
                    }

                    if (check) {
                        System.out.println("Id da ton tai");
                        return;
                    } else {
                        System.out.print("Hay nhap ten: ");
                        String name = sc.nextLine();
                        System.out.print("Hay nhap gia: ");
                        double price = sc.nextInt();
                        System.out.print("Hay nhap so luong ton kho: ");
                        int quantity = sc.nextInt();
                        System.out.print("Hay nhap ten danh muc: ");
                        String category = sc.nextLine();

                        Product item = new Product(id, name, price, quantity, category);
                        list.add(item);
                    }
                    break;
                }
                case 2:{
                    if (list.size() == 0) {
                        System.out.println("Danh sach rong");
                        return;
                    } else {
                        for (Product p : list) {
                            System.out.printf("%-5d %-15s %-10.2f %-10d %-15s\n", p.getId(), p.getName(),
                                    p.getPrice(), p.getQuantity(), p.getCategory());
                        }
                    }
                    break;
                }
                case 3:{
                    if (list.size() == 0) {
                        System.out.println("Danh sach rong");
                    } else {
                        System.out.println("Hay nhap id muon sua: ");
                        int search = sc.nextInt();

                        boolean found = false;
                        for (Product p : list) {
                            if (p.getId() == search) {
                                System.out.print("Nhap so luong moi: ");
                                int newQuantity = sc.nextInt();

                                p.setQuantity(newQuantity);
                                found = true;

                                System.out.println("Cap nhat thanh cong");
                            }
                        }
                        if (found) {
                            System.out.println("Khong tim thay san pham");
                        }
                    }
                    break;
                }
                case 4:{
                    if (list.size() == 0) {
                        System.out.println("Danh sach rong");
                    } else {
                        list.removeIf(p -> p.getQuantity() == 0);
                        System.out.println("Da xoa cac san pham het hang");
                    }
                    break;
                }
                case 5:{
                    System.out.println("Thoat chuong trinh thanh cong");
                    break;
                }
                default:{
                    System.out.println("Lua chon khong hop le, hay chon lai");
                }
            }
        }
    }
}
