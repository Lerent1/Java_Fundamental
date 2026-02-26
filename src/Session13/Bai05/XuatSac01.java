package Session13.Bai05;

import java.util.Scanner;

public class XuatSac01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Service service = new Service();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Tiep nhan benh nhan");
            System.out.println("2. Cap nhat chan doan");
            System.out.println("3. Xuat vien");
            System.out.println("4. Sap xep danh sach");
            System.out.println("5. Hien thi danh sach");
            System.out.println("6. Thoat");
            System.out.print("Chon: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhap ID: ");
                    String id = sc.nextLine();

                    if (service.isDuplicateId(id)) {
                        System.out.println("ID da ton tai!");
                        break;
                    }

                    System.out.print("Nhap ho ten: ");
                    String name = sc.nextLine();

                    System.out.print("Nhap tuoi: ");
                    int age = Integer.parseInt(sc.nextLine());

                    System.out.print("Nhap chan doan: ");
                    String diagnosis = sc.nextLine();

                    service.addPatient(new Patient(id, name, age, diagnosis));
                    System.out.println("Tiep nhan thanh cong");
                    break;

                case 2:
                    System.out.print("Nhap ID can cap nhat: ");
                    String updateId = sc.nextLine();

                    Patient p = service.findById(updateId);
                    if (p == null) {
                        System.out.println("Khong tim thay");
                    } else {
                        System.out.print("Nhap chan doan moi: ");
                        String newDiagnosis = sc.nextLine();
                        p.setDiagnosis(newDiagnosis);
                        System.out.println("Cap nhat thanh cong!");
                    }
                    break;

                case 3:
                    System.out.print("Nhap ID can xuat vien: ");
                    String removeId = sc.nextLine();
                    if (service.dischargePatient(removeId)) {
                        System.out.println("Da xuat vien!");
                    } else {
                        System.out.println("Khong tim thay!");
                    }
                    break;
                case 4:
                    service.sortPatients();
                    System.out.println("Da sap xep!");
                    break;
                case 5:
                    service.displayAll();
                    break;
                case 6:
                    System.out.println("Thoat chuong trinh.");
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }
}