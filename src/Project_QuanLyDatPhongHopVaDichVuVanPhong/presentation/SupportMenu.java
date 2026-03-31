package Project_QuanLyDatPhongHopVaDichVuVanPhong.presentation;

import Project_QuanLyDatPhongHopVaDichVuVanPhong.service.SupportService;
import java.util.Scanner;

public class SupportMenu {
    private static final Scanner sc = new Scanner(System.in);
    private static final SupportService service = new SupportService();

    public static void start(int staffId) {
        while (true) {
            System.out.println("\n===== SUPPORT =====");
            System.out.println("1. Xem cong viec");
            System.out.println("2. Cap nhap trang thai");
            System.out.println("0. Dang xuat");
            System.out.println("Lua chon cua ban la: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> service.showTasks(staffId);

                case 2 -> {
                    System.out.print("Booking ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.println("1. PREPARING");
                    System.out.println("2. READY");
                    System.out.println("3. MISSING");
                    System.out.println("Chon: ");
                    int c = Integer.parseInt(sc.nextLine());

                    String status = switch (c) {
                        case 1 -> "PREPARING";
                        case 2 -> "READY";
                        case 3 -> "MISSING";
                        default -> null;
                    };

                    if (status == null) {
                        System.out.println("Lua chon khong hop le");
                        break;
                    }

                    service.updateStatus(id, staffId, status);
                }

                case 0 -> { return; }
            }
        }
    }
}