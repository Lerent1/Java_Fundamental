package Project_QuanLyDatPhongHopVaDichVuVanPhong.presentation;

import Project_QuanLyDatPhongHopVaDichVuVanPhong.dao.RoomDAO;
import Project_QuanLyDatPhongHopVaDichVuVanPhong.model.Booking;
import Project_QuanLyDatPhongHopVaDichVuVanPhong.model.Room;
import Project_QuanLyDatPhongHopVaDichVuVanPhong.model.User;
import Project_QuanLyDatPhongHopVaDichVuVanPhong.service.BookingService;
import Project_QuanLyDatPhongHopVaDichVuVanPhong.service.UserService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class EmployeeMenu {
    private static final Scanner sc = new Scanner(System.in);
    private static final BookingService bookingService = new BookingService();
    private static final RoomDAO roomDAO = new RoomDAO();

    public static void start(int userId) {
        while (true) {
            System.out.println("\n===== MENU NHAN VIEN =====");
            System.out.println("1. Xem danh sach phong");
            System.out.println("2. Dat phong");
            System.out.println("3. Xem lich dat cua toi");
            System.out.println("4. Xem thong tin ca nhan");
            System.out.println("5. Cap nhat thong tin ca nhan");
            System.out.println("0. Dang xuat");
            System.out.print("Hay nhap lua chon: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Vui long nhap so!");
                continue;
            }

            switch (choice) {
                case 1 -> viewRooms();
                case 2 -> bookRoom(userId);
                case 3 -> myBookings(userId);
                case 4 -> viewProfile(userId);
                case 5 -> updateProfile(userId);
                case 0 -> { return; }
                default -> System.out.println("Lua chon khong hop le");
            }
        }
    }

    private static void viewRooms() {
        List<Room> list = roomDAO.findAll();

        if (list.isEmpty()) {
            System.out.println("Khong co phong nao");
            return;
        }

        list.forEach(r -> System.out.println("ID: " + r.getId() + " | Ten: " + r.getName() + " | Suc chua: " + r.getCapacity()));
    }

    private static void bookRoom(int userId) {
        try {
            viewRooms();

            System.out.print("Nhap ID phong: ");
            int roomId = Integer.parseInt(sc.nextLine());

            Room room = roomDAO.findById(roomId);
            if (room == null) {
                System.out.println("Phong khong ton tai");
                return;
            }

            System.out.print("Nhap ngay (yyyy-MM-dd): ");
            String dateStr = sc.nextLine();

            System.out.print("Nhap gio bat dau (HH:mm): ");
            String startTimeStr = sc.nextLine();

            System.out.print("Nhap gio ket thuc (HH:mm): ");
            String endTimeStr = sc.nextLine();

            System.out.print("Nhap so nguoi: ");
            int attendees = Integer.parseInt(sc.nextLine());

            if (attendees <= 0) {
                System.out.println("So nguoi phai > 0");
                return;
            }

            if (attendees > room.getCapacity()) {
                System.out.println("Vuot qua suc chua phong");
                return;
            }

            LocalDate date = java.time.LocalDate.parse(dateStr);
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

            LocalDateTime start = LocalDateTime.of(date, java.time.LocalTime.parse(startTimeStr, timeFormatter));
            LocalDateTime end = LocalDateTime.of(date, java.time.LocalTime.parse(endTimeStr, timeFormatter));

            if (!end.isAfter(start)) {
                System.out.println("Thoi gian khong hop le");
                return;
            }

            Booking b = new Booking();
            b.setUserId(userId);
            b.setRoomId(roomId);
            b.setStartTime(start);
            b.setEndTime(end);

            b.setStatus("PENDING");
            b.setPreparationStatus("NOT_READY");

            boolean result = bookingService.createBooking(b);

            System.out.println(result ? "Dat phong thanh cong" : "Trung lich hoac loi");

        } catch (Exception e) {
            System.out.println("Du lieu nhap khong hop le!");
        }
    }

    private static void myBookings(int userId) {
        List<Booking> list = bookingService.getMyBookings(userId);

        if (list.isEmpty()) {
            System.out.println("Ban chua co lich dat");
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        for (Booking b : list) {
            System.out.println("ID: " + b.getId() + " | Phong: " + b.getRoomId()
                    + " | Bat dau: " + b.getStartTime().format(formatter)
                    + " | Ket thuc: " + b.getEndTime().format(formatter)
                    + " | Trang thai: " + b.getStatus()
                    + " | Chuan bi: " + b.getPreparationStatus()
            );

            switch (b.getPreparationStatus()) {
                case "READY" ->
                        System.out.println("Phong da san sang, co the hop!");
                case "NOT_READY" ->
                        System.out.println("Phong chua san sang");
                case "MISSING" ->
                        System.out.println("Thieu thiet bi, chua the hop!");
            }
        }
    }

    private static void viewProfile(int userId) {
        User user = UserService.getUserById(userId);

        if (user == null) {
            System.out.println("Khong tim thay user");
            return;
        }

        System.out.println("===== THONG TIN CA NHAN =====");
        System.out.println("ID: " + user.getId());
        System.out.println("Username: " + user.getUsername());
        System.out.println("Ho ten: " + user.getFullname());
        System.out.println("Email: " + user.getEmail());
        System.out.println("So dien thoai: " + user.getPhone());
    }

    private static void updateProfile(int userId) {
        User user = UserService.getUserById(userId);

        if (user == null) {
            System.out.println("Khong tim thay user");
            return;
        }

        System.out.print("Nhap username moi (bo trong neu khong doi): ");
        String username = sc.nextLine().trim();

        if (!username.isEmpty()) {
            if (UserService.isUsernameExists(username) && !username.equals(user.getUsername())) {
                System.out.println("Username da ton tai!");
                return;
            }
            user.setUsername(username);
        }

        System.out.print("Nhap ho ten moi: ");
        String fullName = sc.nextLine().trim();
        if (!fullName.isEmpty()) user.setFullname(fullName);

        System.out.print("Nhap email moi: ");
        String email = sc.nextLine().trim();
        if (!email.isEmpty()) user.setEmail(email);

        System.out.print("Nhap so dien thoai moi: ");
        String phone = sc.nextLine().trim();
        if (!phone.isEmpty()) user.setPhone(phone);

        boolean result = UserService.updateUser(user);

        System.out.println(result ? "Cap nhat thanh cong" : "Cap nhat that bai");
    }
}