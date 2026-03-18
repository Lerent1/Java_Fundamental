package Session09;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductDatabase db = new ProductDatabase();

        while(true) {
            System.out.println("\n----- Quan ly vat pham -----");
            System.out.println("1. Them san pham");
            System.out.println("2. Xem danh sach");
            System.out.println("3. Cap nhat");
            System.out.println("4. Xoa");
            System.out.println("5. Thoat");
            System.out.print("Lua chon cua ban la: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("1. Physical | 2. Digital");
                    int type = Integer.parseInt(sc.nextLine());
                    Product p = ProductFactory.createProduct(type, sc);
                    if (p != null) {
                        db.addProduct(p);
                        System.out.println("Them thanh cong");
                    }
                    break;

                case 2:
                    for (Product prod : db.getAll()) {
                        prod.displayInfo();
                    }
                    break;

                case 3:
                    System.out.print("Hay nhap id can sua: ");
                    String idUpdate = sc.nextLine();
                    Product update = db.findById(idUpdate);

                    if (update != null) {
                        System.out.print("Hay nhap ten moi: ");
                        update.setName(sc.nextLine());

                        System.out.print("Hay nhap gia moi: ");
                        update.setPrice(Double.parseDouble(sc.nextLine()));

                        System.out.println("Cap nhat thanh cong");
                    } else {
                        System.out.println("Khong tim thay");
                    }
                    break;

                case 4:
                    System.out.print("Hay nhap id can xoa: ");
                    String idDelete = sc.nextLine();
                    db.deleteProduct(idDelete);
                    break;

                case 5:
                    System.out.println("Thoat thanh cong");
                    return;

                default:
                    System.out.println("Lua chon khong hop le, vui long nhap lai");
            }
        }
    }
}
