package Project_QuanLyDatPhongHopVaDichVuVanPhong.presentation;

import Project_QuanLyDatPhongHopVaDichVuVanPhong.dao.BookingDAO;
import Project_QuanLyDatPhongHopVaDichVuVanPhong.dao.RoomDAO;
import Project_QuanLyDatPhongHopVaDichVuVanPhong.model.Booking;
import Project_QuanLyDatPhongHopVaDichVuVanPhong.model.Room;
import Project_QuanLyDatPhongHopVaDichVuVanPhong.service.AdminService;
import Project_QuanLyDatPhongHopVaDichVuVanPhong.service.EquipmentService;
import Project_QuanLyDatPhongHopVaDichVuVanPhong.util.CheckValidatie;

import java.util.List;
import java.util.Scanner;

public class AdminMenu {
    private static final Scanner sc = new Scanner(System.in);

    private static final RoomDAO roomDAO = new RoomDAO();
    private static final BookingDAO bookingDAO = new BookingDAO();
    private static final EquipmentService equipmentService = new EquipmentService();
    private static final AdminService adminService = new AdminService();

    public static void start() {
        while (true) {
            try {
                System.out.println("\n========= ADMIN MENU =========");
                System.out.println("1. Them phong");
                System.out.println("2. Xem phong");
                System.out.println("3. Xoa phong");
                System.out.println("4. Cap nhat phong");
                System.out.println("5. Tim kiem phong");

                System.out.println("6. Them thiet bi");
                System.out.println("7. Xem thiet bi");
                System.out.println("8. Cap nhat thiet bi");
                System.out.println("9. Xoa thiet bi");

                System.out.println("10. Tao tai khoan SUPPORT");

                System.out.println("11. Xem booking cho");
                System.out.println("12. Duyet booking");
                System.out.println("13. Tu choi booking");

                System.out.println("0. Dang xuat");
                System.out.print("Lua chon cua ban la: : ");

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> addRoom();
                    case 2 -> viewRooms();
                    case 3 -> deleteRoom();
                    case 4 -> updateRoom();
                    case 5 -> searchRoom();

                    case 6 -> addEquipment();
                    case 7 -> viewEquipment();
                    case 8 -> updateEquipment();
                    case 9 -> deleteEquipment();

                    case 10 -> createSupport();

                    case 11 -> viewPending();
                    case 12 -> approveBooking();
                    case 13 -> rejectBooking();

                    case 0 -> { return; }

                    default -> System.out.println("Lua chon khong hop le!");
                }

            } catch (Exception e) {
                System.out.println("Loi nhap lieu");
            }
        }
    }

    private static void addRoom() {
        String name;

        do {
            name = CheckValidatie.inputRequired("Tên phòng: ");
            if (roomDAO.isRoomNameExist(name)) {
                System.out.println("Tên phòng đã tồn tại!");
                name = null;
            }
        } while (name == null);

        int cap = CheckValidatie.inputPositiveInt("Sức chứa: ");
        String loc = CheckValidatie.inputRequired("Vị trí: ");

        Room r = new Room();
        r.setName(name);
        r.setCapacity(cap);
        r.setLocation(loc);

        System.out.println(roomDAO.insert(r) ? "Thêm thành công" : "Thất bại");
    }

    private static void viewRooms() {
        List<Room> list = roomDAO.findAll();

        if (list.isEmpty()) {
            System.out.println("Khong co phong!");
            return;
        }

        for (Room r : list) {
            System.out.println("ID: " + r.getId() + " | " + r.getName() +
                    " | Capacity: " + r.getCapacity() + " | Location: " + r.getLocation()
            );
        }
    }

    private static void deleteRoom() {
        viewRooms();

        System.out.print("Nhap ID phong: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.println(roomDAO.delete(id) ? "Xoa thanh cong" : "That bai");
    }

    private static void updateRoom() {
        viewRooms();

        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Ten moi: ");
        String name = sc.nextLine();

        System.out.print("Suc chua: ");
        int cap = Integer.parseInt(sc.nextLine());

        System.out.print("Vi tri: ");
        String loc = sc.nextLine();

        Room r = new Room();
        r.setId(id);
        r.setName(name);
        r.setCapacity(cap);
        r.setLocation(loc);

        System.out.println(roomDAO.update(r) ? "Cap nhat thanh cong" : "That bai");
    }

    private static void searchRoom() {
        System.out.print("Nhap tu khoa (ten hoac vi tri): ");
        String keyword = sc.nextLine().toLowerCase().trim();

        List<Room> list = roomDAO.findAll();

        boolean found = false;
        for (Room r : list) {
            if (r.getName().toLowerCase().contains(keyword) ||
                    r.getLocation().toLowerCase().contains(keyword)) {

                System.out.println("ID: " + r.getId() + " | " + r.getName() +
                        " | Capacity: " + r.getCapacity() +
                        " | Location: " + r.getLocation());

                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay phong phu hop");
        }
    }

    private static void addEquipment() {
        System.out.print("Ten thiet bi: ");
        String name = sc.nextLine();

        System.out.print("Tong so luong: ");
        int total = Integer.parseInt(sc.nextLine());

        System.out.println(equipmentService.addEquipment(name, total) ? "Them thanh cong" : "That bai");
    }

    private static void viewEquipment() {
        var list = equipmentService.getAll();

        if (list.isEmpty()) {
            System.out.println("Khong co thiet bi");
            return;
        }

        for (var e : list) {
            System.out.println("ID: " + e.getId() + " | " + e.getName() + " | Tong: " + e.getTotalQuantity()
                    + " | Con: " + e.getAvailableQuantity() + " | Status: " + e.getStatus()
            );
        }
    }

    private static void updateEquipment() {
        viewEquipment();

        System.out.print("ID thiet bi: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("So luong con: ");
        int quantity = Integer.parseInt(sc.nextLine());

        System.out.println(equipmentService.updateAvailable(id, quantity) ? "Cap nhat thanh cong" : "That bai");
    }

    private static void deleteEquipment() {
        viewEquipment();

        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.println(equipmentService.delete(id) ? "Xoa thanh cong" : "That bai");
    }

    private static void createSupport() {
        System.out.print("Username: ");
        String user = sc.nextLine().trim();

        System.out.print("Password: ");
        String pass = sc.nextLine().trim();

        System.out.println(adminService.createSupport(user, pass) ? "Tao thanh cong" : "That bai");
    }

    private static void viewPending() {
        List<Booking> list = bookingDAO.findPending();

        if (list.isEmpty()) {
            System.out.println("Khong co booking cho");
            return;
        }

        for (Booking b : list) {
            System.out.println("ID: " + b.getId() + " | Room: " + b.getRoomId() + " | Status: " + b.getStatus());
        }
    }

    private static void approveBooking() {
        viewPending();

        System.out.print("Booking ID: ");
        int id = Integer.parseInt(sc.nextLine());

        Booking b = bookingDAO.findById(id);
        if (b == null) {
            System.out.println("Booking khong ton tai!");
            return;
        }

        if (!"PENDING".equals(b.getStatus())) {
            System.out.println("Booking khong o trang thai PENDING!");
            return;
        }

        viewSupportStaff();
        System.out.print("Chon Staff ID: ");
        int staffId = Integer.parseInt(sc.nextLine());

        adminService.approveBooking(id, staffId);
    }

    private static void rejectBooking() {
        viewPending();

        System.out.print("Booking ID: ");
        int id = Integer.parseInt(sc.nextLine());

        Booking b = bookingDAO.findById(id);
        if (b == null) {
            System.out.println("Booking khong ton tai!");
            return;
        }

        if (!"PENDING".equals(b.getStatus())) {
            System.out.println("Chi co the tu choi booking PENDING!");
            return;
        }

        adminService.rejectBooking(id);
    }

    private static void viewSupportStaff() {
        var list = adminService.getAllSupport();

        if (list.isEmpty()) {
            System.out.println("Khong co support nao!");
            return;
        }

        System.out.println("===== DANH SACH SUPPORT =====");
        for (var u : list) {
            System.out.println("ID: " + u.getId() + " | Username: " + u.getUsername());
        }
    }
}