package Session12.Bai05;

import java.sql.*;
import java.util.Scanner;

public class XuatSac01 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            showMenu();
            int choice = inputChoice();

            switch (choice) {
                case 1:
                    displayPatients();
                    break;
                case 2:
                    addPatient();
                    break;
                case 3:
                    updateDisease();
                    break;
                case 4:
                    dischargeAndCalculateFee();
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (true);
    }

    public static void showMenu() {
        System.out.println("\n===== QUẢN LÝ BỆNH NHÂN NỘI TRÚ =====");
        System.out.println("1. Danh sách bệnh nhân");
        System.out.println("2. Tiếp nhận bệnh nhân mới");
        System.out.println("3. Cập nhật bệnh án");
        System.out.println("4. Xuất viện & Tính phí");
        System.out.println("5. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    public static int inputChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    public static void displayPatients() {
        String sql = "SELECT patient_id, patient_name, age, department FROM patients WHERE status = 'IN_TREATMENT'";

        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- DANH SÁCH BỆNH NHÂN ---");
            while (rs.next()) {
                System.out.printf("Mã BN: %d | Tên: %s | Tuổi: %d | Khoa: %s%n",
                        rs.getInt("patient_id"),
                        rs.getString("patient_name"),
                        rs.getInt("age"),
                        rs.getString("department"));
            }

        } catch (SQLException e) {
            System.out.println("Lỗi hiển thị danh sách bệnh nhân: " + e.getMessage());
        }
    }

    public static void addPatient() {
        String sql = "INSERT INTO patients(patient_name, age, department, disease, admission_date, status) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            System.out.print("Nhập tên bệnh nhân: ");
            String name = scanner.nextLine();

            System.out.print("Nhập tuổi: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Nhập khoa điều trị: ");
            String department = scanner.nextLine();

            System.out.print("Nhập bệnh lý: ");
            String disease = scanner.nextLine();

            System.out.print("Nhập ngày nhập viện (yyyy-mm-dd): ");
            String admissionDate = scanner.nextLine();

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, department);
            ps.setString(4, disease);
            ps.setDate(5, Date.valueOf(admissionDate));
            ps.setString(6, "IN_TREATMENT");

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Tiếp nhận bệnh nhân thành công.");
            }

        } catch (SQLException e) {
            System.out.println("Lỗi thêm bệnh nhân: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Ngày không đúng định dạng yyyy-mm-dd.");
        }
    }

    public static void updateDisease() {
        String sql = "UPDATE patients SET disease = ? WHERE patient_id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            System.out.print("Nhập mã bệnh nhân cần cập nhật: ");
            int patientId = Integer.parseInt(scanner.nextLine());

            System.out.print("Nhập bệnh lý mới: ");
            String newDisease = scanner.nextLine();

            ps.setString(1, newDisease);
            ps.setInt(2, patientId);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Cập nhật bệnh án thành công.");
            } else {
                System.out.println("Không tìm thấy bệnh nhân có mã: " + patientId);
            }

        } catch (SQLException e) {
            System.out.println("Lỗi cập nhật bệnh án: " + e.getMessage());
        }
    }

    public static void dischargeAndCalculateFee() {
        String sql = "{CALL CALCULATE_DISCHARGE_FEE(?, ?)}";

        try (Connection conn = DBUtil.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            System.out.print("Nhập mã bệnh nhân xuất viện: ");
            int patientId = Integer.parseInt(scanner.nextLine());

            cs.setInt(1, patientId);
            cs.registerOutParameter(2, Types.DOUBLE);

            cs.execute();

            double totalFee = cs.getDouble(2);
            System.out.println("Xuất viện thành công.");
            System.out.println("Tổng viện phí: " + totalFee + " VND");

        } catch (SQLException e) {
            System.out.println("Lỗi xuất viện hoặc tính phí: " + e.getMessage());
        }
    }
}