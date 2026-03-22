package Session11.Cau05;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class XuatSac01 {
    private static final DoctorBusiness doctorBusiness = new DoctorBusiness();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            showMenu();
            int choice = inputChoice();

            switch (choice) {
                case 1:
                    displayDoctors();
                    break;
                case 2:
                    addNewDoctor();
                    break;
                case 3:
                    statisticsBySpecialty();
                    break;
                case 4:
                    System.out.println("Đã thoát chương trình.");
                    return;
                default:
                    System.out.println("Vui lòng chọn từ 1 đến 4.");
            }
        } while (true);
    }

    private static void showMenu() {
        System.out.println("\n========== HỆ THỐNG QUẢN LÝ BÁC SĨ TRỰC CA ==========");
        System.out.println("1. Xem danh sách bác sĩ");
        System.out.println("2. Thêm bác sĩ mới");
        System.out.println("3. Thống kê chuyên khoa");
        System.out.println("4. Thoát chương trình");
        System.out.print("Nhập lựa chọn của bạn: ");
    }

    private static int inputChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    private static void displayDoctors() {
        List<Doctor> doctors = doctorBusiness.getAllDoctors();

        if (doctors.isEmpty()) {
            System.out.println("Danh sách bác sĩ đang trống.");
            return;
        }

        System.out.println("\n===== DANH SÁCH BÁC SĨ =====");
        System.out.printf("%-10s %-25s %-20s%n", "Mã số", "Họ tên", "Chuyên khoa");
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

    private static void addNewDoctor() {
        try {
            System.out.println("\n===== THÊM BÁC SĨ MỚI =====");
            System.out.print("Nhập mã bác sĩ: ");
            String doctorId = scanner.nextLine().trim();

            System.out.print("Nhập họ tên bác sĩ: ");
            String fullName = scanner.nextLine().trim();

            System.out.print("Nhập chuyên khoa: ");
            String specialty = scanner.nextLine().trim();

            Doctor doctor = new Doctor(doctorId, fullName, specialty);
            boolean result = doctorBusiness.addDoctor(doctor);

            if (result) {
                System.out.println("Thêm bác sĩ mới thành công.");
            } else {
                System.out.println("Thêm bác sĩ thất bại.");
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private static void statisticsBySpecialty() {
        Map<String, Integer> statistics = doctorBusiness.getDoctorStatisticsBySpecialty();

        if (statistics.isEmpty()) {
            System.out.println("Chưa có dữ liệu để thống kê.");
            return;
        }

        System.out.println("\n===== THỐNG KÊ THEO CHUYÊN KHOA =====");
        System.out.printf("%-20s %-10s%n", "Chuyên khoa", "Số lượng");

        for (Map.Entry<String, Integer> entry : statistics.entrySet()) {
            System.out.printf("%-20s %-10d%n", entry.getKey(), entry.getValue());
        }
    }
}