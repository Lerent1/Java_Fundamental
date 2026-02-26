package Session13.Bai06;

import java.util.Scanner;

public class XuatSac02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Service service = new Service();

        while (true) {
            System.out.println("1. Them thuoc");
            System.out.println("2. Dieu chinh so luong");
            System.out.println("3. Xoa thuoc");
            System.out.println("4. In hoa don");
            System.out.println("5. Tim thuoc gia re (<50000)");
            System.out.println("6. Thoat");
            System.out.print("Chon: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Ma thuoc: ");
                    String id = sc.nextLine();
                    System.out.print("Ten thuoc: ");
                    String name = sc.nextLine();
                    System.out.print("Don gia: ");
                    double price = Double.parseDouble(sc.nextLine());
                    System.out.print("So luong: ");
                    int quantity = Integer.parseInt(sc.nextLine());
                    service.addMedicine(new Medicine(id, name, price, quantity));
                    break;
                case 2:
                    System.out.print("Nhap ma thuoc: ");
                    String updateId = sc.nextLine();
                    System.out.print("So luong moi: ");
                    int newQty = Integer.parseInt(sc.nextLine());
                    service.updateQuantity(updateId, newQty);
                    break;
                case 3:
                    System.out.print("Nhap ma thuoc can xoa: ");
                    service.removeMedicine(sc.nextLine());
                    break;
                case 4:
                    service.printInvoice();
                    break;
                case 5:
                    service.findCheapMedicines();
                    break;
                case 6:
                    System.out.println("Thoat chuong trinh.");
                    return;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
    }
}